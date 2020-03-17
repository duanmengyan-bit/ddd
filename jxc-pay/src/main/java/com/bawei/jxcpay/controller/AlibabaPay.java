package com.bawei.jxcpay.controller;



import com.alipay.api.internal.util.AlipaySignature;
import com.bawei.jxcpay.config.PayConfig;
import lombok.extern.slf4j.Slf4j;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alibaba/qrcode/pay")
@Slf4j
public class AlibabaPay {

    @Autowired
    PayConfig payConfig;

    @RequestMapping("/callBack")
    public void callBack(HttpServletRequest request, HttpServletResponse response) throws IOException {



        log.debug("支付宝扫码支付回调开始:..................");
        log.debug("通知时间:{}",request.getParameter("notify_time"));
        log.debug("通知类型:{}",request.getParameter("notify_type"));
        log.debug("通知校验ID:{}",request.getParameter("notify_id"));
        log.debug("签名类型:{}",request.getParameter("sign_type"));
        log.debug("签名:{}",request.getParameter("sign"));
        log.debug("支付宝交易号:{}",request.getParameter("trade_no"));
        log.debug("开发者的app_id:{}",request.getParameter("app_id"));
        log.debug("商户订单号:{}",request.getParameter("out_trade_no"));
        log.debug("商户业务号:{}",request.getParameter("out_biz_no"));
        log.debug("买家支付宝用户号:{}",request.getParameter("buyer_id"));
        log.debug("买家支付宝账号:{}",request.getParameter("buyer_logon_id"));
        log.debug("卖家支付宝用户号:{}",request.getParameter("seller_id"));
        log.debug("卖家支付宝账号:{}",request.getParameter("seller_email"));
        log.debug("交易状态:{}",request.getParameter("trade_status"));
        log.debug("订单金额:{}",request.getParameter("total_amount"));
        log.debug("实收金额:{}",request.getParameter("receipt_amount"));
        log.debug("开票金额:{}",request.getParameter("invoice_amount"));
        log.debug("付款金额:{}",request.getParameter("buyer_pay_amount"));
        log.debug("集分宝金额:{}",request.getParameter("point_amount"));
        log.debug("总退款金额:{}",request.getParameter("refund_fee"));
        log.debug("实际退款金额:{}",request.getParameter("send_back_fee"));
        log.debug("订单标题:{}",request.getParameter("subject"));
        log.debug("通知时间:{}",request.getParameter("notify_time"));
        log.debug("商品描述:{}",request.getParameter("body"));
        log.debug("交易创建时间:{}",request.getParameter("gmt_create"));
        log.debug("交易付款时间:{}",request.getParameter("gmt_payment"));
        log.debug("交易退款时间:{}",request.getParameter("gmt_refund"));
        log.debug("交易结束时间:{}",request.getParameter("gmt_close"));
        log.debug("支付金额信息:{}",request.getParameter("fund_bill_list"));


        Map<String,String> params = new HashMap<>();
        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            params.put(entry.getKey(),entry.getValue()[0]);
        }
        try {

            //校验阶段
            //1  数字签名校验 安全  作用是此次请求是不是支付宝的请求,请求参数有没有被篡改
            /**
             @param params 参数列表(包括待验签参数和签名值sign) key-参数名称 value-参数值
             @param publicKey 验签公钥
             @param charset 验签字符集
             **/
            if (Security.getProvider("BC") == null) {
                Security.addProvider(new BouncyCastleProvider());
            }
//公钥证书方式
            boolean result = AlipaySignature.rsaCertCheckV1(params, payConfig.getAlipayCertPath(), "UTF-8","RSA2");
            if (!result){
                log.info("验签失败.......");
                return;
            }
            //2  判断订单号是否存在  订单号如果不存在 打印日志  return
            //3  判断订单状态是不是未支付或者部分支付  如果不是这两种状态 打印日志 return
            //4  支付宝返回的金额和数据库中的金额是否一致 如果不一致 打印日志  return
            //校验完成  处理业务逻辑
            //修改订单状态 由未支付变成已支付  给用户增加积分\发放优惠价\通知仓库进行发货\增加会员等级
        }catch (Exception ex){
            ex.printStackTrace();
            log.info("支付宝扫码支付回调出现异常");
            return;
        }
        response.getWriter().write("success");
        log.info("支付宝扫码支付回调结束:..................");

    }
}

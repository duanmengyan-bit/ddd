package com.bawei.jxcbiz.web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.baiwei.jxc.alibabapay.qrcode.service.AlibabapayQrCodeService;
import com.bawei.jxcbiz.entity.Ding;
import com.bawei.jxcbiz.service.AlibabaPayService;
import com.bawei.jxcbiz.service.IDingService;
import com.bawei.jxccommon.Dto.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/biz/alibaba/pay")
@Slf4j
public class AlibabaPayController {

    @Autowired
    AlibabaPayService alibabaPayService;

    @Autowired
    AlibabapayQrCodeService alibabapayQrCodeService;

    @Autowired
    IDingService iDingService;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/createPayOrder")
    public ResultEntity createPayOrder(String orderNo) throws AlipayApiException {

        log.info("创建支付宝扫码订单开始订单号为:{}",orderNo);
        if (redisTemplate.hasKey(orderNo)){
            String qrcode  = redisTemplate.opsForValue().get(orderNo);
            log.info("根据orderNo:{}到redis 中查询二维码:{}",orderNo,qrcode);
            return ResultEntity.ok("创建支付宝扫码支付订单成功",qrcode);
        }

        log.info("根据orderNo到redis查询二维码不存在开始调用支付宝的接口创建预支付订单......");

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
        Map<String,String> map = new HashMap<>();
        map.put("out_trade_no",orderNo);
        map.put("trade_no",orderNo);
        map.put("total_amount","0.01");
        map.put("subject","Iphone6 16G");
        map.put("store_id","2088102180159476");
        map.put("timeout_express","7200m");
        Ding ding = new Ding();

        ding.setOrderNo(orderNo);
        ding.setStoreId("188829128229222");
        ding.setTotalAmount("0.01");
        ding.setStatu(1);
        ding.setSubject("Iphone6 16G");
      //  System.err.println("-------------------------------->"+ding);
       // iDingService.insertinto(ding);

        AlipayTradePrecreateResponse qrCodePayOrder = alibabapayQrCodeService.createQrCodePayOrder(map);

        String qrcode = alibabaPayService.getAlibabaPayQRCode(qrCodePayOrder);
        log.info("创建支付宝扫码订单结束订单号为:{}",orderNo);

        return ResultEntity.ok("创建支付宝扫码支付订单成功",qrcode);
    }




}

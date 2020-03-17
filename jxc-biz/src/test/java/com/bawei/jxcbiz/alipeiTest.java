//package com.bawei.jxcbiz;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.CertAlipayRequest;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.request.AlipayTradePrecreateRequest;
//import com.alipay.api.request.AlipayTradeQueryRequest;
//import com.alipay.api.response.AlipayTradePrecreateResponse;
//import com.alipay.api.response.AlipayTradeQueryResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.time.DateFormatUtils;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@SpringBootTest
//public class alipeiTest {
//
//    @Autowired
//    PayConfig payConfig;
//
//    @Test
//    public void payTest() throws AlipayApiException {
//        //构造client
//        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
//        //设置网关地址
//        certAlipayRequest.setServerUrl(payConfig.getUrl());
//        //设置应用Id
//        certAlipayRequest.setAppId(payConfig.getAppid());
//        //设置应用私钥
//        certAlipayRequest.setPrivateKey(payConfig.getPrivateKey());
//        //设置请求格式，固定值json
//        certAlipayRequest.setFormat("json");
//        //设置字符集
//        certAlipayRequest.setCharset("utf-8");
//        //设置签名类型
//        certAlipayRequest.setSignType("RSA2");
//        //设置应用公钥证书路径
//        certAlipayRequest.setCertPath(payConfig.getAppCertPath());
//        //设置支付宝公钥证书路径
//        certAlipayRequest.setAlipayPublicCertPath(payConfig.getAlipayCertPath());
//        //设置支付宝根证书路径
//        certAlipayRequest.setRootCertPath(payConfig.getAlipayRootCertPath());
//        //构造client
//        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
//        //构造API请求
//        //AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//
//
//        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
//        Map<String,String> map = new HashMap<>();
//        map.put("out_trade_no","99998788666");
//        map.put("trade_no","");
//        map.put("total_amount","0.01");
//        map.put("subject","Iphone6 16G");
//        map.put("store_id","NJ_002");
//        map.put("timeout_express","7200m");
//        request.setBizContent(JSON.toJSONString(map));//订单允许的最晚付款时间
//
//
//        //发送请求
//        AlipayTradePrecreateResponse alipayTradePrecreateResponse = alipayClient.certificateExecute(request);
//        log.info("请求支付宝返回的结果为:{}",alipayTradePrecreateResponse.getBody());
//    }
//
//    public static void main(String[] args) {
//        String yyyyMMddHHmmss = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
//        System.out.println(yyyyMMddHHmmss);
//    }
//}

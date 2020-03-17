package com.bawei.jxcbiz.service;

import com.alipay.api.response.AlipayTradePrecreateResponse;


public interface AlibabaPayService {


    String getAlibabaPayQRCode(AlipayTradePrecreateResponse qrCodePayOrder);
}

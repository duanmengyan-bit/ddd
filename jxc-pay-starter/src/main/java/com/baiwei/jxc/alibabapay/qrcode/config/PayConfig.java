package com.baiwei.jxc.alibabapay.qrcode.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jxc.pay")
@Data
public class PayConfig {

    private boolean isPay;
}

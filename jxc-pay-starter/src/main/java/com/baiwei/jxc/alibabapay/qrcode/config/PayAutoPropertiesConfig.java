package com.baiwei.jxc.alibabapay.qrcode.config;

import com.baiwei.jxc.alibabapay.qrcode.service.AlibabapayQrCodeService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {PayConfig.class})
@ConditionalOnClass(AlibabapayQrCodeService.class)
public class PayAutoPropertiesConfig {

    @Bean
    @ConditionalOnProperty(prefix ="jxc.pay",name = "isPay",havingValue ="true" )
    @ConditionalOnMissingBean
    public AlibabapayQrCodeService alibabapayQrCodeService(){
        return new AlibabapayQrCodeService();
    }
}

package com.bawei.jxcauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "com.bawei.jxcauth.mapper")
public class JxcAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JxcAuthApplication.class, args);
    }

}

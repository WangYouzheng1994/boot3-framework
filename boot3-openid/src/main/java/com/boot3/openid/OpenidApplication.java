/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.boot3.openid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 认证中心
 * 开启fenclients
 */
@EnableFeignClients(basePackages = {"com.boot3" })
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Slf4j
public class OpenidApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenidApplication.class, args);
        log.info("boot3-openid startup!");
    }

}

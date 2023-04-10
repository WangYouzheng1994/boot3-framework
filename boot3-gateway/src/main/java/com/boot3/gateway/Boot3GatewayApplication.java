/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.boot3.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 网关 - 不需要数据源的自动装备，否则会报找不到url地址的配置的错误
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Boot3GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot3GatewayApplication.class, args);
    }

}

/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */
package com.boot3.system;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
// import com.ruoyi.common.security.annotation.EnableRyFeignClients;
// import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 系统模块
 *
 * @author Raise
 */
@EnableCustomConfig
// @EnableCustomSwagger2
// @EnableRyFeignClients
@EnableFeignClients
@SpringBootApplication()
@Slf4j
public class BizSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BizSystemApplication.class, args);
        log.info("boot3-biz-system is started");
    }
}

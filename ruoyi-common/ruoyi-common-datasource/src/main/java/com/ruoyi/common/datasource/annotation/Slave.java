/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.ruoyi.common.datasource.annotation;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.lang.annotation.*;

/**
 * 从库数据源
 *
 * @author ruoyi
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DS("slave")
public @interface Slave {

}
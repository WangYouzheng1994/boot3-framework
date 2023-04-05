/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.ruoyi.common.core.exception.auth;

/**
 * 未能通过的登录认证异常
 *
 * @author ruoyi
 */
public class NotLoginException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotLoginException(String message) {
        super(message);
    }
}

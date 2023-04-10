/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.ruoyi.common.core.exception;

/**
 * 验证码错误异常类
 *
 * @author ruoyi
 */
public class CaptchaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CaptchaException(String msg) {
        super(msg);
    }
}

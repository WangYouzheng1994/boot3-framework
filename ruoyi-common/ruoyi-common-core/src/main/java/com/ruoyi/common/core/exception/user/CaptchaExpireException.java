/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.ruoyi.common.core.exception.user;

/**
 * 验证码失效异常类
 *
 * @author ruoyi
 */
public class CaptchaExpireException extends UserException {
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException() {
        super("user.jcaptcha.expire", null);
    }
}

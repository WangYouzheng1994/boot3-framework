/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.ruoyi.common.core.exception;

/**
 * 内部认证异常
 *
 * @author ruoyi
 */
public class InnerAuthException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InnerAuthException(String message) {
        super(message);
    }
}

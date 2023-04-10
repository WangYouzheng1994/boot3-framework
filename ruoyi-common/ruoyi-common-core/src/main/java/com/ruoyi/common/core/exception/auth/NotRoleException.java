/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.ruoyi.common.core.exception.auth;

import org.apache.commons.lang3.StringUtils;

/**
 * 未能通过的角色认证异常
 *
 * @author ruoyi
 */
public class NotRoleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotRoleException(String role) {
        super(role);
    }

    public NotRoleException(String[] roles) {
        super(StringUtils.join(roles, ","));
    }
}

/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.ruoyi.common.core.exception.file;

import com.ruoyi.common.core.exception.base.BaseException;

/**
 * 文件信息异常类
 *
 * @author ruoyi
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}

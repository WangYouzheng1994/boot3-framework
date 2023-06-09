/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.ruoyi.common.log.service;

import com.boot3.system.api.RemoteLogService;
import com.boot3.system.api.domain.SysOperLog;
import com.ruoyi.common.core.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步调用日志服务
 *
 * @author ruoyi
 */
@Service
public class AsyncLogService {
    @Autowired
    private RemoteLogService remoteLogService;

    /**
     * 保存系统日志记录
     */
    @Async
    public void saveSysLog(SysOperLog sysOperLog) {
        remoteLogService.saveLog(sysOperLog, SecurityConstants.INNER);
    }
}

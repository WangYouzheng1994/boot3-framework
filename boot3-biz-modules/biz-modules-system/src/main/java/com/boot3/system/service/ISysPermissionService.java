/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.boot3.system.service;

import com.boot3.system.api.domain.SysUser;

import java.util.Set;

/**
 * 权限信息 服务层
 *
 * @author Raise
 */
public interface ISysPermissionService {
    /**
     * 获取角色数据权限
     *
     * @param userId 用户Id
     * @return 角色权限信息
     */
    public Set<String> getRolePermission(SysUser user);

    /**
     * 获取菜单数据权限
     *
     * @param userId 用户Id
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(SysUser user);
}

/*
 * Copyright(c) 2023-2025 QingDao Raise Technology Co., Ltd. All Rights Reserved.
 */

package com.ruoyi.common.log.filter;

import com.alibaba.fastjson2.filter.SimplePropertyPreFilter;

/**
 * 排除JSON敏感属性
 *
 * @author ruoyi
 */
public class PropertyPreExcludeFilter extends SimplePropertyPreFilter {
    public PropertyPreExcludeFilter() {
    }

    public PropertyPreExcludeFilter addExcludes(String... filters) {
        for (int i = 0; i < filters.length; i++) {
            this.getExcludes().add(filters[i]);
        }
        return this;
    }
}

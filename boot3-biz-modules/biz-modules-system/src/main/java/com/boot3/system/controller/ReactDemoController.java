package com.boot3.system.controller;

import com.boot3.system.domain.SysConfig;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: WangYouzheng
 * @Date: 2023/5/6 17:15
 * @Version: V1.0
 */
@RestController
@RequestMapping("/demo")
public class ReactDemoController {
    @GetMapping("/list")
    public AjaxResult list() {
        // startPage();
        // List<SysConfig> list = configService.selectConfigList(config);
        return AjaxResult.success(List.of(1,2,3,4));
        // return getDataTable(list);
    }
}

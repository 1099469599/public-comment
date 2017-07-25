package com.cheng.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 初始化页面
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    /**
     * 默认跳转主页
     */
    @RequestMapping
    public String init() {
        return "/system/index";
    }
}
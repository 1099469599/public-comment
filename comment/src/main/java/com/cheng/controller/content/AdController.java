package com.cheng.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 广告模块控制层
 * Created by cheng on 2017/7/22.
 */
@Controller
@RequestMapping("/ad")
public class AdController {

    /**
     * 列表页跳转
     */
    @RequestMapping
    public String initList() {
        return "/content/adList";
    }

    /**
     * 新增页跳转
     */
    @RequestMapping(value = "/addinit", method = RequestMethod.GET)
    public String initModify() {
        return "/content/adAdd";
    }
}
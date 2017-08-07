package com.cheng.controller.system;

import com.cheng.constant.DicTypeConst;
import com.cheng.service.impl.DicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权限管理控制层
 * Created by cheng on 2017/7/22.
 */

@RequestMapping("/auth")
@Controller
public class AuthController {

    @Autowired
    private DicServiceImpl dicService;

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("httpMethodList", dicService.getListByType(DicTypeConst.HTTP_METHOD));
        return "/system/auth";
    }
}

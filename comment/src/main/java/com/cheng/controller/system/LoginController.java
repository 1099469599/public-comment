package com.cheng.controller.system;

import com.cheng.constant.PageCodeEnum;
import com.cheng.constant.SessionKeyConst;
import com.cheng.dto.UserDto;
import com.cheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 用户登录
 * Created by cheng on 2017/7/22.
 */
@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录页面
     */
    @RequestMapping
    public String index() {
        return "/system/login";
    }

    /**
     * session超时
     */
    @RequestMapping("sessionTimeOut")
    public String sessionTimeOut(Model model) {
        model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.SESSION_TIMEOUT);
        return "/system/login";
    }

    /**
     * 验证用户名/密码是否正确，验证通过跳转至后台管理页面，验证失败，返回至登录页
     */
    @RequestMapping("/validate")
    public String validate(UserDto userDto, RedirectAttributes attr, HttpSession session) {
        if (userService.validate(userDto)) {
            session.setAttribute(SessionKeyConst.USER_INFO, userDto);
            return "redirect:/index";
        }
        attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.LOGIN_FAIL);
        return "redirect:/login";
    }
}

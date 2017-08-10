package com.cheng.controller.system;

import com.cheng.constant.PageCodeEnum;
import com.cheng.constant.SessionKeyConst;
import com.cheng.dto.GroupDto;
import com.cheng.dto.UserDto;
import com.cheng.service.UserService;
import com.cheng.service.impl.GroupServiceImpl;
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

    @Autowired
    private GroupServiceImpl groupService;

    @Autowired
    private HttpSession session;

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
    @RequestMapping("/sessionTimeOut")
    public String sessionTimeOut(Model model) {
        model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.SESSION_TIMEOUT);
        return "/system/sessionTimeOut";
    }

    @RequestMapping("/noAuth")
    public String noAuth(Model model) {
        model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.NO_AUTH);
        session.invalidate();
        return "/system/error";
    }

    /**
     * 验证用户名/密码是否正确，验证通过跳转至后台管理页面，验证失败，返回至登录页
     */
    @RequestMapping("/validate")
    public String validate(UserDto userDto, RedirectAttributes attr, HttpSession session) {
        if (userService.validate(userDto)) {
            session.setAttribute(SessionKeyConst.USER_INFO, userDto);
            GroupDto groupDto = groupService.getByIdWithMenuAction(userDto.getGroupId());
            session.setAttribute(SessionKeyConst.MENU_INFO, groupDto);
            session.setAttribute(SessionKeyConst.ACTION_INFO, groupDto.getActionDtoList());
            return "redirect:/index";
        }
        attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.LOGIN_FAIL);
        return "redirect:/login";
    }
}

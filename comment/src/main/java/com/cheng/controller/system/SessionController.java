package com.cheng.controller.system;

import com.cheng.constant.SessionKeyConst;
import com.cheng.dto.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * session相关，从session中获取存放的资源
 * Created by cheng on 2017/7/22.
 */
@RequestMapping("/session")
@RestController
public class SessionController {

    @Autowired
    private HttpSession session;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public List<MenuDto> getUserMenuList(MenuDto menuDto) {
        return (List<MenuDto>) session.getAttribute(SessionKeyConst.MENU_INFO);
    }

    /**
     * 退出系统
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public String signOut() {
        session.invalidate();
        return "redirect:/login";
    }
}

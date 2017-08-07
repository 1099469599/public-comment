package com.cheng.controller.system;

import com.cheng.dto.MenuForZtreeDto;
import com.cheng.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单相关控制层
 * Created by cheng on 2017/7/22.
 */

@RequestMapping("/menus")
@RestController
public class MenusController {

    @Autowired
    private MenuServiceImpl menuService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MenuForZtreeDto> getList() {
        return menuService.getZtreeList();
    }
}

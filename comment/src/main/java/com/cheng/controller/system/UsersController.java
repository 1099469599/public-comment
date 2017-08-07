package com.cheng.controller.system;

import com.cheng.dto.UserDto;
import com.cheng.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户相关
 * Created by cheng on 2017/7/22.
 */
@RequestMapping("/users")
@RestController
public class UsersController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getList() {
        return userService.getList();
    }
}

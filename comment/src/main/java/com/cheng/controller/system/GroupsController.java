package com.cheng.controller.system;

import com.cheng.dto.GroupDto;
import com.cheng.service.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户组相关
 * Created by cheng on 2017/7/22.
 */
@RequestMapping("/groups")
@RestController
public class GroupsController {

    @Autowired
    private GroupServiceImpl groupService;

    @RequestMapping(method = RequestMethod.GET)
    public List<GroupDto> getList() {
        return groupService.getList();
    }
}

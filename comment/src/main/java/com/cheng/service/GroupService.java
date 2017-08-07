package com.cheng.service;

import com.cheng.dto.GroupDto;

import java.util.List;

/**
 * 用户组相关业务层接口
 * Created by cheng on 2017/7/22.
 */
public interface GroupService {
    /**
     * 获取用户组列表
     * @return 用户组列表
     */
    List<GroupDto> getList();
}

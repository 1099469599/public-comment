package com.cheng.service;

import com.cheng.dto.MenuForZtreeDto;

import java.util.List;

/**
 * 菜单相关业务层接口
 * Created by cheng on 2017/7/22.
 */
public interface MenuService {

    /**
     * 获取菜单树列表
     *
     * @return 菜单树列表
     */
    List<MenuForZtreeDto> getZtreeList();
}

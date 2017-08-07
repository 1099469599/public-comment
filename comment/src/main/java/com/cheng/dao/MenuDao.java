package com.cheng.dao;

import com.cheng.bean.Menu;

import java.util.List;

/**
 * 菜单相关持久层接口
 * Created by cheng on 2017/7/22.
 */
public interface MenuDao {
    /**
     * 根据查询条件查询菜单列表(关联动作表，结果集里包含了动作列表)
     * @param menu
     * @return 菜单列表
     */
    List<Menu> selectWithAction(Menu menu);
}

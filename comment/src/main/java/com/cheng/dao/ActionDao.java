package com.cheng.dao;

import com.cheng.bean.Action;

/**
 * 动作相关持久层接口
 * Created by dell-pc on 2017/8/10.
 */
public interface ActionDao {

    /**
     * 根据菜单id删除动作
     *
     * @param menuId 菜单id
     * @return 影响行数
     */
    int deleteByMenuId(Long menuId);

    /**
     * 根据主键删除动作
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 新增
     *
     * @param action
     * @return 影响行数
     */
    int insert(Action action);

    /**
     * 修改
     *
     * @param action
     * @return 影响行数
     */
    int update(Action action);

    /**
     * 根据主键获取动作实体
     *
     * @param id 主键
     * @return 动作实体
     */
    Action selectById(Long id);
}

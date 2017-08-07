package com.cheng.bean;

import java.util.List;

/**
 * 用户组表实体
 * Created by cheng on 2017/7/22.
 */
public class Group {

    /**
     * 主键
     */
    private Long id;
    /**
     * 用户组名
     */
    private String name;
    /**
     * 菜单列表
     */
    private List<Menu> menuList;
    /**
     * http请求列表
     */
    private List<Action> actionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }
}

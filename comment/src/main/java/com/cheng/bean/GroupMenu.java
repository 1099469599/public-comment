package com.cheng.bean;

/**
 * 用户组表和菜单表关系的实体
 * Created by cheng on 2017/7/22.
 */
public class GroupMenu {

    /**
     * 用户组表id
     */
    private Long groupId;
    /**
     * 菜单表id
     */
    private Long menuId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
package com.cheng.dto;

import com.cheng.bean.Group;

import java.util.List;

/**
 * 用户组相关dto
 * Created by cheng on 2017/7/22.
 */
public class GroupDto extends Group {

    /**
     * 父节点
     */
    private Integer pId;
    /**
     * 菜单主键列表
     */
    private List<Long> menuIdList;
    /**
     * http响应主键列表
     */
    private List<Long> actionIdList;
    /**
     * 菜单列表
     */
    private List<MenuDto> menuDtoList;
    /**
     * http响应列表
     */
    private List<ActionDto> actionDtoList;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

    public List<Long> getActionIdList() {
        return actionIdList;
    }

    public void setActionIdList(List<Long> actionIdList) {
        this.actionIdList = actionIdList;
    }

    public List<MenuDto> getMenuDtoList() {
        return menuDtoList;
    }

    public void setMenuDtoList(List<MenuDto> menuDtoList) {
        this.menuDtoList = menuDtoList;
    }

    public List<ActionDto> getActionDtoList() {
        return actionDtoList;
    }

    public void setActionDtoList(List<ActionDto> actionDtoList) {
        this.actionDtoList = actionDtoList;
    }
}

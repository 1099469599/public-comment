package com.cheng.bean;

import java.util.List;

/**
 * 菜单表实体
 * Created by cheng on 2017/7/22.
 */

public class Menu {

    /**
     * 主键
     */
    private Long id;
    /**
     * 菜单名
     */
    private String name;

    /**
     * url地址
     */
    private String url;

    /**
     * 父菜单id
     */
    private Long parentId;
    /**
     * 排序数字
     */
    private Integer orderNum;
    /**
     * 动作列表
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

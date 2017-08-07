package com.cheng.bean;

/**
 * http动作实体类
 * Created by cheng on 2017/7/22.
 */
public class Action {

    /**
     * 主键
     */
    private Long id;
    /**
     * 动作名称
     */
    private String name;
    /**
     * 动作地址
     */
    private String url;
    /**
     * 属组编号
     */
    private Long menuId;
    /**
     * 方法名
     */
    private String method;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

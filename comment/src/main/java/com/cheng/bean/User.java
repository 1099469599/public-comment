package com.cheng.bean;

/**
 * 用户表实体
 * Created by cheng on 2017/7/22.
 */
public class User {

    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 登录密码
     */
    private String password;
    /**
     *用户姓名
     */
    private String chName;
    /**
     * 用户组id
     */
    private Long groupId;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}

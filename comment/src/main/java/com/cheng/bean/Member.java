package com.cheng.bean;

/**
 * 会员实体
 * Created by cheng on 2017/7/22.
 */
public class Member {
    /**
     * 主键
     */
    private Long id;
    /**
     * 电话
     */
    private Long phone;
    /**
     * 会员名
     */
    private String name;
    /**
     * 密码
     */
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
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
}

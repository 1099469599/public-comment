package com.cheng.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * api订单相关dto
 * Created by cheng on 2017/7/22.
 */
@JsonInclude(Include.NON_NULL)
public class OrderForBuyDto {
    /**
     * 主键
     */
    private Long id;
    /**
     * 登录成功后的token
     */
    private String token;
    /**
     * 消费人数
     */
    private Integer num;
    /**
     * 消费金额
     */
    private Double price;
    /**
     * 会员手机号
     */
    private Long username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }
}

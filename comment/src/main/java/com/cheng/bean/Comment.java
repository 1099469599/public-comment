package com.cheng.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;

/**
 * 评论表实体
 * Created by cheng on 2017/7/22.
 */

@JsonInclude(Include.NON_NULL)
public class Comment extends BaseBean {
    /**
     * 主键
     */
    private Long id;
    /**
     * 会员id
     */
    private Long ordersId;
    /**
     * 评论内容
     */
    private String comment;
    /**
     * 星级评分
     */
    private Integer star;
    /**
     * 评论时间
     */
    private Date createTime;
    /**
     * 订单
     */
    private Orders orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}

package com.cheng.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;

/**
 * 订单实体
 * Created by cheng on 2017/7/22.
 */
@JsonInclude(Include.NON_NULL)
public class Orders extends BaseBean{
    /**
     * 主键
     */
    private Long id;
    /**
     * 会员主键
     */
    private Long memberId;
    /**
     * 商户主键
     */
    private Long businessId;
    /**
     * 消费人数
     */
    private Integer num;
    /**
     * 评论状态 -- 0：未评论 2：已评论
     */
    private Integer commentState;
    /**
     * 价格(消费金额)
     */
    private Double price;
    /**
     * 商户
     */
    private Business business;
    /**
     * 会员
     */
    private Member member;

    /**
     * 订单创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCommentState() {
        return commentState;
    }

    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

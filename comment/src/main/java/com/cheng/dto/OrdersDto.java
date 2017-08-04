package com.cheng.dto;

import com.cheng.bean.Orders;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 订单dto
 * Created by cheng on 2017/7/22.
 */
@JsonInclude(Include.NON_NULL)
public class OrdersDto extends Orders {
    /**
     * 商户图片
     */
    private String img;
    /**
     * 商户标题
     */
    private String title;
    /**
     * 已售数量
     */
    private Integer count;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

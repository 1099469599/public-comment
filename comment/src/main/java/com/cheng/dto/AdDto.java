package com.cheng.dto;

import com.cheng.bean.Ad;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 广告传输对象
 * Created by cheng on 2017/7/22.
 */
@JsonInclude(Include.NON_NULL)
public class AdDto extends Ad {
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

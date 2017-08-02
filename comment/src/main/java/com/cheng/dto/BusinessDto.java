package com.cheng.dto;

import com.cheng.bean.Business;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商户模块dto
 */
@JsonInclude(Include.NON_NULL)
public class BusinessDto extends Business {

    /**
     * 图片地址
     */
    private String img;
    /**
     * 图片文件
     */
    private MultipartFile imgFile;
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 数
     */
    private Integer mumber;
    /**
     * 星级
     */
    private Integer star;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getMumber() {
        return mumber;
    }

    public void setMumber(Integer mumber) {
        this.mumber = mumber;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
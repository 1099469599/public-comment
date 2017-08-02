package com.cheng.dto;

import com.cheng.bean.Ad;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.web.multipart.MultipartFile;

/**
 * 广告模块dto
 * Created by cheng on 2017/7/22.
 */
@JsonInclude(Include.NON_NULL)
public class AdDto extends Ad {

    /**
     * 图片地址
     */
    private String img;

    /**
     * 图片文件
     */
    private MultipartFile imgFile;

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

}

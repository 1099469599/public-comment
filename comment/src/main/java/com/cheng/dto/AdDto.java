package com.cheng.dto;

import com.cheng.bean.Ad;
import org.springframework.web.multipart.MultipartFile;

/**
 * 广告传输对象
 * Created by cheng on 2017/7/22.
 */
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

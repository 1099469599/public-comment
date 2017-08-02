package com.cheng.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 商户表实体类
 * Created by cheng on 2017/7/22.
 */
@JsonInclude(Include.NON_NULL)
public class Business extends BaseBean {

    /**
     * 主键
     */
    private Long id;
    /**
     * 图片文件名
     */
    private String imgFileName;
    /**
     * 标题
     */
    private String title;
    /**
     * 标题
     */
    private String subtitle;
    /**
     * 价格(单位：元)
     */
    private Double price;
    /**
     * 距离(单位：米)
     */
    private Integer distance;
    /**
     * 已售数量
     */
    private Integer number;
    /**
     * 描述
     */
    private String desc;
    /**
     * 城市
     */
    private String city;
    /**
     * 类别
     */
    private String category;
    /**
     * 评论星星总数
     */
    private Long starTotalNum;
    /**
     * 评论总次数
     */
    private Long commentTotalNum;
    /**
     * 城市字典表
     */
    private Dic cityDic;

    /**
     * 类型字典表
     */
    private Dic categoryDic;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getStarTotalNum() {
        return starTotalNum;
    }

    public void setStarTotalNum(Long starTotalNum) {
        this.starTotalNum = starTotalNum;
    }

    public Long getCommentTotalNum() {
        return commentTotalNum;
    }

    public void setCommentTotalNum(Long commentTotalNum) {
        this.commentTotalNum = commentTotalNum;
    }

    public Dic getCityDic() {
        return cityDic;
    }

    public void setCityDic(Dic cityDic) {
        this.cityDic = cityDic;
    }

    public Dic getCategoryDic() {
        return categoryDic;
    }

    public void setCategoryDic(Dic categoryDic) {
        this.categoryDic = categoryDic;
    }

}

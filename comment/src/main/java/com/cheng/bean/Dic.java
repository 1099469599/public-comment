package com.cheng.bean;


/**
 * 字典表实体类
 * Created by cheng on 2017/7/22.
 */
public class Dic {

    /**
     * 类型
     */
    private String type;
    /**
     * 编码
     */
    private String code;
    /**
     * 名字
     */
    private String name;
    /**
     * 权重
     */
    private Integer weight;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}

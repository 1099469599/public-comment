package com.cheng.bean;

import java.util.Date;

/**
 * 需要定时同步模块的实体
 * Created by cheng on 2017/7/22.
 */

public class SysParam {
    /**
     * 定时任务名称
     */
    private String paramKey;
    /**
     * 定时执行任务时间
     */
    private Date paramValue;
    /**
     * 定时任务描述
     */
    private String paramDesc;

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public Date getParamValue() {
        return paramValue;
    }

    public void setParamValue(Date paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }
}

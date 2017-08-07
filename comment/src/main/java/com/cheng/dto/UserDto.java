package com.cheng.dto;

import com.cheng.bean.User;

/**
 * 用户相关dto
 * Created by cheng on 2017/7/22.
 */

public class UserDto extends User{

    /**
     * 前端zTree表示节点参数
     */
    private Integer pId;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}

package com.cheng.dto;


import com.cheng.bean.Comment;

/**
 * 评论模块dto
 * Created by cheng on 2017/7/22.
 */

public class CommentDto extends Comment {
    /**
     * 隐藏中间4位手机号
     */
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

package com.cheng.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * 评论模块提交dto
 * Created by cheng on 2017/7/22.
 */
@JsonInclude(Include.NON_NULL)
public class CommentListDto {

    private boolean hasMore;
    private List<CommentDto> data;

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<CommentDto> getData() {
        return data;
    }

    public void setData(List<CommentDto> data) {
        this.data = data;
    }
}
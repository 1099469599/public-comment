package com.cheng.service;


import com.cheng.bean.Comment;
import com.cheng.bean.Orders;
import com.cheng.dto.CommentForSubmitDto;
import com.cheng.dto.CommentListDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * 订单模块控制层接口
 * Created by cheng on 2017/7/22.
 */
public interface CommentService {

    /**
     * 保存评论
     *
     * @param commentForSubmitDto 提交的评论dto对象
     * @return 是否保存成功：true：成功;false：失败
     */
    boolean add(CommentForSubmitDto commentForSubmitDto);

    /**
     * 按分页条件，根据商户ID获取商户下的评论列表dto
     *
     * @param businessId 商户id
     * @param page 分页对象
     * @return 评论列表dto
     */
    CommentListDto getListByBusinessId(Long businessId, Page page);

    /**
     * 根据查询条件查询评价
     * @param comment 查询条件
     * @return 评论
     */
    PageInfo<Comment> searchByPage(Comment comment);
}

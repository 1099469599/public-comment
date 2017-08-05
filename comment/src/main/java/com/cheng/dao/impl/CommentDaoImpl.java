package com.cheng.dao.impl;

import com.cheng.bean.Comment;
import com.cheng.dao.CommentDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论模块持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> selectByPage(Comment comment) {
        PageHelper.startPage(comment.getPage().getPageNum(), comment.getPage().getPageSize());
        return commentDao.selectByPage(comment);
    }

    @Override
    public int insert(Comment comment) {
        return commentDao.insert(comment);
    }
}

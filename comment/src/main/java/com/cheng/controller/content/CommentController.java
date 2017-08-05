package com.cheng.controller.content;

import com.cheng.bean.Comment;
import com.cheng.service.impl.CommentServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 评论模块控制层
 * Created by cheng on 2017/7/22.
 */
@RequestMapping("/comment")
@Controller
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    /**
     * 订单列表初始化(点击广告管理菜单进入的第一个页面)
     */
    @RequestMapping
    public String initList(Model model) {
        PageInfo<Comment> pageInfo = commentService.searchByPage(new Comment());
        model.addAttribute("pageInfo", pageInfo);
        return "/content/commentList";
    }

    /**
     * 查询
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, Comment comment) {
        PageInfo<Comment> pageInfo = commentService.searchByPage(comment);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("searchParam", comment);
        return "/content/commentList";
    }
}

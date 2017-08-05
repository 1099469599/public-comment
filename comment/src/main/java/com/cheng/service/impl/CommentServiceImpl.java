package com.cheng.service.impl;

import com.cheng.bean.Business;
import com.cheng.bean.Comment;
import com.cheng.bean.Orders;
import com.cheng.constant.CommentStateConst;
import com.cheng.dao.impl.CommentDaoImpl;
import com.cheng.dao.impl.OrdersDaoImpl;
import com.cheng.dto.CommentDto;
import com.cheng.dto.CommentForSubmitDto;
import com.cheng.dto.CommentListDto;
import com.cheng.service.CommentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单模块控制层实现
 * Created by cheng on 2017/7/22.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDaoImpl commentDao;

    @Autowired
    private OrdersDaoImpl ordersDao;

    @Override
    public boolean add(CommentForSubmitDto commentForSubmitDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentForSubmitDto, comment);
        comment.setId(null);
        comment.setOrdersId(commentForSubmitDto.getId());
        comment.setCreateTime(new Date());
        //保存评论
        int insert = commentDao.insert(comment);
        if (insert > 0) {
            Orders orders = new Orders();
            orders.setId(commentForSubmitDto.getId());
            orders.setCommentState(CommentStateConst.HAS_COMMENT);
            //更新评论状态
            int update = ordersDao.update(orders);
            if (update > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public CommentListDto getListByBusinessId(Long businessId, Page page) {
        CommentListDto result = new CommentListDto();

        //组织查询条件
        Comment comment = new Comment();
        Orders orders = new Orders();
        Business business = new Business();
        //评论里包含了订单对象
        comment.setOrders(orders);
        //订单里包含了商户对象
        orders.setBusiness(business);
        //设置商户主键
        business.setId(businessId);
        //前端app页码从0开始计算，这里需要+1,设置分页条件
        comment.getPage().setPageNum(page.getPageNum() + 1);
        System.out.println(comment.getPage().getPageNum() + "---" + comment.getPage().getPageSize());

        List<Comment> comments = commentDao.selectByPage(comment);

        //组织返回值
        List<CommentDto> data = new ArrayList<>();
        result.setData(data);
        for (Comment commentTemp : comments) {
            CommentDto commentDto = new CommentDto();
            data.add(commentDto);
            BeanUtils.copyProperties(commentTemp, commentDto);
            //隐藏手机号中间4位
            StringBuffer phoneBuffer = new StringBuffer(String.valueOf(commentTemp.getOrders().getMember().getPhone()));
            commentDto.setUsername(phoneBuffer.replace(3, 7, "****").toString());
        }
        result.setHasMore(page.getPageNum() < page.getPages());
        return result;
    }

    @Override
    public PageInfo<Comment> searchByPage(Comment comment) {
        List<Comment> comments = commentDao.selectByPage(comment);
        return new PageInfo(comments);
    }
}

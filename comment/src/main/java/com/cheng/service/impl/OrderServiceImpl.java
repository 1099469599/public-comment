package com.cheng.service.impl;

import com.cheng.bean.Orders;
import com.cheng.constant.CommentStateConst;
import com.cheng.dao.impl.MemberDaoImpl;
import com.cheng.dao.impl.OrdersDaoImpl;
import com.cheng.dto.OrderForBuyDto;
import com.cheng.dto.OrdersDto;
import com.cheng.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单模块业务层实现
 * Created by cheng on 2017/7/22.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersDaoImpl ordersDao;

    @Autowired
    private MemberDaoImpl memberDao;

    @Value("${businessImage.url}")
    String businessImageUrl;

    @Override
    public boolean save(OrderForBuyDto orderForBuyDto, Long memberId) {
        Orders orders = new Orders();
        orders.setNum(orderForBuyDto.getNum());
        orders.setPrice(orderForBuyDto.getPrice());
        orders.setBusinessId(orderForBuyDto.getId());
        orders.setMemberId(memberId);
        orders.setCommentState(CommentStateConst.NOT_COMMENT);
        orders.setCreateTime(new Date());
        return ordersDao.insert(orders);
    }

    @Override
    public List<OrdersDto> getListByMemberId(Long memberId) {
        List<OrdersDto> result = new ArrayList<>();
        Orders ordersForSelect = new Orders();
        ordersForSelect.setMemberId(memberId);
        List<Orders> ordersList = ordersDao.select(ordersForSelect);
        for (Orders orders : ordersList) {
            OrdersDto ordersDto = new OrdersDto();
            result.add(ordersDto);
            BeanUtils.copyProperties(orders, ordersDto);
            ordersDto.setImg(businessImageUrl + orders.getBusiness().getImgFileName());
            ordersDto.setTitle(orders.getBusiness().getTitle());
            ordersDto.setCount(orders.getBusiness().getNumber());
        }

        return result;
    }
}

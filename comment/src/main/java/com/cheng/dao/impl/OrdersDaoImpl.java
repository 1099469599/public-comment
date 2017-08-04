package com.cheng.dao.impl;

import com.cheng.bean.Orders;
import com.cheng.dao.OrdersDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单模块持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class OrdersDaoImpl implements OrdersDao {

    @Autowired
    private OrdersDao ordersDao;


    @Override
    public boolean insert(Orders orders) {
        return ordersDao.insert(orders);
    }

    @Override
    public Orders selectById(Long id) {
        return ordersDao.selectById(id);
    }

    @Override
    public int update(Orders orders) {
        return ordersDao.update(orders);
    }

    @Override
    public List<Orders> select(Orders orders) {
        return ordersDao.select(orders);
    }

    @Override
    public List<Orders> selectAll(Orders orders) {
        PageHelper.startPage(orders.getPage().getPageNum(), orders.getPage().getPageSize());
        return ordersDao.selectAll(orders);
    }
}

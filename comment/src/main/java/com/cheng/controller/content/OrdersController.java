package com.cheng.controller.content;

import com.cheng.bean.Orders;
import com.cheng.service.impl.OrderServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 订单模块控制层
 * Created by cheng on 2017/7/22.
 */
@RequestMapping("/orders")
@Controller
public class OrdersController {

    @Autowired
    private OrderServiceImpl orderService;

    /**
     * 订单列表初始化(点击广告管理菜单进入的第一个页面)
     */
    @RequestMapping
    public String initList(Model model) {
        PageInfo<Orders> pageInfo = orderService.searchByPage(new Orders());
        model.addAttribute("pageInfo", pageInfo);
        return "/content/orderList";
    }

    /**
     * 查询
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, Orders orders) {
        PageInfo<Orders> pageInfo = orderService.searchByPage(orders);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("searchParam", orders);
        return "/content/orderList";
    }
}

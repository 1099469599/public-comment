package com.cheng.controller.report;

import com.cheng.dto.echarts.Option;
import com.cheng.service.impl.OrderReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单统计报表控制层
 * Created by cheng on 2017/7/22.
 */
@Controller
@RequestMapping("orderReport")
public class OrderReportController {

    @Autowired
    private OrderReportServiceImpl orderReportService;

    @RequestMapping
    public String index() {
        return "/report/orderCount";
    }

    @ResponseBody
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Option count() {
        return orderReportService.count();
    }
}

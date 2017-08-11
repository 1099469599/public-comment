package com.cheng.service;

import com.cheng.dto.echarts.Option;

/**
 * 订单统计表业务层接口
 * Created by cheng on 2017/7/22.
 */
public interface OrderReportService {

    /**
     * 按商户类别、每小时为一个时间段(00-01点，01-02点······23-00点)
     * 统计当前系统时间前一天的订单数量
     * 并把数据组织成echarts所需参数格式
     *
     * @return 报表参数
     */
    Option count();
}

package com.cheng.service.impl;

import com.cheng.dao.impl.ReportDaoImpl;
import com.cheng.dto.echarts.Option;
import com.cheng.dto.echarts.Serie;
import com.cheng.service.OrderReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 订单统计表业务层实现
 * Created by cheng on 2017/7/22.
 */
@Service
public class OrderReportServiceImpl implements OrderReportService{

    @Autowired
    private ReportDaoImpl reportDao;

    @Override
    public Option count() {
        Option option = new Option();
        List<Map<String, String>> list = reportDao.countOrder();
        //类别
        Set<String> categoryNameSet = new TreeSet<>();
        //类别+时间为KEY，数量为VALUE
        Map<String, Long> countMap = new HashMap<>();
        for (Map<String, String> map: list) {
            String categoryName = map.get("categoryName");
            categoryNameSet.add(categoryName);
            countMap.put(map.get("categoryName") + map.get("hour"), Long.valueOf(map.get("count")));
        }
        //设置参数中线条的分类
        option.getLegend().setData(new ArrayList<>(categoryNameSet));
        //设置参数的X轴坐标
        List<String> hours = new ArrayList<>();
        for (int i=0;i<23;i++) {
            hours.add(String.format("%02d", i));//%02d 固定2位，不足2位补足两位
        }
        option.getxAxis().setData(hours);
        //设置线条名称和数值
        for (String categoryName : option.getLegend().getData()) {
            Serie serie = new Serie();
            option.getSeries().add(serie);
            serie.setName(categoryName);
            serie.setType("line");
            for (String hour : hours) {
                serie.getData().add(
                        countMap.get(categoryName + hour) == null ? 0 : countMap.get(categoryName + hour));
            }
        }
        return option;
    }
}

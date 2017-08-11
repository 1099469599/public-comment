package com.cheng.dao;

import java.util.List;
import java.util.Map;

/**
 * 统计报表持久层接口
 * Created by cheng on 2017/7/22.
 */
public interface ReportDao {

    /**
     * 按商户类别和时间段统计订单数
     *
     * @return 订单数据统计集，key值说明：
     * categroyName 商户类别的中文名
     * hour 小时数  如： 01 表示凌晨1点到2点这个时间段
     * count 订单数量
     */
    List<Map<String, String>> countOrder();
}

package com.cheng.dao.impl;

import com.cheng.dao.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 统计报表持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class ReportDaoImpl implements ReportDao {

    @Autowired
    private ReportDao reportDao;

    @Override
    public List<Map<String, String>> countOrder() {
        return reportDao.countOrder();
    }
}

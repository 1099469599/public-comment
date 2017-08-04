package com.cheng.dao.impl;

import com.cheng.bean.SysParam;
import com.cheng.dao.SysParamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 定时任务相关持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class SysParamDaoImpl implements SysParamDao {

    @Autowired
    private SysParamDao sysParamDao;

    @Override
    public SysParam selectByKey(String key) {
        return sysParamDao.selectByKey(key);
    }

    @Override
    public int updateByKey(SysParam sysParam) {
        return sysParamDao.updateByKey(sysParam);
    }
}

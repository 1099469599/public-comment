package com.cheng.dao.impl;

import com.cheng.bean.Ad;
import com.cheng.dao.AdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * 广告模块dao实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class AdDaoImpl implements AdDao {

    @Autowired
    private AdDao adDao;

    @Override
    public int insert(Ad ad) {
        return adDao.insert(ad);
    }
}

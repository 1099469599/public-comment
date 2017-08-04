package com.cheng.dao.impl;

import com.cheng.bean.Business;
import com.cheng.dao.BusinessDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商户模块持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class BusinessDaoImpl implements BusinessDao {

    @Autowired
    private BusinessDao businessesDao;

    @Override
    public List<Business> selectByPage(Business business) {
        PageHelper.startPage(business.getPage().getPageNum(), business.getPage().getPageSize());
        return businessesDao.selectByPage(business);
    }

    @Override
    public Business selectById(Long id) {
        return businessesDao.selectById(id);
    }

    @Override
    public boolean delete(Long id) {
        return businessesDao.delete(id);
    }

    @Override
    public int update(Business business) {
        return businessesDao.update(business);
    }

    @Override
    public boolean insert(Business business) {
        return businessesDao.insert(business);
    }

    @Override
    public List<Business> selectLikeByPage(Business business) {
        PageHelper.startPage(business.getPage().getPageNum(), business.getPage().getPageSize());
        return businessesDao.selectLikeByPage(business);
    }

    @Override
    public void updateNumber(Map<String, Date> map) {
        businessesDao.updateNumber(map);
    }

    @Override
    public void updateStar(Map<String, Date> map) {
        businessesDao.updateStar(map);
    }
}

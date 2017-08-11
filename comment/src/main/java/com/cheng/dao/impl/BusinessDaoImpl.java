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
    private BusinessDao businessDao;

    @Override
    public List<Business> selectByPage(Business business) {
        PageHelper.startPage(business.getPage().getPageNum(), business.getPage().getPageSize());
        return businessDao.selectByPage(business);
    }

    @Override
    public Business selectById(Long id) {
        return businessDao.selectById(id);
    }

    @Override
    public boolean delete(Long id) {
        return businessDao.delete(id);
    }

    @Override
    public int update(Business business) {
        return businessDao.update(business);
    }

    @Override
    public boolean insert(Business business) {
        return businessDao.insert(business);
    }

    @Override
    public List<Business> selectLikeByPage(Business business) {
        PageHelper.startPage(business.getPage().getPageNum(), business.getPage().getPageSize());
        return businessDao.selectLikeByPage(business);
    }

    @Override
    public void updateNumber(Map<String, Date> map) {
        businessDao.updateNumber(map);
    }

    @Override
    public void updateStar(Map<String, Date> map) {
        businessDao.updateStar(map);
    }
}

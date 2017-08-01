package com.cheng.dao.impl;

import com.cheng.bean.Ad;
import com.cheng.dao.AdDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 广告模块持久层实现
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

    @Override
    public List<Ad> selectByPage(Ad ad) {
        PageHelper.startPage(ad.getPage().getPageNum(), ad.getPage().getPageSize());
        return adDao.selectByPage(ad);
    }

    @Override
    public boolean delete(Long id) {
        return adDao.delete(id);
    }

    @Override
    public Ad selectById(Long id) {
        return adDao.selectById(id);
    }

    @Override
    public int update(Ad ad) {
        return adDao.update(ad);
    }
}

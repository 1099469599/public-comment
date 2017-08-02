package com.cheng.service.impl;

import com.cheng.bean.Dic;
import com.cheng.dao.impl.DicDaoImpl;
import com.cheng.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典表业务层实现
 * Created by cheng on 2017/7/22.
 */
@Service
public class DicServiceImpl implements DicService {

    @Autowired
    private DicDaoImpl dicDao;

    @Override
    public List<Dic> getListByType(String type) {
        return dicDao.selectListByType(type);
    }
}

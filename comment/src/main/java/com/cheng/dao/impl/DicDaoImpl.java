package com.cheng.dao.impl;

import com.cheng.bean.Dic;
import com.cheng.dao.DicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典表持久层接口
 *
 * Created by cheng on 2017/7/22.
 */
@Repository
public class DicDaoImpl implements DicDao {

    @Autowired
    private DicDao dicDao;

    @Override
    public List<Dic> selectListByType(String type) {
        return dicDao.selectListByType(type);
    }
}

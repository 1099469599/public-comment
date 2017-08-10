package com.cheng.dao.impl;

import com.cheng.bean.Action;
import com.cheng.bean.Ad;
import com.cheng.dao.ActionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 动作相关持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class ActionDaoImpl implements ActionDao {

    @Autowired
    private ActionDao actionDao;


    @Override
    public int deleteByMenuId(Long menuId) {
        return actionDao.deleteByMenuId(menuId);
    }

    @Override
    public int deleteById(Long id) {
        return actionDao.deleteById(id);
    }

    @Override
    public int insert(Action action) {
        return actionDao.insert(action);
    }

    @Override
    public int update(Action action) {
        return actionDao.update(action);
    }

    @Override
    public Action selectById(Long id) {
        return actionDao.selectById(id);
    }
}

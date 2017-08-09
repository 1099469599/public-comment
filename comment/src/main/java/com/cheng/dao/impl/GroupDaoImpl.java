package com.cheng.dao.impl;

import com.cheng.bean.Group;
import com.cheng.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户组相关持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class GroupDaoImpl implements GroupDao {

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> select(Group group) {
        return groupDao.select(group);
    }

    @Override
    public int insert(Group group) {
        return groupDao.insert(group);
    }

    @Override
    public Group selectById(Long id) {
        return groupDao.selectById(id);
    }

    @Override
    public int update(Group group) {
        return groupDao.update(group);
    }

    @Override
    public int delete(Long id) {
        return groupDao.delete(id);
    }

    @Override
    public Group selectMenuListById(Long id) {
        return groupDao.selectMenuListById(id);
    }
}

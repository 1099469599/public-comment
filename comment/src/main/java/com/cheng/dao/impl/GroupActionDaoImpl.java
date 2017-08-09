package com.cheng.dao.impl;

import com.cheng.bean.GroupAction;
import com.cheng.dao.GroupActionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户组和动作关系持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class GroupActionDaoImpl implements GroupActionDao {

    @Autowired
    private GroupActionDao groupActionDao;

    @Override
    public int deleteByGroupId(Long groupId) {
        return groupActionDao.deleteByGroupId(groupId);
    }

    @Override
    public int insertBatch(List<GroupAction> list) {
        return groupActionDao.insertBatch(list);
    }
}

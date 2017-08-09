package com.cheng.dao.impl;

import com.cheng.bean.GroupMenu;
import com.cheng.dao.GroupMenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户组和菜单关系持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class GroupMenuDaoImpl implements GroupMenuDao {

    @Autowired
    private GroupMenuDao groupMenuDao;

    @Override
    public int deleteByGroupId(Long groupId) {
        return groupMenuDao.deleteByGroupId(groupId);
    }

    @Override
    public int insertBatch(List<GroupMenu> list) {
        return groupMenuDao.insertBatch(list);
    }
}

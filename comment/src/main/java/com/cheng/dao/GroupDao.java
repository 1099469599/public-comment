package com.cheng.dao;

import com.cheng.bean.Group;

import java.util.List;

/**
 * 用户组相关持久层接口
 * Created by cheng on 2017/7/22.
 */
public interface GroupDao {
    List<Group> select(Group group);
}

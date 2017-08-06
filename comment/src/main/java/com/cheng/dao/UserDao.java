package com.cheng.dao;

import com.cheng.bean.User;

import java.util.List;

/**
 * 用户相关持久层接口
 * Created by cheng on 2017/7/22.
 */
public interface UserDao {

    /**
     * 根据查询条件查询用户列表
     *
     * @param user 查询条件
     * @return 用户列表
     */
    List<User> select(User user);
}

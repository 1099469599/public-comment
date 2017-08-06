package com.cheng.dao.impl;

import com.cheng.bean.User;
import com.cheng.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户相关持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> select(User user) {
        return userDao.select(user);
    }
}

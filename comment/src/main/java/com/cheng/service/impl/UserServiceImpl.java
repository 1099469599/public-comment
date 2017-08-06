package com.cheng.service.impl;

import com.cheng.bean.User;
import com.cheng.dao.impl.UserDaoImpl;
import com.cheng.dto.UserDto;
import com.cheng.service.UserService;
import com.cheng.util.CommonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户相关业务层实现
 * Created by cheng on 2017/7/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Override
    public boolean validate(UserDto userDto) {
        if (userDto != null && !CommonUtil.isEmpty(userDto.getName()) && !CommonUtil.isEmpty(userDto.getPassword())) {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            List<User> list = userDao.select(user);
            if (list.size() == 1) {
                BeanUtils.copyProperties(list.get(0), userDto);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<UserDto> getList() {
        return null;
    }

    @Override
    public boolean modify(UserDto userDto) {
        return false;
    }
}

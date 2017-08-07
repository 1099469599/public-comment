package com.cheng.dao.impl;

import com.cheng.bean.Menu;
import com.cheng.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单相关持久层实现
 * Created by cheng on 2017/7/22.
 */
@Repository
public class MenuDaoImpl implements MenuDao {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> selectWithAction(Menu menu) {
        return menuDao.selectWithAction(menu);
    }
}

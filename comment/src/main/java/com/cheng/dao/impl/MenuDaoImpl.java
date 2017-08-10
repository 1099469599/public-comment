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

    @Override
    public List<Menu> select(Menu menu) {
        return menuDao.select(menu);
    }

    @Override
    public int insert(Menu menu) {
        return menuDao.insert(menu);
    }

    @Override
    public Menu selectById(Long id) {
        return menuDao.selectById(id);
    }

    @Override
    public int update(Menu menu) {
        return menuDao.update(menu);
    }

    @Override
    public int delete(Long id) {
        return menuDao.delete(id);
    }

    @Override
    public int updateOrderNumByParentId(Long parentId) {
        return menuDao.updateOrderNumByParentId(parentId);
    }

    @Override
    public int updateOrderNumByIdInclude(Long id) {
        return menuDao.updateOrderNumByIdInclude(id);
    }

    @Override
    public int updateOrderNumById(Long id) {
        return menuDao.updateOrderNumById(id);
    }
}

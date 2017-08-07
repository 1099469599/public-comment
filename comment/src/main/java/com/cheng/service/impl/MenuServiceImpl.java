package com.cheng.service.impl;

import com.cheng.bean.Action;
import com.cheng.bean.Menu;
import com.cheng.dao.impl.MenuDaoImpl;
import com.cheng.dto.MenuForZtreeDto;
import com.cheng.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单相关业务层实现
 * Created by cheng on 2017/7/22.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDaoImpl menuDao;

    @Override
    public List<MenuForZtreeDto> getZtreeList() {
        List<MenuForZtreeDto> result = new ArrayList<>();
        List<Menu> menuList = menuDao.selectWithAction(new Menu());
        for (Menu menu : menuList) {
            MenuForZtreeDto menuForZtreeDto = new MenuForZtreeDto();
            result.add(menuForZtreeDto);
            BeanUtils.copyProperties(menu, menuForZtreeDto);
            menuForZtreeDto.setOpen(true);
            menuForZtreeDto.setComboId(MenuForZtreeDto.PREFIX_MENU + menu.getId());
            menuForZtreeDto.setComboParentId(MenuForZtreeDto.PREFIX_MENU + menu.getParentId());
            //组装菜单下对应的动作
            for (Action action : menu.getActionList()) {
                menuForZtreeDto = new MenuForZtreeDto();
                result.add(menuForZtreeDto);
                menuForZtreeDto.setComboId(MenuForZtreeDto.PREFIX_ACTION + action.getId());
                menuForZtreeDto.setComboParentId(MenuForZtreeDto.PREFIX_MENU + action.getMenuId());
                menuForZtreeDto.setName(action.getName());
                menuForZtreeDto.setId(action.getId());
                menuForZtreeDto.setParentId(action.getMenuId());
            }
        }
        return result;
    }
}

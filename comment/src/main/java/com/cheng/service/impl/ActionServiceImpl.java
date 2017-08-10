package com.cheng.service.impl;

import com.cheng.bean.Action;
import com.cheng.dao.ActionDao;
import com.cheng.dao.impl.ActionDaoImpl;
import com.cheng.dto.ActionDto;
import com.cheng.service.ActionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 动作相关业务层实现
 * Created by cheng on 2017/7/22.
 */
@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionDaoImpl actionDao;

    @Override
    public boolean add(ActionDto dto) {
        return actionDao.insert(dto) == 1;
    }

    @Override
    public boolean remove(Long id) {
        return actionDao.deleteById(id) == 1;
    }

    @Override
    public boolean modify(ActionDto actionDto) {
        Action action = new Action();
        BeanUtils.copyProperties(actionDto, action);
        return actionDao.update(action) == 1;
    }

    @Override
    public ActionDto getById(Long id) {
        ActionDto result = new ActionDto();
        Action action = actionDao.selectById(id);
        BeanUtils.copyProperties(action, result);
        return result;
    }
}

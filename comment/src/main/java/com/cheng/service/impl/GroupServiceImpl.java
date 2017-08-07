package com.cheng.service.impl;

import com.cheng.bean.Group;
import com.cheng.dao.impl.GroupDaoImpl;
import com.cheng.dto.GroupDto;
import com.cheng.service.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户组相关业务层实现
 * Created by cheng on 2017/7/22.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDaoImpl groupDao;

    @Override
    public List<GroupDto> getList() {
        List<GroupDto> result = new ArrayList<>();
        List<Group> groupList = groupDao.select(new Group());
        for (Group group : groupList) {
            GroupDto groupDto = new GroupDto();
            result.add(groupDto);
            BeanUtils.copyProperties(group, groupDto);
            groupDto.setpId(0);
        }
        return result;
    }
}

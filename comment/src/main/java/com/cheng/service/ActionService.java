package com.cheng.service;

import com.cheng.dto.ActionDto;

/**
 * 动作相关业务层接口
 * Created by cheng on 2017/7/22.
 */
public interface ActionService {

    /**
     * 新增动作
     *
     * @param dto
     * @return true：新增成功;false：新增失败
     */
    boolean add(ActionDto dto);

    /**
     * 删除动作
     *
     * @param id
     * @return true：删除成功;false：删除失败
     */
    boolean remove(Long id);

    /**
     * 修改动作
     *
     * @param actionDto
     * @return true：修改成功;false：修改失败
     */
    boolean modify(ActionDto actionDto);

    /**
     * 通过id获取动作
     *
     * @param id
     * @return 动作dto对象
     */
    ActionDto getById(Long id);
}

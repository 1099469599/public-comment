package com.cheng.controller.system;

import com.cheng.constant.PageCodeEnum;
import com.cheng.dto.ActionDto;
import com.cheng.dto.PageCodeDto;
import com.cheng.service.ActionService;
import com.cheng.service.impl.ActionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 动作相关控制层
 * Created by cheng on 2017/7/22.
 */
@RequestMapping("/actions")
@RestController
public class ActionController {

    @Autowired
    private ActionServiceImpl actionService;

    /**
     * 新增动作
     */
    @RequestMapping(method = RequestMethod.POST)
    public PageCodeDto add(ActionDto actionDto) {
        PageCodeDto result;
        if (actionService.add(actionDto)) {
            result = new PageCodeDto(PageCodeEnum.ADD_SUCCESS);
        } else {
            result = new PageCodeDto(PageCodeEnum.ADD_FAIL);
        }
        return result;
    }

    /**
     * 删除动作
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public PageCodeDto remove(@PathVariable("id") Long id) {
        PageCodeDto result;
        if (actionService.remove(id)) {
            result = new PageCodeDto(PageCodeEnum.REMOVE_SUCCESS);
        } else {
            result = new PageCodeDto(PageCodeEnum.REMOVE_FAIL);
        }
        return result;
    }

    /**
     * 修改动作
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PageCodeDto remove(ActionDto actionDto) {
        PageCodeDto result;
        if (actionService.modify(actionDto)) {
            result = new PageCodeDto(PageCodeEnum.MODIFY_SUCCESS);
        } else {
            result = new PageCodeDto(PageCodeEnum.MODIFY_FAIL);
        }
        return result;
    }

    /**
     * 根据主键获取动作dto
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ActionDto getById(@PathVariable("id") Long id) {
        return actionService.getById(id);
    }
}

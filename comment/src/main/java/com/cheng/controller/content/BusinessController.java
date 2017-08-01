package com.cheng.controller.content;

import com.cheng.dto.BusinessDto;
import com.cheng.service.impl.BusinessServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 商户模块控制层
 * Created by cheng on 2017/7/22.
 */
@Controller
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessServiceImpl businessesService;

    /**
     * 商户管理页初始化(点击商户管理菜单进入的第一个页面)
     */
    @RequestMapping(method = RequestMethod.GET)
    public String initList(Model model) {
        PageInfo<BusinessDto> pageInfo = businessesService.searchByPage(new BusinessDto());
        model.addAttribute("pageInfo", pageInfo);
        return "/content/businessList";
    }

    /**
     * 删除商户
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") Long id) {
        return null;
    }

    /**
     * 商户修改页初始化
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String modifyInit(Model model) {
        return null;
    }

    /**
     * 商户修改
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String modify() {
        return null;
    }
}

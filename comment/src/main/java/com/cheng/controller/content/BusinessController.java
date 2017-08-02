package com.cheng.controller.content;

import com.cheng.constant.DicTypeConst;
import com.cheng.constant.PageCodeEnum;
import com.cheng.dto.BusinessDto;
import com.cheng.service.DicService;
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
    private BusinessServiceImpl businessService;

    @Autowired
    private DicService dicService;

    /**
     * 商户管理页初始化(点击商户管理菜单进入的第一个页面)
     */
    @RequestMapping()
    public String initList(Model model) {
        PageInfo<BusinessDto> pageInfo = businessService.searchByPage(new BusinessDto());
        model.addAttribute("pageInfo", pageInfo);
        return "/content/businessList";
    }

    /**
     * 按标题查询商户
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, BusinessDto businessDto) {
        PageInfo<BusinessDto> pageInfo = businessService.searchByPage(businessDto);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("searchParam", businessDto);
        return "/content/businessList";
    }

    /**
     * 初始化添加页
     */
    @RequestMapping(value = "addInit", method = RequestMethod.GET)
    public String addInit(Model model) {
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        return "/content/businessAdd";
    }

    /**
     * 添加商户
     */
    @RequestMapping(method = RequestMethod.POST)
    public String add(BusinessDto businessDto, Model model) {
        if (businessService.add(businessDto)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
        }
        model.addAttribute("addParam", businessDto);
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        return "/content/businessAdd";
    }

    /**
     * 删除商户
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") Long id, Model model) {
        if (businessService.remove(id)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_FAIL);
        }
        return "/content/businessList";
    }

    /**
     * 商户修改页初始化
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String modifyInit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("modifyObj", businessService.getById(id));
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        return "/content/businessModify";
    }

    /**
     * 商户修改
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String modify(@PathVariable("id") Long id, BusinessDto businessDto, Model model) {
        if (businessService.modify(businessDto)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
        }
        model.addAttribute("modifyObj", businessDto);
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        return "/content/businessModify";
    }
}

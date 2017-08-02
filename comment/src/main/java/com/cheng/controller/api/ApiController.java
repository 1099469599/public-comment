package com.cheng.controller.api;

import com.cheng.dto.*;
import com.cheng.service.AdService;
import com.cheng.service.BusinessService;
import com.cheng.service.impl.AdServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/7/22.
 * 大众点评api控制层
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AdServiceImpl adService;

    @Autowired
    private BusinessService businessService;

    @Value("${ad.number}")
    private int adNumber;

    @Value("${businessSearch.number}")
    private int businessSearchNumber;

    @Value("${businessHome.number}")
    private int businessHomeNumber;

    /**
     * 首页 —— 广告（超值特惠）
     */
    @RequestMapping(value = "/homead", method = RequestMethod.GET)
    public List<AdDto> homead() throws IOException {
        AdDto adDto = new AdDto();
        adDto.getPage().setPageSize(adNumber);
        return adService.searchByPage(adDto).getList();
    }

    /**
     * 首页 —— 推荐列表（猜你喜欢）
     */
    @RequestMapping(value = "/homelist/{city}/{page.pageNum}", method = RequestMethod.GET)
    public BusinessListDto homelist(BusinessDto businessDto) {
        businessDto.getPage().setPageSize(businessHomeNumber);
        return businessService.searchByPageForApi(businessDto);
    }

    /**
     * 搜索结果页 - 三个参数
     */
    @RequestMapping(value = "/search/{page.pageNum}/{city}/{category}/{keyword}", method = RequestMethod.GET)
    public BusinessListDto searchByKeyword(BusinessDto businessDto) throws IOException {
        businessDto.getPage().setPageNum(businessSearchNumber);
        return businessService.searchByPageForApi(businessDto);
    }

    /**
     * 搜索结果页 - 两个参数
     */
    @RequestMapping(value = "/search/{page.pageNum}/{city}/{category}", method = RequestMethod.GET)
    public BusinessListDto search(BusinessDto businessDto) {
        businessDto.getPage().setPageNum(businessSearchNumber);
        return businessService.searchByPageForApi(businessDto);
    }

    /**
     * 详情页 - 商户信息
     */
    @RequestMapping(value = "/detail/info/{id}", method = RequestMethod.GET)
    public BusinessDto detail(@PathVariable("id") long id) {
        return businessService.getById(id);
    }

    /**
     * 详情页 - 用户评论
     */
    @RequestMapping(value = "/detail/comment/{page}/{id}", method = RequestMethod.GET)
    public CommentListDto detail() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String info = "";
        return mapper.readValue(info, new TypeReference<CommentListDto>() {
        });
    }

    /**
     * 订单列表
     */
    @RequestMapping(value = "/orderlist/{username}", method = RequestMethod.GET)
    public List<OrdersDto> orderList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String info = "";
        return mapper.readValue(info, new TypeReference<List<OrdersDto>>() {
        });
    }

    /**
     * 提交评论页
     */
    @RequestMapping(value = "/submitcomment", method = RequestMethod.GET)
    public Map<String, Object> submitComment() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("msg", "ok");
        return result;
    }
}
package com.cheng.controller.api;

import com.cheng.constant.ApiCodeEnum;
import com.cheng.dto.*;
import com.cheng.service.BusinessService;
import com.cheng.service.impl.AdServiceImpl;
import com.cheng.service.impl.CommentServiceImpl;
import com.cheng.service.impl.MemberServiceImpl;
import com.cheng.service.impl.OrderServiceImpl;
import com.cheng.util.CommonUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private CommentServiceImpl commentService;

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
    public List<AdDto> homeAd() {
        AdDto adDto = new AdDto();
        adDto.getPage().setPageSize(adNumber);
        return adService.searchByPage(adDto).getList();
    }

    /**
     * 首页 —— 推荐列表（猜你喜欢）
     */
    @RequestMapping(value = "/homelist/{city}/{page.pageNum}", method = RequestMethod.GET)
    public BusinessListDto homeList(BusinessDto businessDto) {
        businessDto.getPage().setPageSize(businessHomeNumber);
        //TODO page.pageNum传值问题
        // System.out.println(businessDto.getPage().getPageNum()+"---"+businessDto.getPage().getPageSize());
        BusinessListDto businessListDto = businessService.searchByPageForApi(businessDto);
        return businessListDto;
    }

    /**
     * 搜索结果页 - 三个参数
     */
    @RequestMapping(value = "/search/{page.pageNum}/{city}/{category}/{keyword}", method = RequestMethod.GET)
    public BusinessListDto searchByKeyword(BusinessDto businessDto) {
        businessDto.getPage().setPageSize(businessSearchNumber);
        return businessService.searchByPageForApi(businessDto);
    }

    /**
     * 搜索结果页 - 两个参数
     */
    @RequestMapping(value = "/search/{page.pageNum}/{city}/{category}", method = RequestMethod.GET)
    public BusinessListDto search(BusinessDto businessDto) {
        businessDto.getPage().setPageSize(businessSearchNumber);
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
     * 详情页 - 会员评论
     */
    @RequestMapping(value = "/detail/comment/{pageNum}/{businessId}", method = RequestMethod.GET)
    public CommentListDto detail(@PathVariable("businessId") Long businessId, @PathVariable("pageNum") int pageNum) {
        Page page = new Page();
        page.setPageNum(pageNum);
        return commentService.getListByBusinessId(businessId, page);
    }

    /**
     * 根据手机号下发短信验证码
     */
    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    public ApiCodeDto sms(@RequestParam("username") Long username) {
        ApiCodeDto dto;
        String code = null;
        //1.验证会员手机号是否存在(是否注册过)
        if (memberService.exists(username)) {
            //2.生成6位随机数
            code = String.valueOf(CommonUtil.random(6));
            //3.保存手机号与对应的md5(6位随机数)(一般保存1分钟，1分钟后失效)
            if (memberService.saveCode(username, code)) {
                //4.调用短信通道，将明文6位随机数字发送到对应的手机上
                if (memberService.sendCode(username, code)) {
                    dto = new ApiCodeDto(ApiCodeEnum.SUCCESS, code);
                } else {
                    dto = new ApiCodeDto(ApiCodeEnum.SEND_FAIL);
                }
            } else {
                dto = new ApiCodeDto(ApiCodeEnum.REPEAT_REQUEST);
            }
        } else {
            dto = new ApiCodeDto(ApiCodeEnum.USER_NOT_EXISTS);
        }
        return dto;
    }


    /**
     * 会员登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiCodeDto login(@RequestParam("username") Long username, @RequestParam("code") String code) {
        ApiCodeDto dto = null;
        //1.用手机号取出保存的md5(6位随机数)，能取到，并且提交上来的code值相同为校验通过
        String saveCode = memberService.getCode(username);
        if (saveCode != null) {
            if (saveCode.equals(code)) {
                //2.如果校验通过，生成一个32位的token
                String token = CommonUtil.getUUID();
                //3.保存手机号与对应的token(一般这个手机号中途没有与服务器交互的情况下，保持10分钟)
                memberService.saveToken(token, username);
                //4.将这个token返回给前端
                dto = new ApiCodeDto(ApiCodeEnum.SUCCESS, code);
                dto.setToken(token);
            } else {
                dto = new ApiCodeDto(ApiCodeEnum.CODE_ERROR, code);
            }
        } else {
            dto = new ApiCodeDto(ApiCodeEnum.CODE_INVALID, code);
        }
        return dto;
    }

    /**
     * 买单
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ApiCodeDto order(OrderForBuyDto orderForBuyDto) {
        ApiCodeDto dto = null;
        //1.校验token是否有效（缓存中是否存在这样一个token，并且对应存放的会员信息（这里指的是手机号）与提交上来的信息一致）
        Long phone = memberService.getPhone(orderForBuyDto.getToken());
        if (phone != null && phone.equals(orderForBuyDto.getUsername())) {
            //2.根据手机号获取会员主键
            Long memberId = memberService.getIdByPhone(phone);
            if (orderService.save(orderForBuyDto, memberId)) {
                //3.保存订单
                dto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
                //4.还有一件重要的事未做(商品已售的更新，已经用定时任务完成)
            } else {
                dto = new ApiCodeDto(ApiCodeEnum.BUY_FAIL);
            }
        } else {
            dto = new ApiCodeDto(ApiCodeEnum.NOT_LOGGED);
        }
        return dto;
    }

    /**
     * 订单列表
     */
    @RequestMapping(value = "/orderlist/{username}", method = RequestMethod.GET)
    public List<OrdersDto> orderList(@PathVariable("username") Long username) {
        //根据手机号取出会员id
        Long memberId = memberService.getIdByPhone(username);
        return orderService.getListByMemberId(memberId);
    }

    /**
     * 提交评论页
     */
    @RequestMapping(value = "/submitComment", method = RequestMethod.POST)
    public ApiCodeDto submitComment(CommentForSubmitDto dto) {
        ApiCodeDto result = null;
        //1.校验登录信息：token、手机号
        Long phone = memberService.getPhone(dto.getToken());
        if (phone != null && phone.equals(dto.getUsername())) {
            //2.根据手机号取出会员id
            Long memberId = memberService.getIdByPhone(phone);
            //3.根据提交上来的订单id获取对应的会员id，校验是否与当前id一致
            OrdersDto ordersDto = orderService.getById(dto.getId());
            if (ordersDto.getMemberId().equals(memberId)) {
                //4.保存评论
                commentService.add(dto);
                result = new ApiCodeDto(ApiCodeEnum.SUCCESS);
            } else {
                result = new ApiCodeDto(ApiCodeEnum.NO_AUTH);
            }
        } else {
            result = new ApiCodeDto(ApiCodeEnum.NOT_LOGGED);
        }
        return result;
    }
}
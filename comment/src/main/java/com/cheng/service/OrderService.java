package com.cheng.service;

import com.cheng.dto.OrderForBuyDto;
import com.cheng.dto.OrdersDto;

import java.util.List;

/**
 * 订单模块业务层接口
 * Created by cheng on 2017/7/22.
 */
public interface OrderService {
    /**
     * 保存订单
     *
     * @param orderForBuyDto api订单相关dto
     * @param memberId 用户主键
     * @return true:保存成功;false：保存失败
     */
    boolean save(OrderForBuyDto orderForBuyDto, Long memberId);

    /**
     * 根据会员id获取该会员的全部订单dto列表
     * @param memberId 会员id
     * @return 会员订单的dto列表
     */
    List<OrdersDto> getListByMemberId(Long memberId);
}

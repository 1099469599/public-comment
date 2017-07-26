package com.cheng.service;

import com.cheng.dto.AdDto;

/**
 * 广告模块service接口
 * Created by cheng on 2017/7/22.
 */

public interface AdService {
    /**
     * 新增广告
     * @param adDto
     * @return 是否新增成功：true-成功；false-失败
     */
    boolean add(AdDto adDto);
}

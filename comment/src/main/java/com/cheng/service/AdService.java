package com.cheng.service;

import com.cheng.bean.Ad;
import com.cheng.dto.AdDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 广告模块service接口
 * Created by cheng on 2017/7/22.
 */

public interface AdService {
    /**
     * 新增广告
     *
     * @param adDto
     * @return 是否新增成功：true-成功；false-失败
     */
    boolean add(AdDto adDto);

    /**
     * 分页搜索广告列表
     *
     * @param adDto 查询条件(包含分页对象)
     * @return 广告列表
     */
    PageInfo<Ad> searchByPage(AdDto adDto);

    /**
     * 删除广告
     *
     * @param id
     * @return
     */
    boolean remove(Long id);
}

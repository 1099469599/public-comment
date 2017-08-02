package com.cheng.service;

import com.cheng.dto.AdDto;
import com.github.pagehelper.PageInfo;

/**
 * 广告模块业务层接口
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
    PageInfo<AdDto> searchByPage(AdDto adDto);

    /**
     * 删除广告
     *
     * @param id
     * @return 是否删除成功：true-删除成功;false-删除失败
     */
    boolean remove(Long id);

    /**
     * 根据主键获取广告的Dto对象
     *
     * @param id 广告表主键值
     * @return adDto对象
     */
    AdDto getById(Long id);

    /**
     * 根据主键修改广告对象
     *
     * @param adDto 广告dto对象
     * @return 是否修改成功：true-修改成功;false-修改失败
     */
    boolean modify(AdDto adDto);
}

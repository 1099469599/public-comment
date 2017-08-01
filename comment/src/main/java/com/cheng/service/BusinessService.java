package com.cheng.service;

import com.cheng.dto.BusinessDto;
import com.github.pagehelper.PageInfo;

/**
 * 商户模块业务层接口
 * Created by cheng on 2017/7/22.
 */
public interface BusinessService {

    /**
     * 分页搜索商户列表
     *
     * @param businessDto 查询条件(包含分页对象)
     * @return 商户列表
     */
    PageInfo<BusinessDto> searchByPage(BusinessDto businessDto);
}

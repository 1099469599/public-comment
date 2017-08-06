package com.cheng.service;

import com.cheng.dto.BusinessDto;
import com.cheng.dto.BusinessListDto;
import com.github.pagehelper.PageInfo;

/**
 * 商户模块业务层接口
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

    /**
     * 分页搜索商户列表(接口专用)
     *
     * @param businessDto 查询条件(包含分页对象)
     * @return 商户列表dto对象
     */
    BusinessListDto searchByPageForApi(BusinessDto businessDto);

    /**
     * 删除商户
     *
     * @param id 主键
     * @return 是否删除成功：true-删除成功;false-删除失败
     */
    boolean remove(Long id);

    /**
     * 查询商户
     *
     * @param id 主键
     * @return 商户dto对象
     */
    BusinessDto getById(Long id);

    /**
     * 根据主键修改商户对象
     *
     * @param businessDto 商户dto对象
     * @return 是否修改成功：true-修改成功;false-修改失败
     */
    boolean modify(BusinessDto businessDto);

    /**
     * 根据主键添加商户对象
     *
     * @param businessDto 商户dto对象
     * @return 是否添加成功：true-添加成功;false-添加失败
     */
    boolean add(BusinessDto businessDto);

}

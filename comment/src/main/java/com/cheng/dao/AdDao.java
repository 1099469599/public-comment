package com.cheng.dao;

import com.cheng.bean.Ad;
import com.cheng.dto.AdDto;

import java.util.List;

/**
 * 广告模块dao接口
 * Created by cheng on 2017/7/22.
 */

public interface AdDao {
    /**
     * 新增广告
     *
     * @param ad 广告实体
     * @return 新增了几条数目
     */
    int insert(Ad ad);

    /**
     * 根据查询条件分页查询广告对象
     *
     * @param ad 查询条件：包括广告表的查询字段和分页信息
     * @return 广告列表
     */
    List<Ad> selectByPage(Ad ad);

    /**
     * 根据主键删除
     *
     * @param id
     * @return true：删除成功;false：删除失败
     */
    public boolean delete(Long id);
}

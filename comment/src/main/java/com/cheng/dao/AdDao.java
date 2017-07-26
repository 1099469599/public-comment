package com.cheng.dao;

import com.cheng.bean.Ad;

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
}

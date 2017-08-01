package com.cheng.dao;


import com.cheng.bean.Business;

import java.util.List;

/**
 * 商户模块持久层接口
 * Created by cheng on 2017/7/22.
 */

public interface BusinessDao {

    List<Business> selectByPage(Business businessTemp);
}

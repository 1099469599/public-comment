package com.cheng.service;

import com.cheng.bean.Dic;

import java.util.List;

/**
 * 字典表业务层接口
 * Created by cheng on 2017/7/22.
 */

public interface DicService {
    /**
     * 根据类型获取字典表列表
     *
     * @param type 类型
     * @return 字典表列表
     */
    List<Dic> getListByType(String type);
}

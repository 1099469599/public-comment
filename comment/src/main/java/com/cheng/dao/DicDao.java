package com.cheng.dao;

import com.cheng.bean.Dic;

import java.util.List;

/**
 * 字典表持久层接口
 * Created by cheng on 2017/7/22.
 */
public interface DicDao {
    /**
     * 根据类型获取字典表列表
     *
     * @param type 类型
     * @return 字典表列表
     */
    List<Dic> selectListByType(String type);
}

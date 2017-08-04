package com.cheng.dao;


import com.cheng.bean.Business;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商户模块持久层接口
 * Created by cheng on 2017/7/22.
 */

public interface BusinessDao {

    /**
     * 根据查询条件分页查询商户对象
     *
     * @param businessTemp 查询条件：包含商户表和分页信息
     * @return 商户列表
     */
    List<Business> selectByPage(Business business);

    /**
     * 根据主键查询商户对象
     *
     * @param id 主键
     * @return 商户对象
     */
    Business selectById(Long id);

    /**
     * 根据主键删除商户对象
     *
     * @param id 主键
     * @return true：删除成功;false：删除失败
     */
    boolean delete(Long id);

    /**
     * 根据主键修改商户对象
     *
     * @param business 商户对象
     * @return true：修改成功;false：修改失败
     */
    int update(Business business);

    /**
     * 根据主键添加商户对象
     *
     * @param business 商户对象
     * @return true:添加成功;false：添加失败
     */
    boolean insert(Business business);

    /**
     * 根据查询条件分页查询商户列表：
     * 标题、副标题、描述三个过滤条件为模糊查询
     * 并且这三个过滤条件之间为或者的关系，用OR连接
     * 这三个过滤条件与其他过滤条件依然是并且关系，用AND连接
     *
     * @param business 查询条件
     * @return 商户列表
     */
    List<Business> selectLikeByPage(Business business);

    /**
     * 根据时间更新已售数量
     *
     * @param map 更新时间
     * @return true：更新成功,false：更新失败
     */
    void updateNumber(Map<String, Date> map);

    /**
     * 更新商户的[统计评论星星总数]、[统计评论总次数]，商户的[星级]用这两个字段数据计算得出
     *
     * @param map 更新时间
     * @return
     */
    void updateStar(Map<String, Date> map);
}

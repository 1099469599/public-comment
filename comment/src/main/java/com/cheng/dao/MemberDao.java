package com.cheng.dao;

import com.cheng.bean.Member;

import java.util.List;

/**
 * 用户模块持久层接口
 * Created by cheng on 2017/7/22.
 */
public interface MemberDao {
    /**
     * 根据查询条件查询用户列表
     *
     * @param member 查询条件
     * @return 用户列表
     */
    List<Member> select(Member member);
}

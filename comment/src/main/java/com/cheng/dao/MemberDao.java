package com.cheng.dao;

import com.cheng.bean.Member;

import java.util.List;

/**
 * 会员模块持久层接口
 * Created by cheng on 2017/7/22.
 */
public interface MemberDao {
    /**
     * 根据查询条件查询会员列表
     *
     * @param member 查询条件
     * @return 会员列表
     */
    List<Member> select(Member member);
}

package com.cheng.dao.impl;

import com.cheng.bean.Member;
import com.cheng.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户模块持久层实现
 * Created by cheng on 2017/7/22.
 */

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<Member> select(Member member) {
        return memberDao.select(member);
    }
}

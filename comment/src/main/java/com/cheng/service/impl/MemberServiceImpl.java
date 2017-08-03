package com.cheng.service.impl;

import com.cheng.bean.Member;
import com.cheng.cache.CodeCache;
import com.cheng.cache.TokenCache;
import com.cheng.dao.impl.MemberDaoImpl;
import com.cheng.service.MemberService;
import com.cheng.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户模块业务层实现
 * Created by cheng on 2017/7/22.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDaoImpl memberDao;

    private final static Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

    @Override
    public boolean exists(Long phone) {
        Member member = new Member();
        member.setPhone(phone);
        List<Member> list = memberDao.select(member);
        return list != null && list.size() == 1;
    }

    @Override
    public boolean saveCode(Long phone, String code) {
        //TODO 在真实环境中，改为用第三方实现
        CodeCache codeCache = CodeCache.getInstance();
        return codeCache.save(phone, MD5Util.getMD5(code));
    }

    @Override
    public boolean sendCode(Long phone, String content) {
        LOGGER.info(phone + "---" + content);
        return true;
    }

    @Override
    public String getCode(Long phone) {
        //TODO 在真实环境中，改为用第三方实现
        CodeCache codeCache = CodeCache.getInstance();
        return codeCache.getCode(phone);
    }

    @Override
    public void saveToken(String token, Long phone) {
        TokenCache tokenCache = TokenCache.getInstance();
        tokenCache.save(token, phone);
    }

    @Override
    public Long getPhone(String token) {
        TokenCache tokenCache = TokenCache.getInstance();
        return tokenCache.getPhone(token);
    }

    @Override
    public Long getIdByPhone(Long phone) {
        Member member = new Member();
        member.setPhone(phone);
        List<Member> list = memberDao.select(member);
        if (list != null && list.size() == 1) {
            return list.get(0).getId();
        }
        return null;
    }
}

package com.czxy.login.service.impl;

import com.czxy.login.service.RegisterService;
import com.czxy.tobto.dao.UserMapper;
import com.czxy.tobto.dao.UserMerchantMapper;
import com.czxy.tobto.domain.User;
import com.czxy.tobto.domain.UserMerchant;
import com.czxy.utils.PasswordUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserMerchantMapper umMapper;

    @Override
    public void register(User user, Integer mId) {
        user.setLoginPassword(PasswordUtil.MD5Encode(user.getLoginPassword(),"utf-8",false));
        user.setuService(0);
        int insert = userMapper.insert(user);
        User user1 = userMapper.selectOne(user);
        Integer userId = user1.getUserId();
        UserMerchant um = new UserMerchant(mId,userId);
        umMapper.insert(um);

    }
}

package com.czxy.login.service.impl;

import com.czxy.login.service.LoginService;
import com.czxy.tobto.dao.UserMapper;
import com.czxy.tobto.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String loginName) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("loginName", loginName);
        User user = userMapper.selectOneByExample(example);
        return user;
    }
}

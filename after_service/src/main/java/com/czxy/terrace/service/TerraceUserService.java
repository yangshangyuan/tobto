package com.czxy.terrace.service;

import com.czxy.tobto.dao.UserMapper;
import com.czxy.tobto.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@Transactional
public class TerraceUserService {

    @Resource
    private UserMapper userMapper;

    public User findUserByUsername(String loginName) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("loginName",loginName);
        return  userMapper.selectOneByExample(example);
    }
}

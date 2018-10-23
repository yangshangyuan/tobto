package com.czxy.merchant.service.impl;

import com.czxy.merchant.service.MerchantService;
import com.czxy.tobto.dao.TMerchantMapper;
import com.czxy.tobto.dao.UserMerchantMapper;
import com.czxy.tobto.domain.TMerchant;
import com.czxy.tobto.domain.UserMerchant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {

    @Resource
    private UserMerchantMapper umMapper;

    @Resource
    private TMerchantMapper merchantMapper;

    @Override
    public TMerchant findMerchantByUid(Integer uid) {
        Example example = new Example(UserMerchant.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uId",uid);
        UserMerchant userMerchant = umMapper.selectOneByExample(example);
        Integer mId = userMerchant.getmId();
        TMerchant tMerchant = merchantMapper.selectByPrimaryKey(mId);
        return tMerchant;
    }
}
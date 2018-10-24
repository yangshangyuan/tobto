package com.czxy.tobto.dao;

import com.czxy.tobto.domain.MerchantDemo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@org.apache.ibatis.annotations.Mapper
public interface MerchantDemoMapper extends Mapper<MerchantDemo> {

    @Select("SELECT * FROM merchant_demo WHERE md_m_id=#{mid}")
    @Results({
            @Result(column = "md_m_id",property = "mdMId"),
            @Result(column = "md_d_id",property = "mdDId")
    })
    public List<MerchantDemo> find(Integer mid);
}
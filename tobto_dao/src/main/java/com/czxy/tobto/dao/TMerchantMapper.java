package com.czxy.tobto.dao;

import com.czxy.tobto.domain.TMerchant;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Column;

@org.apache.ibatis.annotations.Mapper
public interface TMerchantMapper extends Mapper<TMerchant> {
    @Select("SELECT * FROM t_merchant WHERE merchant_id=(SELECT md_m_id FROM merchant_demo WHERE md_d_id=#{pid})")
    @Results({
            @Result(column = "merchant_id",property = "merchantId"),
            @Result(column = "u_id",property = "uId"),
            @Result(column = "merchant_name",property = "merchantName"),
            @Result(column = "d_recommend",property = "dRecommend"),
            @Result(column = "merchant_phone",property = "merchantPhone"),
            @Result(column = "merchant_synopsis",property = "merchantSynopsis"),
            @Result(column = "merchant_service_synopsis",property = "merchantServiceSynopsis"),
    })
    public TMerchant sele(@Param("pid") Integer pid);

}
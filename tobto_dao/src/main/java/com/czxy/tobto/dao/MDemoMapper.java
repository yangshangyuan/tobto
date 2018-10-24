package com.czxy.tobto.dao;

import com.czxy.tobto.domain.MDemo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface MDemoMapper extends Mapper<MDemo> {

    @Select("SELECT * FROM m_demo m,(SELECT * FROM merchant_demo GROUP BY md_d_id HAVING  md_m_id=#{did}) d WHERE m.d_id=d.md_d_id")
    @Results({
            @Result(column = "d_id",property = "dId"),
            @Result(column = "d_name",property = "dName"),
            @Result(column = "d_desc",property = "dDesc"),
            @Result(column = "d_recommend",property = "dRecommend"),
            @Result(column = "d_state",property = "dState"),
    })
    public List<MDemo> findAll(Integer did);

}
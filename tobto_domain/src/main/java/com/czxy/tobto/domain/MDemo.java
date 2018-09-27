package com.czxy.tobto.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 案例表
 */
@Table(name = "m_demo")
public class MDemo {

    @Id
    private Integer dId;        //逐渐递增  案例ID

    private String dName;       //案例名称

    private String dDesc;       //案例描述

    private Integer dRecommend;//是否推荐       null.正常案例  0.推荐案例

    private Integer dState;     //案例状态     案例状态：null.正常 0.删除


    public MDemo() {
    }

    public Integer getdId() {
        return dId;
    }

    public String getdName() {
        return dName;
    }

    public String getdDesc() {
        return dDesc;
    }

    public Integer getdRecommend() {
        return dRecommend;
    }

    public Integer getdState() {
        return dState;
    }

}
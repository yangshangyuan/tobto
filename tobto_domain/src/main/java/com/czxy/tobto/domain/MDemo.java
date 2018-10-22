package com.czxy.tobto.domain;

import javax.persistence.*;

/**
 * 案例表
 */
@Table(name = "m_demo")
public class MDemo {

    @Id
    @Column(name = "d_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer dId;        //逐渐递增  案例ID
    @Column(name = "d_name")
    private String dName;       //案例名称
    @Column(name = "d_desc")
    private String dDesc;       //案例描述
    @Column(name = "d_recommend")
    private Integer dRecommend;//是否推荐       null.正常案例  0.推荐案例
    @Column(name = "d_state")
    private Integer dState;     //案例状态     案例状态：null.正常 0.删除
    @Transient
    private TMerchant tMerchant; //所属商家
    public MDemo() {
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public void setdDesc(String dDesc) {
        this.dDesc = dDesc;
    }

    public void setdRecommend(Integer dRecommend) {
        this.dRecommend = dRecommend;
    }

    public void setdState(Integer dState) {
        this.dState = dState;
    }

    public TMerchant gettMerchant() {
        return tMerchant;
    }

    public void settMerchant(TMerchant tMerchant) {
        this.tMerchant = tMerchant;
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
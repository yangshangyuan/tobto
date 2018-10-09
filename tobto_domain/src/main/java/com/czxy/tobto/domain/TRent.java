package com.czxy.tobto.domain;

import javax.persistence.Table;

@Table(name = "t_rent")
public class TRent {
    private Integer rentId;     //租金ID

    private Integer mId;        //所属商家

    private Double rentMoney;   //月租金额

    private Integer rentState;  //交租状态

    private Double rentArrearage;//欠费金额

    public TRent() {
    }

    public Integer getRentId() {
        return rentId;
    }

    public Integer getmId() {
        return mId;
    }

    public Double getRentMoney() {
        return rentMoney;
    }

    public Integer getRentState() {
        return rentState;
    }

    public Double getRentArrearage() {
        return rentArrearage;
    }
}
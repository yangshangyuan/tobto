package com.czxy.tobto.domain;

import javax.persistence.Table;

/**
 * 商家订单表
 */
@Table(name = "merchant_order")
public class MerchantOrder {
    private Integer moMId;  // 案例ID
    private MDemo demo;

    private Integer moOId;// 订单ID
    private TOrder order;

    public MerchantOrder() {
    }

    public Integer getMoMId() {
        return moMId;
    }

    public void setMoMId(Integer moMId) {
        this.moMId = moMId;
    }

    public MDemo getDemo() {
        return demo;
    }

    public void setDemo(MDemo demo) {
        this.demo = demo;
    }

    public Integer getMoOId() {
        return moOId;
    }

    public void setMoOId(Integer moOId) {
        this.moOId = moOId;
    }

    public TOrder getOrder() {
        return order;
    }

    public void setOrder(TOrder order) {
        this.order = order;
    }
}
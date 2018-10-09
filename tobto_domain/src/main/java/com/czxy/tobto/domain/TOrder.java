package com.czxy.tobto.domain;

public class TOrder {
    private Integer orderId;        //  订单ID

    private Integer orderState;     //  订单状态0.待支付 1.待发货 2.已发货 3.交易完成 4.订单取消

    public TOrder() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getOrderState() {
        return orderState;
    }
}
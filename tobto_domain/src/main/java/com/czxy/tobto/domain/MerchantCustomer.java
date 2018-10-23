package com.czxy.tobto.domain;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "merchant_customer")
public class MerchantCustomer {

    @Column(name = "m_id")
    private Integer MId;

    @Column(name = "u_id")
    private Integer UId;

    public MerchantCustomer() {
    }

    public Integer getMId() {

        return MId;
    }

    public void setMId(Integer MId) {
        this.MId = MId;
    }

    public Integer getUId() {
        return UId;
    }

    public void setUId(Integer UId) {
        this.UId = UId;
    }
}

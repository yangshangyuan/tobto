package com.czxy.tobto.domain;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 商家案例中间表
 */
@Table(name = "merchant_demo")
public class MerchantDemo {
    @Column(name = "md_m_id")
    private Integer mdMId;//  商家ID
    @Transient
    private TMerchant merchant;

    @Column(name = "md_d_id")
    private Integer mdDId;//    案例ID
    @Transient
    private MDemo demo;

    public MerchantDemo() {
    }

    public Integer getMdMId() {
        return mdMId;
    }

    public void setMdMId(Integer mdMId) {
        this.mdMId = mdMId;
    }

    public TMerchant getMerchant() {
        return merchant;
    }

    public void setMerchant(TMerchant merchant) {
        this.merchant = merchant;
    }

    public Integer getMdDId() {
        return mdDId;
    }

    public void setMdDId(Integer mdDId) {
        this.mdDId = mdDId;
    }

    public MDemo getDemo() {
        return demo;
    }

    public void setDemo(MDemo demo) {
        this.demo = demo;
    }
}
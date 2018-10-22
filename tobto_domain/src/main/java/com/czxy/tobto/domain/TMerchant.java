package com.czxy.tobto.domain;

import javax.persistence.*;

@Table(name = "t_merchant")
public class TMerchant {
    @Id
    @Column(name = "merchant_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer merchantId;
    @Column(name = "u_id")
    private Integer uId;
    @Column(name = "merchant_name")
    private String merchantName;
    @Column(name = "merchant_phone")
    private String merchantPhone;
    @Column(name = "merchant_synopsis")
    private String merchantSynopsis;
    @Column(name = "merchant_service_synopsis")
    private String merchantServiceSynopsis;
    @Column(name = "merchant_state")
    private Integer merchantState;              //  商家状态 null.正常 0.停用
    @Column(name = "merchant_recommed")
    private Integer merchantRecommed;           //  是否推荐 null.不推荐 1. 推荐

    public TMerchant() {
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public Integer getuId() {
        return uId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public String getMerchantSynopsis() {
        return merchantSynopsis;
    }

    public String getMerchantServiceSynopsis() {
        return merchantServiceSynopsis;
    }

    public Integer getMerchantState() {
        return merchantState;
    }

    public Integer getMerchantRecommed() {
        return merchantRecommed;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    public void setMerchantSynopsis(String merchantSynopsis) {
        this.merchantSynopsis = merchantSynopsis;
    }

    public void setMerchantServiceSynopsis(String merchantServiceSynopsis) {
        this.merchantServiceSynopsis = merchantServiceSynopsis;
    }

    public void setMerchantState(Integer merchantState) {
        this.merchantState = merchantState;
    }

    public void setMerchantRecommed(Integer merchantRecommed) {
        this.merchantRecommed = merchantRecommed;
    }
}
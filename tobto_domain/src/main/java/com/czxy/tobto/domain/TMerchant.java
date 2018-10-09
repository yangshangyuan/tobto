package com.czxy.tobto.domain;

public class TMerchant {
    private Integer merchantId;

    private Integer uId;

    private String merchantName;

    private String merchantPhone;

    private String merchantSynopsis;

    private String merchantServiceSynopsis;

    private Integer merchantState;              //  商家状态 null.正常 0.停用

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
}
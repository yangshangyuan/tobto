package com.czxy.tobto.domain;

public class TMerchant {
    private Integer merchantId;

    private Integer uId;

    private String merchantName;

    private String merchantPhone;

    private String merchantSynopsis;

    private String merchantServiceSynopsis;

    private Integer merchantState;

    private Integer merchantRecommed;

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
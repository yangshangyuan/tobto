package com.czxy.tobto.domain;

import javax.persistence.*;

@Table(name = "user_merchant")
public class UserMerchant {

    @Column(name = "m_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer mId;

    @Transient
    private TMerchant tMerchant;

    @Column(name = "u_id")
    private Integer uId;

    @Transient
    private User user;

    public UserMerchant() {
    }

    public UserMerchant(Integer mId, Integer uId) {
        this.uId = uId;
        this.mId = mId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public TMerchant gettMerchant() {
        return tMerchant;
    }

    public void settMerchant(TMerchant tMerchant) {
        this.tMerchant = tMerchant;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.czxy.tobto.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class TComplain {

    @Id

    private Integer complainId; //  投诉ID

    private Integer uId;    //  投诉者


    private User user;

    private String complainText;   // 投诉内容

    private Integer complainState;  //  投诉进度


    public void setComplainId(Integer complainId) {
        this.complainId = complainId;
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

    public void setComplainText(String complainText) {
        this.complainText = complainText;
    }

    public void setComplainState(Integer complainState) {
        this.complainState = complainState;
    }

    public Integer getComplainId() {
        return complainId;
    }

    public Integer getuId() {
        return uId;
    }

    public String getComplainText() {
        return complainText;
    }

    public Integer getComplainState() {
        return complainState;
    }

}
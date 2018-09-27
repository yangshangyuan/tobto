package com.czxy.tobto.domain;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_complain")
public class TComplain {


    @Column(name = "complain_id")
    private Integer complainId; //  投诉ID

    @Column(name = "u_id")
    private Integer uId;    //  投诉者
    private User user;

    @Column(name = "complain_text")
    private String complainText;   // 投诉内容

    @Column(name = "complain_state")
    private Integer complainState;  //  投诉进度

    public TComplain() {
    }

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
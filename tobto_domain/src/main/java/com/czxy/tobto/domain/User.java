package com.czxy.tobto.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    private Integer userId;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "login_password")
    private String loginPassword;

    @Column(name = "compellation")
    private String compellation;    //真实姓名

    @Column(name = "id_genre")
    private Integer idGenre;        //证件类型 0.身份证 1.军官证 2.护照 3.学生证

    @Column(name = "id_number")
    private String idNumber;        //证件号码

    @Column(name = "user_show")
    private Integer userShow;       //是否被删除 null:正常使用 0:已被管理员删除

    @Column(name = "u_service")
    private Integer uService;       //是否位客服： null.正常用户 0.商家客服 1. 商家法人2.平台管理

    @Column(name = "")
    private Integer uPower;         //null.为普通用户的没有权限 0.为商家的超级管理员(法人) 1.平台超级管理员


    public User() {
    }

    public User(Integer userId, String loginName, String loginPassword, String compellation, Integer idGenre, String idNumber, Integer userShow, Integer uService, Integer uPower) {
        this.userId = userId;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.compellation = compellation;
        this.idGenre = idGenre;
        this.idNumber = idNumber;
        this.userShow = userShow;
        this.uService = uService;
        this.uPower = uPower;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getCompellation() {
        return compellation;
    }

    public void setCompellation(String compellation) {
        this.compellation = compellation;
    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getUserShow() {
        return userShow;
    }

    public void setUserShow(Integer userShow) {
        this.userShow = userShow;
    }

    public Integer getuService() {
        return uService;
    }

    public void setuService(Integer uService) {
        this.uService = uService;
    }

    public Integer getuPower() {
        return uPower;
    }

    public void setuPower(Integer uPower) {
        this.uPower = uPower;
    }
}
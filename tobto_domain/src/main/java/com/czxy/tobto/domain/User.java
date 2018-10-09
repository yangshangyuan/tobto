package com.czxy.tobto.domain;

public class User {
    private Integer userId;

    private String loginName;

    private String loginPassword;

    private String compellation;    //真实姓名

    private Integer idGenre;        //证件类型 0.身份证 1.军官证 2.护照 3.学生证

    private String idNumber;        //证件号码

    private Integer userShow;       //是否被删除 null:正常使用 0:已被管理员删除

    private Integer uService;       //是否位客服： null.正常用户 0.商家客服 1. 商家法人2.平台管理

    private Integer uPower;         //null.为普通用户的没有权限 0.为商家的超级管理员(法人) 1.平台超级管理员

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getCompellation() {
        return compellation;
    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public Integer getUserShow() {
        return userShow;
    }

    public Integer getuService() {
        return uService;
    }

    public Integer getuPower() {
        return uPower;
    }
}
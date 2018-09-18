package com.czxy.tobto.domain;

public class User {
    private Integer userId;

    private String loginName;

    private String loginPassword;

    private String compellation;

    private Integer idGenre;

    private String idNumber;

    private Integer userShow;

    private Integer uService;

    private Integer uPower;

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
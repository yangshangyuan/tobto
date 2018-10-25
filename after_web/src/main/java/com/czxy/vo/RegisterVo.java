package com.czxy.vo;

public class RegisterVo {

    private Integer userId;

    private String loginName;

    private String loginPassword;

    private String compellation;    // 真实姓名

    private String phone;           //手机号码

    private Integer idGenre;        // 证件类型 0.身份证 1.军官证 2.护照 3.学生证

    private String idNumber;        // 证件号码

    private Integer merchant;       // 所属商家ID

    private String vifyCode;       // 验证码

    public RegisterVo() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getMerchant() {
        return merchant;
    }

    public void setMerchant(Integer merchant) {
        this.merchant = merchant;
    }

    public String getVifyCode() {
        return vifyCode;
    }

    public void setVifyCode(String vifyCode) {
        this.vifyCode = vifyCode;
    }

    @Override
    public String toString() {
        return "RegisterVo{" +
                "userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", compellation='" + compellation + '\'' +
                ", phone='" + phone + '\'' +
                ", idGenre=" + idGenre +
                ", idNumber='" + idNumber + '\'' +
                ", merchant=" + merchant +
                ", vifyCode=" + vifyCode +
                '}';
    }
}

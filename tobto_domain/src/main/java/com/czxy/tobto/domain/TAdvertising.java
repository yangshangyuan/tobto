package com.czxy.tobto.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "t_advertising")
public class TAdvertising {

    @Id
    private Integer aId;

    private String aText;

    private Integer aShow;

    private String aPhoto;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaText() {
        return aText;
    }

    public void setaText(String aText) {
        this.aText = aText;
    }

    public Integer getaShow() {
        return aShow;
    }

    public void setaShow(Integer aShow) {
        this.aShow = aShow;
    }

    public String getaPhoto() {
        return aPhoto;
    }

    public void setaPhoto(String aPhoto) {
        this.aPhoto = aPhoto;
    }
}
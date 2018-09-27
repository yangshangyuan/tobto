package com.czxy.tobto.domain;

import javax.persistence.Table;

@Table(name = "t_finds")
public class TFinds {
    private Integer fId;

    private String fName;

    private String fUrl;

    private Integer fShow;

    public TFinds() {
    }

    public Integer getfId() {
        return fId;
    }

    public String getfName() {
        return fName;
    }

    public String getfUrl() {
        return fUrl;
    }

    public Integer getfShow() {
        return fShow;
    }
}
package com.czxy.tobto.domain;

import javax.persistence.Table;

/**
 * 友情链接,需要修改
 */
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
package com.czxy.tobto.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 友情链接,需要修改
 */
@Table(name = "t_finds")
public class TFinds {
    @Id
    private Integer fId;

    private String fName;

    private String fUrl;

    private Integer fShow;  //是否显示

    public TFinds() {
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfUrl() {
        return fUrl;
    }

    public void setfUrl(String fUrl) {
        this.fUrl = fUrl;
    }

    public Integer getfShow() {
        return fShow;
    }

    public void setfShow(Integer fShow) {
        this.fShow = fShow;
    }

    @Override
    public String toString() {
        return "TFinds{" +
                "fId=" + fId +
                ", fName='" + fName + '\'' +
                ", fUrl='" + fUrl + '\'' +
                ", fShow=" + fShow +
                '}';
    }
}
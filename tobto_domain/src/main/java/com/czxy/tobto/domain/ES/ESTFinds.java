package com.czxy.tobto.domain.ES;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "link", type = "link", shards = 5, replicas = 1)
public class ESTFinds {

    @Id
    private Integer fId;
    @Field(type = FieldType.Text)
    private String fName;
    @Field(type = FieldType.Keyword)
    private String fUrl;
    @Field(type = FieldType.Integer)
    private Integer fShow;


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
}

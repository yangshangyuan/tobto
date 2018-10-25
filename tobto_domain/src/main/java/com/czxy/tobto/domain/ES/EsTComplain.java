package com.czxy.tobto.domain.ES;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "complain",type = "complain")
public class EsTComplain {

    @Id
    private Integer complainId; //  投诉ID

    @Field(type = FieldType.Keyword)
    private String  loginName;//投诉者

    @Field(type = FieldType.Keyword)
    private String complainText;   // 投诉内容

    @Field(type = FieldType.Text)
    private Integer complainState;  //  投诉进度

    public EsTComplain() {
    }



    public Integer getComplainId() {
        return complainId;
    }

    public void setComplainId(Integer complainId) {
        this.complainId = complainId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getComplainText() {
        return complainText;
    }

    public void setComplainText(String complainText) {
        this.complainText = complainText;
    }

    public Integer getComplainState() {
        return complainState;
    }

    public void setComplainState(Integer complainState) {
        this.complainState = complainState;
    }
}
package com.czxy.tobto.domain.ES;

import com.czxy.tobto.domain.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_complain")
@Document(indexName = "complain",type = "complain")
public class EsTComplain {

    @Id
    private Integer complainId; //  投诉ID

    @Field(type = FieldType.Keyword)
    private Integer uId;    //  投诉者
    private User user;

    @Field(type = FieldType.Keyword)
    private String complainText;   // 投诉内容

    @Field(type = FieldType.Text)
    private Integer complainState;  //  投诉进度

    public EsTComplain() {
    }

    public void setComplainId(Integer complainId) {
        this.complainId = complainId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComplainText(String complainText) {
        this.complainText = complainText;
    }

    public void setComplainState(Integer complainState) {
        this.complainState = complainState;
    }

    public Integer getComplainId() {
        return complainId;
    }

    public Integer getuId() {
        return uId;
    }

    public String getComplainText() {
        return complainText;
    }

    public Integer getComplainState() {
        return complainState;
    }
}
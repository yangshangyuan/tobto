package com.czxy.tobto.domain.ES;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "tbt", type = "tbt",shards = 5,replicas = 1)
public class EsTAdvertising {

    @Id
    private Integer aId;

    @Field(type = FieldType.Text)
    private String aText;

    @Field(type = FieldType.Keyword)
    private Integer aShow;

    @Field(type = FieldType.Keyword)
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

    public EsTAdvertising() {
    }

    public EsTAdvertising(Integer aId, String aText, Integer aShow, String aPhoto) {
        this.aId = aId;
        this.aText = aText;
        this.aShow = aShow;
        this.aPhoto = aPhoto;
    }
}
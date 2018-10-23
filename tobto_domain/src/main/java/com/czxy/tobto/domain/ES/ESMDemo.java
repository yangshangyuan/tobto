package com.czxy.tobto.domain.ES;

import com.czxy.tobto.domain.TMerchant;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "tmd", type = "tmd",shards = 5,replicas = 1)
public class ESMDemo {

    @Id
    private Integer dId;        //逐渐递增  案例ID
    @Field(type = FieldType.Keyword)
    private String dName;       //案例名称
    @Field(type = FieldType.Text)
    private String dDesc;       //案例描述
    @Field(type = FieldType.Text)
    private Integer dRecommend;//是否推荐       null.正常案例  0.推荐案例
    @Field(type = FieldType.Text)
    private Integer dState;     //案例状态     案例状态：null.正常 0.删除
    @Field(type = FieldType.Text)
    private TMerchant tMerchant; //所属商家
    public ESMDemo() {
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public void setdDesc(String dDesc) {
        this.dDesc = dDesc;
    }

    public void setdRecommend(Integer dRecommend) {
        this.dRecommend = dRecommend;
    }

    public void setdState(Integer dState) {
        this.dState = dState;
    }

    public TMerchant gettMerchant() {
        return tMerchant;
    }

    public void settMerchant(TMerchant tMerchant) {
        this.tMerchant = tMerchant;
    }

    public Integer getdId() {
        return dId;
    }

    public String getdName() {
        return dName;
    }

    public String getdDesc() {
        return dDesc;
    }

    public Integer getdRecommend() {
        return dRecommend;
    }

    public Integer getdState() {
        return dState;
    }

}

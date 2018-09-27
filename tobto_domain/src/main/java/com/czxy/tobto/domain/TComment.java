package com.czxy.tobto.domain;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 评论表
 */
@Table(name = "t_comment")
public class TComment {

    @Column(name = "comment_id")
    private Integer commentId;  //  评论ID

    @Column(name = "comment_text")
    private String commentText; //  评论内容

    @Column(name = "u_id")
    private Integer uId;    //  评论者
    private User user;


    @Column(name = "m_id")
    private Integer mId;    //  被评论的商家
    private TMerchant merchant;

    public TComment() {
    }


    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
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

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public TMerchant getMerchant() {
        return merchant;
    }

    public void setMerchant(TMerchant merchant) {
        this.merchant = merchant;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public Integer getuId() {
        return uId;
    }

    public Integer getmId() {
        return mId;
    }
}
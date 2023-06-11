package com.example.buyhouse.entity;

import java.io.Serializable;

/**
 * 用户识别信息(Openid)实体类
 *
 * @author makejava
 * @since 2023-05-01 15:08:24
 */
public class Openid implements Serializable {
    private static final long serialVersionUID = 900216672881575670L;
    /**
     * 主键
     */
    private Long id;
    /**
     * openID
     */
    private String uopenid;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像地址
     */
    private String avatarurl;
    /**
     * wxcode
     */
    private String code;



    private Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUopenid() {
        return uopenid;
    }

    public void setUopenid(String uopenid) {
        this.uopenid = uopenid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "Openid{" +
                "id=" + id +
                ", uopenid='" + uopenid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatarurl='" + avatarurl + '\'' +
                ", code='" + code + '\'' +
                ", token=" + token +
                '}';
    }
}


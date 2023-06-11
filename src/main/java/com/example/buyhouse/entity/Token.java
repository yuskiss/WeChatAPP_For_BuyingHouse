package com.example.buyhouse.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * token表(Token)实体类
 *
 * @author makejava
 * @since 2023-05-02 14:28:00
 */
public class Token implements Serializable {
    private static final long serialVersionUID = 172716010604560102L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户id
     */
    private String userid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 表名
     */
    private String tablename;
    /**
     * 角色
     */
    private String role;
    /**
     * 密码
     */
    private String token;
    /**
     * 新增时间
     */
    private Date addtime;
    /**
     * 过期时间
     */
    private Date expiratedtime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getExpiratedtime() {
        return expiratedtime;
    }

    public void setExpiratedtime(Date expiratedtime) {
        this.expiratedtime = expiratedtime;
    }

}


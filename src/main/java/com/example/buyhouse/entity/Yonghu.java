package com.example.buyhouse.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户(Yonghu)实体类
 *
 * @author makejava
 * @since 2023-05-03 13:39:17
 */
public class Yonghu implements Serializable {
    private static final long serialVersionUID = 544186370650215089L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date addtime;
    /**
     * 用户账号
     */
    private String yonghuzhanghao;
    /**
     * 用户姓名
     */
    private String yonghuxingming;
    /**
     * 密码
     */
    private String mima;
    /**
     * 性别
     */
    private String xingbie;
    /**
     * 年龄
     */
    private Integer nianling;
    /**
     * 联系电话
     */
    private String lianxidianhua;
    /**
     * 电子邮箱
     */
    private String dianziyouxiang;
    /**
     * 身份证号
     */
    private String shenfenzhenghao;
    /**
     * 家庭地址
     */
    private String jiatingdizhi;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getYonghuzhanghao() {
        return yonghuzhanghao;
    }

    public void setYonghuzhanghao(String yonghuzhanghao) {
        this.yonghuzhanghao = yonghuzhanghao;
    }

    public String getYonghuxingming() {
        return yonghuxingming;
    }

    public void setYonghuxingming(String yonghuxingming) {
        this.yonghuxingming = yonghuxingming;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public String getXingbie() {
        return xingbie;
    }

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    public Integer getNianling() {
        return nianling;
    }

    public void setNianling(Integer nianling) {
        this.nianling = nianling;
    }

    public String getLianxidianhua() {
        return lianxidianhua;
    }

    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua;
    }

    public String getDianziyouxiang() {
        return dianziyouxiang;
    }

    public void setDianziyouxiang(String dianziyouxiang) {
        this.dianziyouxiang = dianziyouxiang;
    }

    public String getShenfenzhenghao() {
        return shenfenzhenghao;
    }

    public void setShenfenzhenghao(String shenfenzhenghao) {
        this.shenfenzhenghao = shenfenzhenghao;
    }

    public String getJiatingdizhi() {
        return jiatingdizhi;
    }

    public void setJiatingdizhi(String jiatingdizhi) {
        this.jiatingdizhi = jiatingdizhi;
    }

    @Override
    public String toString() {
        return "Yonghu{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", yonghuzhanghao='" + yonghuzhanghao + '\'' +
                ", yonghuxingming='" + yonghuxingming + '\'' +
                ", mima='" + mima + '\'' +
                ", xingbie='" + xingbie + '\'' +
                ", nianling=" + nianling +
                ", lianxidianhua='" + lianxidianhua + '\'' +
                ", dianziyouxiang='" + dianziyouxiang + '\'' +
                ", shenfenzhenghao='" + shenfenzhenghao + '\'' +
                ", jiatingdizhi='" + jiatingdizhi + '\'' +
                '}';
    }
}


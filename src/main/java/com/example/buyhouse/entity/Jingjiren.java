package com.example.buyhouse.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 经纪人(Jingjiren)实体类
 *
 * @author makejava
 * @since 2023-05-11 18:42:02
 */
public class Jingjiren implements Serializable {
    private static final long serialVersionUID = 680148385883099216L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date addtime;
    /**
     * 经纪人账号
     */
    private String jingjirenzhanghao;
    /**
     * 经纪人姓名
     */
    private String jingjirenxingming;
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
     * 门店名称
     */
    private String mendianmingcheng;
    /**
     * 头像
     */
    private String touxiang;


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

    public String getJingjirenzhanghao() {
        return jingjirenzhanghao;
    }

    public void setJingjirenzhanghao(String jingjirenzhanghao) {
        this.jingjirenzhanghao = jingjirenzhanghao;
    }

    public String getJingjirenxingming() {
        return jingjirenxingming;
    }

    public void setJingjirenxingming(String jingjirenxingming) {
        this.jingjirenxingming = jingjirenxingming;
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

    public String getMendianmingcheng() {
        return mendianmingcheng;
    }

    public void setMendianmingcheng(String mendianmingcheng) {
        this.mendianmingcheng = mendianmingcheng;
    }

    public String getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(String touxiang) {
        this.touxiang = touxiang;
    }

}


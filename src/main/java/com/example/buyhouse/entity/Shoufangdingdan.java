package com.example.buyhouse.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 售房订单(Shoufangdingdan)实体类
 *
 * @author makejava
 * @since 2023-05-20 15:02:54
 */
public class Shoufangdingdan implements Serializable {
    private static final long serialVersionUID = 372170146613742820L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date addtime;
    /**
     * 订单编号
     */
    private String dingdanbianhao;
    /**
     * 房源名称
     */
    private String fangyuanmingcheng;
    /**
     * 总金额
     */
    private String zongjine;
    /**
     * 经纪人账号
     */
    private String jingjirenzhanghao;
    /**
     * 经纪人姓名
     */
    private String jingjirenxingming;
    /**
     * 用户账号
     */
    private String yonghuzhanghao;
    /**
     * 用户姓名
     */
    private String yonghuxingming;
    /**
     * 购买时间
     */
    private Date goumaishijian;
    /**
     * 是否支付
     */
    private String ispay;
    /**
     * 用户电话
     */
    private String yonghudianhua;


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

    public String getDingdanbianhao() {
        return dingdanbianhao;
    }

    public void setDingdanbianhao(String dingdanbianhao) {
        this.dingdanbianhao = dingdanbianhao;
    }

    public String getFangyuanmingcheng() {
        return fangyuanmingcheng;
    }

    public void setFangyuanmingcheng(String fangyuanmingcheng) {
        this.fangyuanmingcheng = fangyuanmingcheng;
    }

    public String getZongjine() {
        return zongjine;
    }

    public void setZongjine(String zongjine) {
        this.zongjine = zongjine;
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

    public Date getGoumaishijian() {
        return goumaishijian;
    }

    public void setGoumaishijian(Date goumaishijian) {
        this.goumaishijian = goumaishijian;
    }

    public String getIspay() {
        return ispay;
    }

    public void setIspay(String ispay) {
        this.ispay = ispay;
    }

    public String getYonghudianhua() {
        return yonghudianhua;
    }

    public void setYonghudianhua(String yonghudianhua) {
        this.yonghudianhua = yonghudianhua;
    }

    @Override
    public String toString() {
        return "Shoufangdingdan{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", dingdanbianhao='" + dingdanbianhao + '\'' +
                ", fangyuanmingcheng='" + fangyuanmingcheng + '\'' +
                ", zongjine='" + zongjine + '\'' +
                ", jingjirenzhanghao='" + jingjirenzhanghao + '\'' +
                ", jingjirenxingming='" + jingjirenxingming + '\'' +
                ", yonghuzhanghao='" + yonghuzhanghao + '\'' +
                ", yonghuxingming='" + yonghuxingming + '\'' +
                ", goumaishijian=" + goumaishijian +
                ", ispay='" + ispay + '\'' +
                ", yonghudianhua='" + yonghudianhua + '\'' +
                '}';
    }
}


package com.example.buyhouse.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 房源信息(Fangyuanxinxi)实体类
 *
 * @author makejava
 * @since 2023-04-27 22:31:07
 */
public class Fangyuanxinxi implements Serializable {
    private static final long serialVersionUID = 427651802489611580L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date addtime;
    /**
     * 房源名称
     */
    private String fangyuanmingcheng;
    /**
     * 房源类型
     */
    private String fangyuanleixing;
    /**
     * 房子户型
     */
    private String fangzihuxing;
    /**
     * 房源区域
     */
    private String fangyuanquyu;
    /**
     * 房源图片
     */
    private String fangyuantupian;
    /**
     * 状态
     */
    private String zhuangtai;
    /**
     * 具体位置
     */
    private String jutiweizhi;
    /**
     * 面积
     */
    private String mianji;
    /**
     * 每米价格
     */
    private String meimijiage;
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
     * 发布时间
     */
    private Date fabushijian;
    /**
     * 用户id
     */
    private Long userid;

    private String miaoshu;

    private String zhuangxiu;

    public String getZhuangxiu() {
        return zhuangxiu;
    }

    public void setZhuangxiu(String zhuangxiu) {
        this.zhuangxiu = zhuangxiu;
    }

    private Shoucang shoucang;



    public Shoucang getShoucang() {
        return shoucang;
    }

    public void setShoucang(Shoucang shoucang) {
        this.shoucang = shoucang;
    }

    public String getMiaoshu() {
        return miaoshu;
    }



    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

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

    public String getFangyuanmingcheng() {
        return fangyuanmingcheng;
    }

    public void setFangyuanmingcheng(String fangyuanmingcheng) {
        this.fangyuanmingcheng = fangyuanmingcheng;
    }

    public String getFangyuanleixing() {
        return fangyuanleixing;
    }

    public void setFangyuanleixing(String fangyuanleixing) {
        this.fangyuanleixing = fangyuanleixing;
    }

    public String getFangzihuxing() {
        return fangzihuxing;
    }

    public void setFangzihuxing(String fangzihuxing) {
        this.fangzihuxing = fangzihuxing;
    }

    public String getFangyuanquyu() {
        return fangyuanquyu;
    }

    public void setFangyuanquyu(String fangyuanquyu) {
        this.fangyuanquyu = fangyuanquyu;
    }

    public String getFangyuantupian() {
        return fangyuantupian;
    }

    public void setFangyuantupian(String fangyuantupian) {
        this.fangyuantupian = fangyuantupian;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getJutiweizhi() {
        return jutiweizhi;
    }

    public void setJutiweizhi(String jutiweizhi) {
        this.jutiweizhi = jutiweizhi;
    }

    public String getMianji() {
        return mianji;
    }

    public void setMianji(String mianji) {
        this.mianji = mianji;
    }

    public String getMeimijiage() {
        return meimijiage;
    }

    public void setMeimijiage(String meimijiage) {
        this.meimijiage = meimijiage;
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

    public Date getFabushijian() {
        return fabushijian;
    }

    public void setFabushijian(Date fabushijian) {
        this.fabushijian = fabushijian;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Fangyuanxinxi{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", fangyuanmingcheng='" + fangyuanmingcheng + '\'' +
                ", fangyuanleixing='" + fangyuanleixing + '\'' +
                ", fangzihuxing='" + fangzihuxing + '\'' +
                ", fangyuanquyu='" + fangyuanquyu + '\'' +
                ", fangyuantupian='" + fangyuantupian + '\'' +
                ", zhuangtai='" + zhuangtai + '\'' +
                ", jutiweizhi='" + jutiweizhi + '\'' +
                ", mianji='" + mianji + '\'' +
                ", meimijiage='" + meimijiage + '\'' +
                ", zongjine='" + zongjine + '\'' +
                ", jingjirenzhanghao='" + jingjirenzhanghao + '\'' +
                ", jingjirenxingming='" + jingjirenxingming + '\'' +
                ", fabushijian=" + fabushijian +
                ", userid=" + userid +
                ", miaoshu='" + miaoshu + '\'' +
                ", zhuangxiu='" + zhuangxiu + '\'' +
                ", shoucang=" + shoucang +
                '}';
    }
}


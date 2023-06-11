package com.example.buyhouse.entity;

import java.io.Serializable;

/**
 * 配置文件(Configlunbotu)实体类
 *
 * @author makejava
 * @since 2023-04-28 22:55:04
 */
public class Configlunbotu implements Serializable {
    private static final long serialVersionUID = 414486030497036788L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 配置参数名称
     */
    private String name;
    /**
     * 配置参数值
     */
    private String value;
    /**
     * 配置参数值
     */
    private String pngid;

    private Fangyuanxinxi fangyuanxinxiid;




    /*public Fangyuanxinxi getid(){return fangyuanxinxiid;}
    public void setFangyuanxinxiid(Fangyuanxinxi fangyuanxinxiid){this.fangyuanxinxiid = fangyuanxinxiid;}*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPngid() {
        return pngid;
    }

    public void setPngid(String pngid) {
        this.pngid = pngid;
    }

}


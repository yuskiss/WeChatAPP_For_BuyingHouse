package com.example.buyhouse.entity;

import java.io.Serializable;

/**
 * 配置文件(Shoucang)实体类
 *
 * @author makejava
 * @since 2023-05-11 21:10:24
 */
public class Shoucang implements Serializable {
    private static final long serialVersionUID = 793352369809142639L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 配置参数值
     */
    private String value;

    private String opid;

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Shoucang{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", opid='" + opid + '\'' +
                '}';
    }
}


package com.example.buyhouse.entity;

import java.io.Serializable;


public class Config implements Serializable {
    //private static final long serialVersionUID = 601004334769684020L;
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
    private String type;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}


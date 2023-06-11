package com.example.buyhouse.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "wx.miniapp")
public class wxproperties {
    private String appid;
    private String secret;
    private String jscode2sessionUrl;


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getJscode2sessionUrl() {
        return jscode2sessionUrl;
    }

    public void setJscode2sessionUrl(String jscode2sessionUrl) {
        this.jscode2sessionUrl = jscode2sessionUrl;
    }
}

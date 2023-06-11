package com.example.buyhouse.entity;


import java.util.HashMap;
import java.util.Map;

/**
 * 用于封装返回值的
 */
public class Mapfenzhaung extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public Mapfenzhaung() {
        put("code", 0);
    }

    public static Mapfenzhaung error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static Mapfenzhaung error(String msg) {
        return error(500, msg);
    }

    public static Mapfenzhaung error(int code, String msg) {
        Mapfenzhaung r = new Mapfenzhaung();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Mapfenzhaung ok(String msg) {
        Mapfenzhaung r = new Mapfenzhaung();
        r.put("msg", msg);
        return r;
    }

    public static Mapfenzhaung ok(Map<String, Object> map) {
        Mapfenzhaung r = new Mapfenzhaung();
        r.putAll(map);
        return r;
    }

    public static Mapfenzhaung ok() {
        return new Mapfenzhaung();
    }

    public Mapfenzhaung put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

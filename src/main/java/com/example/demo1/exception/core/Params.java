package com.example.demo1.exception.core;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Params extends HashMap<String, Object> {

    private static final long serialVersionUID = -2143997528071245822L;

    public Params(){}

    public Params(Map<String, Object> map) {
        this.putAll(map);
    }

    public Params add(String key, Object value) {
        this.put(key,value);
        return this;
    }

    public Params addAll(Map<String, Object> map) {
        this.putAll(map);
        return this;
    }

    public Params addAll(Params map) {
        this.putAll(map);
        return this;
    }

    @Override
    public String toString() {
        return this.toString();
    }
}

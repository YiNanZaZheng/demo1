package com.example.demo1.sys.exception.core;

import java.util.Set;

public class IString {
    private final String key;
    private final String defaultValue;
    private Params params;

    public IString(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public IString(IString str, Params params) {
        this.key=str.getKey();
        this.defaultValue=str.getDefaultValue();
        this.params=params;
    }

    public IString(String key, String defaultValue, Params params) {
        this.key = key;
        this.defaultValue = defaultValue;
        this.params = params;
    }

    public String getString() {
        return getString(false);
    }
    public String getLocalString() {
        return getString(true);
    }

    private String getString(boolean isLocal) {
        String ret;
        //TODO：待拓展 根据送入的isLocal去拿到不同是实现
        if (isLocal) {
            ret="";
        }else {
            ret=defaultValue;
        }
        if (params == null || params.size() < 1) {
            return ret;
        }else {
            //TODO：改天再写,错误码送入参数在此处实现

            Set<String> set = params.keySet();
            String tmp="";
            for (String s : set) {
                ret=ret.substring(0,ret.indexOf(s)-2)+params.get(s)+ret.substring(ret.indexOf(s)+s.length()+1);
            }
            return ret;
        }
    }

    public String getKey() {
        return key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
package com.example.simplespring.ioc.entity;

public class PropertyValue {
    private String name;
    private String value;

    public PropertyValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}

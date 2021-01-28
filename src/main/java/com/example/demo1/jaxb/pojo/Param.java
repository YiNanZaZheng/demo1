package com.example.demo1.jaxb.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "param")
public class Param{
    @XmlAttribute
    private String key;

    @XmlAttribute
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

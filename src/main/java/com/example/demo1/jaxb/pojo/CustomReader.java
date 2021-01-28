package com.example.demo1.jaxb.pojo;

import javax.xml.bind.annotation.XmlAttribute;

public class CustomReader implements ReaderInter {
    @XmlAttribute
    private String custClassName;

    public String getCustClassName() {
        return custClassName;
    }
}

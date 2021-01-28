package com.example.demo1.jaxb.pojo;

import javax.xml.bind.annotation.XmlAttribute;

public class FixedLengthFileReader  extends FileReaderBean implements ReaderInter {

    @XmlAttribute
    private String columns;

    public String getColumns() {
        return columns;
    }
}

package com.example.demo1.jaxb.pojo;

import javax.xml.bind.annotation.XmlAttribute;

public class XmlFileReader extends FileReaderBean implements ReaderInter {

    @XmlAttribute
    private String delimiter;

    @XmlAttribute
    private String endSymbol;
}

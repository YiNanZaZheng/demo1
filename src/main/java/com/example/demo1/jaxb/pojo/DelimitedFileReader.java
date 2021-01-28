package com.example.demo1.jaxb.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DelimitedFileReader extends FileReaderBean implements ReaderInter {
    @XmlAttribute
    private String delimiter;

}

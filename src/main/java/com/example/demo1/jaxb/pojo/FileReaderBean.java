package com.example.demo1.jaxb.pojo;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

@Getter
public abstract class FileReaderBean {
    @XmlElement
    private String names;
    @XmlElement
    private String fileSystem;
    @XmlElement
    private String afterDownload;
    @XmlElement
    private String encoding;
    @XmlElement
    private String comments;
    @XmlElement
    private String linesToSkip;
    @XmlElement
    private String skippedLinesCallback;
}

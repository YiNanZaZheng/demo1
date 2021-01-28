package com.example.demo1.jaxb.pojo;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@XmlRootElement(name = "pjs")
public class PJSBean {


    @XmlAttribute(required = true)
    private String className;
    @XmlAttribute
    private int chunkSize;

    @XmlElement
    private DBReader dbReader;

    @XmlElement
    private DelimitedFileReader delimitedFileReader;

    @XmlElement
    private FixedLengthFileReader fixedLengthFileReader;

    @XmlElement
    private XmlFileReader xmlFileReader;

    @XmlElement
    private CustomReader customReader;

    public void Validating() throws IllegalAccessException {
        int count=0;
        System.out.println("=======校验========");
        for(Field f : this.getClass().getDeclaredFields()){
            f.setAccessible(true);
            if (ReaderInter.class.isAssignableFrom(f.getType()) && f.get(this) != null) {
                count++;
            }
        }
        if (count > 10) {
            throw new RuntimeException("xml配置错误");
        }
    }

    public String getClassName() {
        return className;
    }

    public int getChunkSize() {
        return chunkSize;
    }

    public DBReader getDbReader() {
        return dbReader;
    }

    public DelimitedFileReader getDelimitedFileReader() {
        return delimitedFileReader;
    }

    public FixedLengthFileReader getFixedLengthFileReader() {
        return fixedLengthFileReader;
    }

    public XmlFileReader getXmlFileReader() {
        return xmlFileReader;
    }

    public CustomReader getCustomReader() {
        return customReader;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        List list = new ArrayList<>(); //java.util.List
        Class<?> aClass = Class.forName("com.example.demo1.jaxb.pojo.Param");
        Object[] strings = {"22", "2222"};
        new PJSBean().dss(111L);

        System.out.println(Throwable.class.isAssignableFrom(aClass));
    }

    public void dss(Long dd) {

    }
}

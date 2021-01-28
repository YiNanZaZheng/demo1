package com.example.demo1.jaxb.pojo;

import com.example.demo1.sys.kafka.KafkaConstants;
import com.google.common.collect.Maps;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.ServerSocket;
import java.util.List;
import java.util.Map;

@XmlRootElement
public class DBReader implements ReaderInter {

    @XmlAttribute
    private String sqlId;
    @XmlAttribute
    private String pageSize;
    @XmlAttribute
    private String paramFun;

    @XmlElementWrapper(name = "paramValues")
    @XmlElement(name = "param")
    private List<Param> paramValues;

    @XmlElementWrapper(name = "paramMappings")
    @XmlElement(name = "param")
    private List<Param> paramMappings;

    public String getSqlId() {
        return sqlId;
    }

    public String getPageSize() {
        return pageSize;
    }

    public String getParamFun() {
        return paramFun;
    }

    public List<Param> getParamValues() {
        return paramValues;
    }

    public List<Param> getParamMappings() {
        return paramMappings;
    }

    public Map<String,String> getMapParamValues() {
        Map<String, String> paramValuesMap = Maps.newConcurrentMap();
        paramValues.forEach(p -> paramValuesMap.put(p.getKey(),p.getValue()));
        new Integer("2222");
        return paramValuesMap;
    }

    public Map<String,String> getMapParamMappings() {
        Map<String, String> paramMappingsMap = Maps.newConcurrentMap();
        paramValues.forEach(p -> paramMappingsMap.put(p.getKey(),p.getValue()));
        return paramMappingsMap;
    }

}

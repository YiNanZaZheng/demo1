package com.example.simplespring.ioc;

public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}

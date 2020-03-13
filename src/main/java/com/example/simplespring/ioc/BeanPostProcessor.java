package com.example.simplespring.ioc;

public interface BeanPostProcessor {
    void postBeanBeforeInitialization(Object bean ,String beanName);
    void postBeanAfterInitialization(Object bean ,String beanName);
}

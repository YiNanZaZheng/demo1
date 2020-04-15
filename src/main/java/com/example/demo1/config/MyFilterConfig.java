package com.example.demo1.config;

import com.example.demo1.filter.MyFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class MyFilterConfig {
    private static final Logger logger = LoggerFactory.getLogger(MyFilterConfig.class);

    @Autowired
    MyFilter myFilter;

    @Bean
    public FilterRegistrationBean<MyFilter> thirdFilter() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        //存在多个过滤器的时候指定优先级
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.setFilter(myFilter);
        logger.info("=====================配置过滤器=======================");
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));

        return filterRegistrationBean;
    }
}

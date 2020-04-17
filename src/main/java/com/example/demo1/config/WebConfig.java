package com.example.demo1.config;

import com.example.demo1.interceptor.LogInterceptor;
import com.example.demo1.interceptor.OldBookLinkInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LogInterceptor());

        //配置拦截器和要拦截的url，excludePathPatterns是排除掉那些url。
        registry.addInterceptor(new OldBookLinkInterceptor()).addPathPatterns("/book").excludePathPatterns("/test/book");

        //registry.addInterceptor(new OldBookLinkInterceptor()).addPathPatterns("/test/*").excludePathPatterns("/test/book");


    }
}

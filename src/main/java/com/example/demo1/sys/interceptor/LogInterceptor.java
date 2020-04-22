package com.example.demo1.sys.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor extends HandlerInterceptorAdapter {
    //准写代码了，能提交吗
    private static final Logger logger= LoggerFactory.getLogger(LogInterceptor.class);

    //前置处理，进行编码、安全控制等处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("---------LogInterceptor.preHandle---------------");
        return true;
    }

    //后置处理，可以在这里对ModelAndView进行修改
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("---------LogInterceptor.postHandle---------------");
    }

    //可以根据ex是否为null判断是否发生了异常，进行日志记录或者清理资源
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("---------LogInterceptor.afterCompletion---------------");
    }
}

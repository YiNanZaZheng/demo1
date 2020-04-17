package com.example.demo1.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

public class OldBookLinkInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(OldBookLinkInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("=========OldLoginInterceptor.preHandle=================");
        logger.info(request.getParameter("name"));
        logger.info("此路不通，转发到最新链接");
        response.sendRedirect(request.getContextPath()+"/api/book?name="+ URLEncoder.encode(request.getParameter("name"),"GBK"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("=========OldLoginInterceptor.postHandle=================");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("=========OldLoginInterceptor.afterCompletion=================");
    }
}

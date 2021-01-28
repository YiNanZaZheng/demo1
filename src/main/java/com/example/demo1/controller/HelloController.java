package com.example.demo1.controller;

import com.example.demo1.sys.domain.LibraryProperties;
import com.example.demo1.sys.domain.ProfileProperties;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedWriter;
import java.io.FileWriter;

@Controller
@EnableConfigurationProperties(ProfileProperties.class)
public class HelloController implements ApplicationContextAware {

    private ApplicationContext context;
    //读取配置文件
    @Value("${wuhan2020}")
    String wuhan2020;

    @Autowired
    LibraryProperties libraryProperties;

    ProfileProperties profileProperties;

    @GetMapping("/hello")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name, Model model) {
        System.out.println("H5Hello");
        Object demoCreate = context.getBean("demoCreate");
        model.addAttribute("name", name);
        model.addAttribute("story",wuhan2020);
        model.addAttribute("library",libraryProperties);
        model.addAttribute("profileProperties",profileProperties);
        return "hello/hello";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
    @SneakyThrows
    public static void main(String[] args) {
        boolean aTrue = Boolean.parseBoolean("TRUE");
        System.out.println(aTrue);
        ss('b');
    }

    public static String ss(char ch) {
        return null;
    }
}

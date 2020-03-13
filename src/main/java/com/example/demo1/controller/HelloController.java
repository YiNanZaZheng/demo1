package com.example.demo1.controller;

import com.example.demo1.domain.LibraryProperties;
import com.example.demo1.domain.ProfileProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableConfigurationProperties(ProfileProperties.class)
public class HelloController {

    //读取配置文件
    @Value("${wuhan2020}")
    String wuhan2020;

    @Autowired
    LibraryProperties libraryProperties;

    ProfileProperties profileProperties;

    @GetMapping("/hello")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name, Model model) {
        System.out.println("H5Hello");
        model.addAttribute("name", name);
        model.addAttribute("story",wuhan2020);
        model.addAttribute("library",libraryProperties);
        model.addAttribute("profileProperties",profileProperties);
        return "hello/hello";
    }
}

package com.example.demo1;

import javafx.application.Application;
import lombok.SneakyThrows;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class Demo1Application {

    @SneakyThrows
    public static void main(String[] args) {

        new BufferedReader(new FileReader(new File("")));
        SpringApplication app = new SpringApplication(Demo1Application.class);
//        app.addListeners(new StartingApplication());
        app.run(args);
        SpringApplication.run(Demo1Application.class, args);
    }
}

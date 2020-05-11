package com.example.demo1.entity;

import com.example.demo1.sys.annotation.Region;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private int id;

    private String name;
    private int age;
    private double money;
    @Region
    private String region;

}

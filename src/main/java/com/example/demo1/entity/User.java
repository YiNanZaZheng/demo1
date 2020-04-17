package com.example.demo1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private int id;

    private String name;
    private int age;
    private double money;

}

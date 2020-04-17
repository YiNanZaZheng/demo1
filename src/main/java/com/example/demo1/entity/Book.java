package com.example.demo1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Book {

    private Long id;
    private String name;
    private String description;

    public Book(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

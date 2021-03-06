package com.example.demo1.sys.domain;


import com.example.demo1.entity.Book;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "library")
@Data
public class LibraryProperties {
    private String location;
    private List<Book> books;

}

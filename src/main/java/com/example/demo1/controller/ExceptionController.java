package com.example.demo1.controller;

import com.example.demo1.domain.ErrorResponse;
import com.example.demo1.exception.ResourceNotFoundException;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExceptionController {

    @GetMapping("/illegalae")
    public void throwException1() {
        throw new IllegalArgumentException();
    }

    @GetMapping("/resourcenf")
    public void throwException2() {
        throw new ResourceNotFoundException();
    }
}

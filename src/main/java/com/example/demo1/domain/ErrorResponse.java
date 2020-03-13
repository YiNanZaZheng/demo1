package com.example.demo1.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
    private String message;
    private String errorTyprName;

    public ErrorResponse(Exception e) {
        this(e.getClass().getName(),e.getMessage());
    }

    public ErrorResponse(String errorTyprName, String message) {
        this.errorTyprName=errorTyprName;
        this.message=message;
    }
}

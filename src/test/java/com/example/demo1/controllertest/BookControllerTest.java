package com.example.demo1.controllertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void arryTest() throws Exception{
        mockMvc.perform(get("/api/test")).andExpect(status().is(200));
    }

    public static void main(String[] args) {
        Boolean aTrue = new Boolean("true");
        Class<? extends Boolean> aClass = aTrue.getClass();
        System.out.println(aTrue.getClass());
        Boolean aa = true;
        Class<? extends Boolean> aClass1 = aa.getClass();
        System.out.println();

    }
}

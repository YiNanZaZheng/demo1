package com.example.demo1.controllertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void arryTest() throws Exception{
        mockMvc.perform(get("/api/test")).andExpect(status().is(200));
    }

}

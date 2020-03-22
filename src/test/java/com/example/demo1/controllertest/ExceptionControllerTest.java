package com.example.demo1.controllertest;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ExceptionControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    void should_return_400_if_param_not_valid() throws Exception{
        mockMvc.perform(get("/api/illegalae")).andExpect(status().is(400))
                .andExpect(jsonPath("$.message").value("参数错误！"));
    }

    @Test
    void should_return_400_if_source_notfound_valid() throws Exception{
        mockMvc.perform(get("/api/resourcenf")).andExpect(status().is(400))
                .andExpect(jsonPath("$.message").value("Sorry,the resource not fount"));
    }
}

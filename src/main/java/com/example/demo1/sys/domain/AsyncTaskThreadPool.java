package com.example.demo1.sys.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
@ConfigurationProperties(prefix = "asynctaskthreadpool")
@Data
public class AsyncTaskThreadPool {
    private int core_pool_size;
    private int max_pool_size;
    private int queue_capacity;
    private String thread_name_prefix;
    private String rejectedExectionHandler;

}

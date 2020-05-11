package com.example.demo1.config;

import com.example.demo1.sys.domain.AsyncTaskThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    @Autowired
    AsyncTaskThreadPool asyncTaskThreadPool;

    @Bean
    public Executor taskExecutor() {
        System.out.println(asyncTaskThreadPool.toString());
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(asyncTaskThreadPool.getCore_pool_size());
        executor.setMaxPoolSize(asyncTaskThreadPool.getMax_pool_size());
        executor.setQueueCapacity(asyncTaskThreadPool.getQueue_capacity());
        //TODO:改天通过反射实现这个逻辑，增加到配置文件中
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix(asyncTaskThreadPool.getThread_name_prefix());
        executor.initialize();
        return executor;
    }
}

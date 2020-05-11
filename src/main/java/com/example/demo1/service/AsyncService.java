package com.example.demo1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    private List<String> movies=new ArrayList<>(Arrays.asList("Forrest Gump",
            "Titanic",
            "Spirited Away",
            "The Shawshank Redemption",
            "Zootopia",
            "Farewell ",
            "Joker",
            "Crawl"));

    @Async
    public CompletableFuture<List<String>> completableFutureTask(String start) {
        logger.warn("Thread Name:{},start this task!", Thread.currentThread().getName());
        //找到特定开头的movies
        List<String> results = movies.stream().filter(movies -> movies.startsWith(start)).collect(Collectors.toList());
        //模拟一个耗时
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(results);
    }
}

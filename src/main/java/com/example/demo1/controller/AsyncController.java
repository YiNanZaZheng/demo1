package com.example.demo1.controller;

import com.example.demo1.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @GetMapping("/movies")
    public String completableFutureTask() throws ExecutionException,InterruptedException {
        //开始时间
        long startTime = System.currentTimeMillis();
        List<String> words = Arrays.asList("F", "T", "S", "Z", "J", "C");
        List<CompletableFuture<List<String>>> completableFutureList =
                words.stream().map(word ->
                        asyncService.completableFutureTask(word)).collect(Collectors.toList());
        //CompletableFuture::join 获取他们的结果，并将他们连接起来
        List<List<String>> results =
                completableFutureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("耗时："+(System.currentTimeMillis()-startTime));

        return results.toString();
    }
}

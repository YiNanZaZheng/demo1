package com.example.demo1.sys.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@EnableAsync
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    /**
     * cron：使用Cron表达式。　每分钟的1，2秒运行
     */
    @Scheduled(cron = "1-2 * * * * ? ")
    public void reportCurrentTimeWithCronExpression() {
        log.info("Cron Expression: The time is now {}", dateFormat.format(new Date()));
    }

    /**
     * fixedRate:固定速率，每五秒一次
     * fixedDelay：固定延迟执行。距离上一次调用成功后5秒才执。
     * initialDelay:初始延迟。任务的第一次执行将延迟5秒，然后将以5秒的固定间隔执行。
     */
    @Async
    @Scheduled(fixedDelay =2000)
    public void reportCurrentTimeWithFixedRate() throws InterruptedException {
        log.info("Current Thread:{}", Thread.currentThread().getName());
        Thread.sleep(5000);
        log.info("fixedDelay Task:The time now {}",dateFormat.format(new Date()));
    }

}

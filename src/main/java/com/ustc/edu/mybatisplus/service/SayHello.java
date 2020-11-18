package com.ustc.edu.mybatisplus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

@Service
public class SayHello {
    private Logger logger = LoggerFactory.getLogger(SayHello.class);

    @Async("taskExecutor")
    public CompletableFuture<String> say(String i) throws InterruptedException {
        logger.info("HELLO"+i);
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(i);
    }

    @Async("taskExecutor")
    public void start(String i, CountDownLatch countDownLatch) throws InterruptedException {
        logger.info("HELLO"+i);
        countDownLatch.countDown();
        Thread.sleep(1000L);
    }
}

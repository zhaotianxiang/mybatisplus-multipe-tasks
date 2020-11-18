package com.ustc.edu.mybatisplus;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ustc.edu.mybatisplus.service.SayHello;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@EnableAsync
@MapperScan("com.ustc.edu.mybatisplus.mapper")
public class MybatisplusApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(MybatisplusApplication.class);
    @Autowired
    private SayHello sayHello;

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int j = 0; j < 7;j++){
            CountDownLatch latch = new CountDownLatch(20);
            for (int i = 0; i < 20; i++) {
               sayHello.start(String.valueOf(i), latch);
            }
            latch.await();
            logger.info(String.valueOf(latch.getCount()));
            logger.info(String.valueOf(j));
        }

        List<CompletableFuture<String>> list = Lists.newArrayList();
        Map<String, String> map = Maps.newHashMap();
        for (int j = 0; j < 7;j++){
            for (int i = 0; i < 200; i++) {
                list.add(sayHello.say(String.valueOf(i)));
            }
            StringBuilder sb = new StringBuilder();
            CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()])).whenComplete((v ,t)-> list.forEach(cf -> {
                sb.append(cf.getNow(null)).append(",");
            }));
        }
        list.forEach(x -> {
            try {
                logger.info(x.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

}

package com.ustc.edu.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
@EnableCaching
@MapperScan("com.ustc.edu.mybatisplus.mapper")
public class MybatisplusApplication{
    private Logger logger = LoggerFactory.getLogger(MybatisplusApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }

}

package com.ustc.edu.mybatisplus.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CountryServiceImplTest {
    @Autowired
    CountryServiceImpl countryService;

    @Test
    void selectById() {
        for(int i=0; i<1000; ++i){
            countryService.selectById(1);
        }
        Assert.assertNotNull(countryService.selectById(1));
    }
}
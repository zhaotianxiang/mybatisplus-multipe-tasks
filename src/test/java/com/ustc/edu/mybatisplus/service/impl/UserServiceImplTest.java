package com.ustc.edu.mybatisplus.service.impl;

import com.ustc.edu.mybatisplus.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserServiceImpl userService;

    @Test
    public void selectedUser() {
        for (int i = 0; i < 1000; ++i) {
            userService.selectById(1);
        }
        userService.selectById(1);
    }

    @Test
    void selectAll() {
        List<User> users = userService.selectAll();
        Assert.assertNotEquals(0, users.size());
    }
}
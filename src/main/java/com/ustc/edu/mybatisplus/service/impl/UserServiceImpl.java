package com.ustc.edu.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ustc.edu.mybatisplus.entity.Country;
import com.ustc.edu.mybatisplus.entity.User;
import com.ustc.edu.mybatisplus.mapper.UserMapper;
import com.ustc.edu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author loong
 * @since 2020-12-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Cacheable(value = "users")
    public User selectById(int id) {
        return userMapper.selectById(id);
    }

    @Cacheable(value = "users")
    public List<User> selectAll(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return userMapper.selectList(queryWrapper);
    }
}

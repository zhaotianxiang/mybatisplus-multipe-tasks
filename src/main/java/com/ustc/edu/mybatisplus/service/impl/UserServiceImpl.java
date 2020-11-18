package com.ustc.edu.mybatisplus.service.impl;

import com.ustc.edu.mybatisplus.entity.User;
import com.ustc.edu.mybatisplus.mapper.UserMapper;
import com.ustc.edu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author loong
 * @since 2020-11-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

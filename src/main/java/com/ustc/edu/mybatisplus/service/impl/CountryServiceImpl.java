package com.ustc.edu.mybatisplus.service.impl;

import com.ustc.edu.mybatisplus.entity.Country;
import com.ustc.edu.mybatisplus.entity.User;
import com.ustc.edu.mybatisplus.mapper.CountryMapper;
import com.ustc.edu.mybatisplus.mapper.UserMapper;
import com.ustc.edu.mybatisplus.service.CountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author loong
 * @since 2020-11-18
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements CountryService {
    @Resource
    private CountryMapper countryMapper;

    @Cacheable(value = "countries")
    public Country selectById(int id) {
        return countryMapper.selectById(id);
    }
}

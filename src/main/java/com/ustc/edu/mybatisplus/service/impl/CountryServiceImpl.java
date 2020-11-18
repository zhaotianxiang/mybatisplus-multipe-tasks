package com.ustc.edu.mybatisplus.service.impl;

import com.ustc.edu.mybatisplus.entity.Country;
import com.ustc.edu.mybatisplus.mapper.CountryMapper;
import com.ustc.edu.mybatisplus.service.CountryService;
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
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements CountryService {

}

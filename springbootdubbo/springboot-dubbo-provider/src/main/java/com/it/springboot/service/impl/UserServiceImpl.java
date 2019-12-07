package com.it.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.it.springboot.mapper.UserMapper;
import com.it.springboot.model.User;
import com.it.springboot.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public String sayHi() {

        return "Hello EveryBody!";
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(1);
    }
}

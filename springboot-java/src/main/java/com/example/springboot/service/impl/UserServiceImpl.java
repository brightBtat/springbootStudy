package com.example.springboot.service.impl;

import com.example.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void sayHi(String name) {
        System.out.println(name);
    }
}

package com.example.springboot.controller;

import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class RedisTest {

    @Autowired
    private UserService userService;

    public Object users() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                userService.getAllUser();
            }
        };

        //多线程测试一下缓存穿透问题
        ExecutorService executorService = Executors.newFixedThreadPool(25);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(runnable);
        }
        return userService.getAllUser();
    }
}

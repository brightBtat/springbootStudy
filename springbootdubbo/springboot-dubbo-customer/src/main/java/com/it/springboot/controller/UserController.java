package com.it.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.it.springboot.model.User;
import com.it.springboot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/boot/dubbo")
    public String sayHi() {

        return userService.sayHi();
    }

    @GetMapping("/boot/dubbo/getUser")
    public User getUser() {
        return userService.getUser(1);
    }

}

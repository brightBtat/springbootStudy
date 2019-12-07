package com.it.springboot.service;

import com.it.springboot.model.User;

public interface UserService {
    public String sayHi();

    public User getUser(int id);
}

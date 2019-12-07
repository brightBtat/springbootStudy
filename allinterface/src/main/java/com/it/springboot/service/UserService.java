package com.it.springboot.service;

import com.it.springboot.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 分页查询
     * @param paramMap
     * @return
     */
    public List<User> getUserByPage(Map<String,Object> paramMap);

    /**
     * 分页需要查询的总数
     * @return
     */
    public int getUserByTotal();


    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(Integer id);

    public User getUserById(Integer id);
}

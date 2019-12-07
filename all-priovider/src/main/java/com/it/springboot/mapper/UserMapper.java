package com.it.springboot.mapper;

import com.it.springboot.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> selectUserByPage(Map<String,Object> paramMap);

    int selectUserByTotal();

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
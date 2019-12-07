package com.it.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.it.springboot.mapper.UserMapper;
import com.it.springboot.model.User;
import com.it.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(User user) {
        redisTemplate.delete("data");
        redisTemplate.delete("totalPage");
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteUser(Integer id) {
        redisTemplate.delete("data");
        redisTemplate.delete("totalPage");
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> getUserByPage(Map<String, Object> paramMap) {

        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);

        List<User> list = (List<User>)redisTemplate.opsForValue().get("data:" + paramMap.get("startRow"));

        if(list == null){
            synchronized (this){
                if(list == null){
                    list = userMapper.selectUserByPage(paramMap);
                    redisTemplate.opsForValue().set("data"+paramMap.get("startRow"),list);
                }
            }
        }
        return list;
    }

    @Override
    public int getUserByTotal() {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);

        Integer totalPage = (Integer) redisTemplate.opsForValue().get("totalPage");

        if(totalPage == null){
            synchronized (this){
                if(totalPage == null){
                    totalPage = userMapper.selectUserByTotal();
                    redisTemplate.opsForValue().set("totalPage",totalPage);
                }
            }
        }
        return totalPage;
    }
}

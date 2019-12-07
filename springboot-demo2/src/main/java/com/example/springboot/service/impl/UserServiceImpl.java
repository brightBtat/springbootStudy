package com.example.springboot.service.impl;

import com.example.springboot.mapper.TUserMapper;
import com.example.springboot.model.TUser;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper tUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
    @Override
    public List<TUser> getAllUser() {

        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        List<TUser> list = (List<TUser>) redisTemplate.opsForValue().get("allUsers");

        if (list == null) {
            synchronized (this) {

                list = (List<TUser>) redisTemplate.opsForValue().get("allUsers");

                System.out.println("查询缓存...");


                if (list == null) {
                    list = tUserMapper.selectAllUser();
                    redisTemplate.opsForValue().set("allUsers", list);

                    System.out.println("查询数据库...");
                }
            }
        } else {
            System.out.println("查询缓存...");
        }
        return list;
    }
}

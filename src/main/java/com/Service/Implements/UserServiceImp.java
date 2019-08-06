package com.Service.Implements;

import com.Model.UserModel;
import com.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Created by liangwenchang on 2019/8/6.
 */
@Component
public class UserServiceImp implements IUserService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void AddUser(UserModel userModel) {
        System.out.println(userModel.getId());
        System.out.println(userModel.toString());
        redisTemplate.opsForValue().set(userModel.getId(),userModel);
    }

    @Override
    public UserModel GetUser(String id) {
        return (UserModel)redisTemplate.opsForValue().get(id);
    }
}

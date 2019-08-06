package com.Controller;

import com.Model.UserModel;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangwenchang on 2019/8/5.
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("set/{key}/{value}")
    @ResponseBody
    public String set(@PathVariable("key") String key, @PathVariable("value") String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return key + ":" + value;
    }

    @RequestMapping("get/{key}")
    public String get(Model model,@PathVariable("key") String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        List<UserModel> list = new ArrayList<>();
        UserModel userModel = new UserModel();
        userModel.setId(key);
        userModel.setName(value);
        list.add(userModel);

        model.addAttribute("userList",list);
        return "userList";
    }
}

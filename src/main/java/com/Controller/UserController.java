package com.Controller;

import com.Model.UserModel;
import com.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liangwenchang on 2019/8/6.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Map<String,String> addUser(@RequestBody UserModel userModel){
        System.out.println("Call addUser");
        HashMap<String,String> result = new HashMap<>();
        String respCode = "04";
        String respMsg = "无数据";
        if(userModel != null){
            userService.AddUser(userModel);
            respCode = "01";
            respMsg = "新增成功";
        }
        result.put(respCode,respMsg);
        return result;
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @Cacheable(value = "cacheName",key = "#id")
    public Map<String,Object> getUser(@PathVariable("id") String id){
        System.out.println("Call getUser");
        UserModel userModel =  userService.GetUser(id);
        System.out.println(userModel.toString());
        HashMap<String,Object> result = new HashMap<>();
        result.put("respCode", "01");
        result.put("respMsg", "成功");
        result.put("data", userModel);
        return result;
    }

}

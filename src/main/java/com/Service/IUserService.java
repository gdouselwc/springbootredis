package com.Service;

import com.Model.UserModel;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liangwenchang on 2019/8/6.
 */
@Configuration
public interface IUserService {

    public void AddUser(UserModel userModel);

    public UserModel GetUser(String id);

}

package com.wth.example.provider;

import com.wth.example.model.User;
import com.wth.example.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User getUser(User user) {
        System.out.println("用户名为: " + user.getName());
        return user;
    }
}

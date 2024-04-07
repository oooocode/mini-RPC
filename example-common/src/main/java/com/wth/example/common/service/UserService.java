package com.wth.example.common.service;


import com.wth.example.common.model.User;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 获取用户
     */
    User getUser(User user);

    default long getNumber() {
        return 1;
    }


}

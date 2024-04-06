package com.wth.example.consumer;

import com.wth.example.model.User;
import com.wth.example.service.UserService;
import com.wth.minirpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        // 获取 UserService 服务提供者对象
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("123");
        User result = userService.getUser(user);
        if (result != null) {
            System.out.println("名字为" + result.getName());
        } else {
            System.out.println("result = null");
        }

    }
}

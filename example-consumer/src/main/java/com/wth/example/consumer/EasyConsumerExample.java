package com.wth.example.consumer;

import com.wth.example.common.model.User;
import com.wth.example.common.service.UserService;
import com.wth.minirpc.RpcApplication;
import com.wth.minirpc.config.RpcConfig;
import com.wth.minirpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        System.out.println("rpcConfig = " + rpcConfig);

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
        // long number = userService.getNumber();
        // System.out.println("number = " + number);

    }
}

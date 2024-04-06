package com.wth.example.provider;

import com.wth.example.service.UserService;
import com.wth.minirpc.registry.LocalRegistry;
import com.wth.minirpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        VertxHttpServer vertxHttpServer = new VertxHttpServer();
        vertxHttpServer.doStart(8000);
    }
}

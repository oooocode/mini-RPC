package com.wth.minirpc.server;

import io.vertx.core.Vertx;

public class VertxHttpServer implements HttpServer {

    @Override
    public void doStart(int port) {
        // 创建 Vert.x 实例
        Vertx vertx = Vertx.vertx();

        io.vertx.core.http.HttpServer server = vertx.createHttpServer();

        // 设置请求处理器
        server.requestHandler(new HttpServerHandler());

        // 启动 HTTP 服务器并监听端口
        server.listen(port, result -> {
            if (result.succeeded()) {
                System.out.println("Server is now listening on port:" + port);
            } else {
                System.out.println("Fail to start server");
            }
        });


    }
}

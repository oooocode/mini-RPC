package com.wth.minirpc;

import com.wth.minirpc.config.RpcConfig;
import com.wth.minirpc.constant.RpcConstant;
import com.wth.minirpc.model.RpcRequest;
import com.wth.minirpc.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RpcApplication {
    public static volatile RpcConfig rpcConfig;


    /**
     * 支持传入自定义配置配置
     * @param rpcConfig
     */
    public static void init(RpcConfig rpcConfig) {
        RpcApplication.rpcConfig = rpcConfig;
        log.info("rpc init, config = {}", rpcConfig.toString());
    }


    public static void init() {
        RpcConfig newRpcConfig;
        try {
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            // 加载失败走默认配置
            newRpcConfig = new RpcConfig();
        }
        init(newRpcConfig);
    }

    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null) {
            synchronized (RpcConfig.class) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }
}

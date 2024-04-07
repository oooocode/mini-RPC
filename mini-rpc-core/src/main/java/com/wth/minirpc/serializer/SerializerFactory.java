package com.wth.minirpc.serializer;

import cn.hutool.core.collection.CollectionUtil;
import com.wth.minirpc.spi.SpiLoader;

import java.util.Map;


/**
 * 序列化器工厂
 */
public class SerializerFactory {

    public static volatile Map<String, Class<?>> spiClassMap;

    /**
     * 默认序列化器
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        if (CollectionUtil.isEmpty(spiClassMap)) {
            synchronized (Serializer.class) {
                if (CollectionUtil.isEmpty(spiClassMap)) {
                    loadAndSetLocalMap();
                }
            }
        }
        return SpiLoader.getInstance(Serializer.class, key);
    }

    private static void loadAndSetLocalMap() {
        SpiLoader.load(Serializer.class);
        spiClassMap = SpiLoader.getSpiClassByClassName(Serializer.class.getName());
    }

    public static void main(String[] args) {
        Serializer jdk = getInstance("jdk");
        Serializer jdk1 = getInstance("jdk");
    }
}

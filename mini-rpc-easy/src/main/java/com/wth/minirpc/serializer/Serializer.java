package com.wth.minirpc.serializer;

import java.io.IOException;

/**
 * 序列化器接口
 */
public interface Serializer {

    /**
     * 序列化
     *
     * @param object 实体类对象
     * @param <T> 泛型定义
     * @return 字节数组
     */
    <T> byte[] serialize(T object) throws IOException;

    /**
     * 反序列化
     *
     * @param bytes 字节数组
     * @param type 反序列化类型
     * @param <T> 泛型定义
     * @return 序列化实体类
     */
    <T> T deserialize(byte[] bytes, Class<T> type) throws IOException;
}
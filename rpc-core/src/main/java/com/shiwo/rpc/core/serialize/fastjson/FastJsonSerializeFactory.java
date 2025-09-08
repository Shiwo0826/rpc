package com.shiwo.rpc.core.serialize.fastjson;

import com.alibaba.fastjson.JSON;
import com.shiwo.rpc.core.serialize.SerializeFactory;

/**
 *FastJson序列化工厂
 */
public class FastJsonSerializeFactory implements SerializeFactory {

    @Override
    public <T> byte[] serialize(T t) {
        String jsonStr = JSON.toJSONString(t);
        return jsonStr.getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return JSON.parseObject(new String(data),clazz);
    }

}

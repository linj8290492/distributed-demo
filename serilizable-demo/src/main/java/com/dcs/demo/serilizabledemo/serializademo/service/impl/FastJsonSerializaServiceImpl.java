package com.dcs.demo.serilizabledemo.serializademo.service.impl;

import com.alibaba.fastjson.JSON;
import com.dcs.demo.serilizabledemo.serializademo.service.SerializaService;

/**
 * @author deke
 * @description FastJson序列化
 * @date 2019/12/25
 */
public class FastJsonSerializaServiceImpl implements SerializaService {

    @Override
    public <T> byte[] serialize(T param) {
        return JSON.toJSONString(param).getBytes();
    }

    @Override
    public <T> T deSerialize(byte[] data, Class<T> clazz) {
        return (T) JSON.parseObject(data, clazz);
    }
}

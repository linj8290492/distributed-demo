package com.dcs.demo.serilizabledemo.serializademo.service;

/**
 * @author deke
 * @description
 * @date 2019/12/24
 */
public interface SerializaService {

    <T> byte[] serialize(T param);

    <T> T deSerialize(byte[] data, Class<T> clazz);
}

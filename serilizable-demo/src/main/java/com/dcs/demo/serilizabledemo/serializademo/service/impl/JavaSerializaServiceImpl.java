package com.dcs.demo.serilizabledemo.serializademo.service.impl;

import com.dcs.demo.serilizabledemo.serializademo.service.SerializaService;

import java.io.*;

/**
 * @author deke
 * @description java在内存中的实现
 * @date 2019/12/24
 */
public class JavaSerializaServiceImpl implements SerializaService {

    @Override
    public <T> byte[] serialize(T param) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream outStm = null;

        try {
            outStm = new ObjectOutputStream(out);
            outStm.writeObject(param);

            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=outStm){
                try {
                    outStm.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return new byte[0];
    }

    @Override
    public <T> T deSerialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream inStm = null;
        try {
            inStm = new ObjectInputStream(in);
            return (T) inStm.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
            return null;
    }
}

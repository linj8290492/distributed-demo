package com.dcs.demo.serilizabledemo.serializademo.service.impl;

import com.dcs.demo.serilizabledemo.serializademo.service.SerializaService;

import java.io.*;

/**
 * @author deke
 * @description jdk序列化写入文件中
 * @date 2019/12/25
 */
public class JavaSerializerWithFileServiceImpl implements SerializaService {

    @Override
    public <T> byte[] serialize(T param) {
        ObjectOutputStream out =null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(new File("user")));
            out.writeObject(param);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(new File("user")));
            return (T) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }
}

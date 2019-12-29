package com.dcs.demo.serilizabledemo.serializademo.service.impl;

import com.alibaba.com.caucho.hessian.io.HessianInput;
import com.alibaba.com.caucho.hessian.io.HessianOutput;
import com.dcs.demo.serilizabledemo.serializademo.service.SerializaService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author deke
 * @description Hessian的序列化
 * @date 2019/12/29
 */
public class HessianSerializaServiceImpl implements SerializaService {
    @Override
    public <T> byte[] serialize(T param) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(out);

        try {
            hessianOutput.writeObject(param);
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deSerialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        HessianInput hessianInput = new HessianInput(in);

        try {
            return (T) hessianInput.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

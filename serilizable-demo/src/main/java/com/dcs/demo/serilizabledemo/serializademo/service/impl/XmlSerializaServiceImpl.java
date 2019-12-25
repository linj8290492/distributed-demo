package com.dcs.demo.serilizabledemo.serializademo.service.impl;

import com.dcs.demo.serilizabledemo.serializademo.service.SerializaService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author deke
 * @description xml序列化
 * @date 2019/12/25
 */
public class XmlSerializaServiceImpl implements SerializaService {

    XStream xStream=new XStream(new DomDriver());

    @Override
    public <T> byte[] serialize(T param) {
        return xStream.toXML(param).getBytes();
    }

    @Override
    public <T> T deSerialize(byte[] data, Class<T> clazz) {
        return (T) xStream.fromXML(new String(data));
    }
}

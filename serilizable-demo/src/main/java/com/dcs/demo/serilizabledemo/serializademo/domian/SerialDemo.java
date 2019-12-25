package com.dcs.demo.serilizabledemo.serializademo.domian;

import com.dcs.demo.serilizabledemo.entity.User;
import com.dcs.demo.serilizabledemo.serializademo.service.SerializaService;
import com.dcs.demo.serilizabledemo.serializademo.service.impl.FastJsonSerializaServiceImpl;
import com.dcs.demo.serilizabledemo.serializademo.service.impl.JavaSerializaServiceImpl;
import com.dcs.demo.serilizabledemo.serializademo.service.impl.JavaSerializerWithFileServiceImpl;
import com.dcs.demo.serilizabledemo.serializademo.service.impl.XmlSerializaServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author deke
 * @description xx
 * @date 2019/12/24
 */
public class SerialDemo {
    static Map<String, SerializaService> map = new HashMap<>(8);

    static {
        map.put("jdkSerializa", new JavaSerializaServiceImpl());
        map.put("writeFile", new JavaSerializerWithFileServiceImpl());
        map.put("xml", new XmlSerializaServiceImpl());
        map.put("fastJson", new FastJsonSerializaServiceImpl());


    }

    public static void main(String[] args) {
//        SerializaService entity = map.get("jdkSerializa");

//        SerializaService entity = map.get("writeFile");

//        SerializaService entity = map.get("xml");
        SerializaService entity = map.get("fastJson");

        User user = new User("pipi", 1);
        byte[] data = entity.serialize(user);
        System.out.println(data.length);
        //打印xml
//        System.out.println(new String(data));
        User res = entity.deSerialize(data, User.class);
        System.out.println(res);


    }
}

package com.dcs.demo.serilizabledemo.serializademo.domian;

import com.dcs.demo.serilizabledemo.entity.User;
import com.dcs.demo.serilizabledemo.serializademo.service.SerializaService;
import com.dcs.demo.serilizabledemo.serializademo.service.impl.JavaSerializaServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author deke
 * @description xx
 * @date 2019/12/24
 */
public class SerialDemo {
    static Map<String,Object> map = new HashMap<>(8);
    static {
        map.put("jdkSerializa",new JavaSerializaServiceImpl());



    }

    public static void main(String[] args) {
        SerializaService jdkSerializa = (SerializaService) map.get("jdkSerializa");

        User user = new User("pipi",1);
        byte[] data = jdkSerializa.serialize(user);
        System.out.println(data.length);
        User res = jdkSerializa.deSerialize(data, User.class);
        System.out.println(res);


    }
}

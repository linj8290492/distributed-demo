package com.dcs.demo.serilizabledemo.serializademo.domian;

import com.dcs.demo.serilizabledemo.entity.User;
import com.dcs.demo.serilizabledemo.serializademo.service.SerializaService;
import com.dcs.demo.serilizabledemo.serializademo.service.impl.JavaSerializaServiceImpl;
import com.dcs.demo.serilizabledemo.serializademo.service.impl.JavaSerializerWithFileServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author deke
 * @description xx
 * @date 2019/12/24
 */
public class SerialDemo {
    static Map<String,SerializaService> map = new HashMap<>(8);
    static {
        map.put("jdkSerializa",new JavaSerializaServiceImpl());
        map.put("writeFile",new JavaSerializerWithFileServiceImpl());



    }

    public static void main(String[] args) {
//        SerializaService entity = map.get("jdkSerializa");

        SerializaService entity = map.get("writeFile");

        User user = new User("pipi",1);
        byte[] data = entity.serialize(user);
        System.out.println(data.length);
        User res = entity.deSerialize(data, User.class);
        System.out.println(res);


    }
}

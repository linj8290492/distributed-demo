package com.dcs.demo.serilizabledemo.socket;

import com.dcs.demo.serilizabledemo.entity.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author deke
 * @description Client端
 * @date 2019/12/24
 */
public class Client {

    static Socket cSocket;
    static ObjectOutputStream out;

    public static void main(String[] args) {
        try {
            cSocket = new Socket("localhost",8080);

            // 组装一个ObjectOutputStream
            out = new ObjectOutputStream(cSocket.getOutputStream());

            // 将user 写出去
            User user = new User("linj",30);
            out.writeObject(user);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=cSocket){
                try {
                    cSocket.close();
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
    }

}

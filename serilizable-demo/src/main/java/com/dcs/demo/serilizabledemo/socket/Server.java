package com.dcs.demo.serilizabledemo.socket;

import com.dcs.demo.serilizabledemo.entity.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author deke
 * @description Server端
 * @date 2019/12/24
 */
public class Server {

    static ServerSocket sSocket;
    static ObjectInputStream in;

    public static void main(String[] args) {

        try {
            sSocket = new ServerSocket(8080);
            Socket accept = sSocket.accept();

            in = new ObjectInputStream(accept.getInputStream());

            User user = (User) in.readObject();
            System.out.println(user);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null!= sSocket){
                try {
                    sSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!= in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

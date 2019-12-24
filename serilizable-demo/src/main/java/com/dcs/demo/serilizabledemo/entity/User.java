package com.dcs.demo.serilizabledemo.entity;

import java.io.Serializable;

/**
 * @author deke
 * @description User对象
 * @date 2019/12/24
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8245190438064351573L;
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}

package com.example.springbootdemo.jksj.frotysaven;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class User implements Serializable, IUser {
    static List<User> userList;

    static {
        User zs = new User("zs", 18);
        User ls = new User("ls", 18);
        userList = new ArrayList<>();
        userList.add(zs);
        userList.add(ls);
    }

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public void sing() {
        System.out.println("学生类在唱歌");
    }

    public static void main(String[] args) {
//        List<User> proxy = userList;
//        proxy.add(new User("ww", 20));
//        proxy.remove(1);
//        List<User> us = userList;
//        System.out.println(us);

        Byte[] bytes = new Byte[]{'b','b','a'};
        System.out.println("bytes: " + bytes);
        String res = bytes.toString();
        System.out.println("bytesString: " + res);


    }

}

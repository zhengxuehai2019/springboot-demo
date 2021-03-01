package com.example.springbootdemo.jksj.frotysaven;

import java.io.*;

public class TestClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("zs",18);
        ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(user);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        System.out.println("user:" + user);
        System.out.println("copyUser:" + o);
    }
}

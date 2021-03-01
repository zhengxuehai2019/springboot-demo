package com.example.springbootdemo.jksj.twentynine;

import com.example.springbootdemo.jksj.frotysaven.User;

import java.util.concurrent.Callable;

public class MyCallableTwo implements Callable<User> {
    @Override
    public User call() throws Exception {
        System.out.println("进入222222222");
        Thread.sleep(3000);
        System.out.println("进入第二个自定义线程：" + Thread.currentThread().getName() );
        User user = new User();
        user.setName("里斯");
        user.setAge(20);
        return user;
    }
}

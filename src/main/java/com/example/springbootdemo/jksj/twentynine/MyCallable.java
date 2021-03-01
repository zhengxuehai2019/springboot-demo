package com.example.springbootdemo.jksj.twentynine;

import com.example.springbootdemo.jksj.frotysaven.User;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("进入1111111111");
        Thread.sleep(5000);
        System.out.println("进入自定义线程：" + Thread.currentThread().getName() + "执行中");
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        return user;
    }
//    @SneakyThrows
//    @Override
//    public void run() {
//        Thread.sleep(2000);
//        System.out.println("执行自己的类线程:" + Thread.currentThread());
////        super.run();
//    }
}

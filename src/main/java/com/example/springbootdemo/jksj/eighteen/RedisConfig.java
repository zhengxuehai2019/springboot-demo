package com.example.springbootdemo.jksj.eighteen;

public class RedisConfig implements Updater {
    @Override
    public void update() {
        System.out.println("执行redis更新。。。");
    }
}

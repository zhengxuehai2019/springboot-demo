package com.example.springbootdemo.jksj.thirtyfive;
@FunctionalInterface
public interface FunInterface {
    String getString();

    default String getStr1(){
        return "String";
    }
    default Integer getInt(){
        return 1;
    }
}

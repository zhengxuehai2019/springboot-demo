package com.example.springbootdemo.dimitefaze;

public class Serition implements Seri,DeSeri {
    @Override
    public Object deSeri() {
        return new StringBuffer("DeSeri");
    }

    @Override
    public String seri() {
        return "Seri";
    }
}

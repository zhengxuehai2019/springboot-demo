package com.example.springbootdemo.jksj.thirtyfive;

import java.util.concurrent.Executors;

public class TestImpl implements FunInterface {





    public static void main(String[] args) {
        Double d = Double.MIN_VALUE;
        Double dm = Double.MAX_VALUE;
        System.out.println("min:" + d + "max :" + dm);

        int idx99 = (int)(5000 * 0.999);
        int idx9 = (int)(5000 * 0.99);
        System.out.println("idx99:" + idx99 + ", id9:" + idx9);
        Executors.newSingleThreadExecutor();

    }

    @Override
    public String getString() {
        getStr1();
        getInt();
        return null;
    }
}

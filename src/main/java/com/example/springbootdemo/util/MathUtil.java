package com.example.springbootdemo.util;

public class MathUtil {
    /**
     * 生成 0-n的随机数
     */
    public static int getRandomNo(Integer toNo){
        return (int) (Math.random() * (toNo +1));
    }

    /**
     * 生成从 a到b 的随机整数
     */
    public static int getA2BRandomNo(int a,int b){
        return a + (int)(Math.random() * (b - a + 1));
    }
}

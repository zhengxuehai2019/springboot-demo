package com.example.springbootdemo.util.bit;

public class BitUtil {


    /**
     * 某个需要对比条件的类，如果满足某一个就把属性is。。。改为1然后和另一个（可以是配置好的条件）用 位 做比较
     */
    class tiaojian{
        Integer isDoc = 0;
        Integer isMoking = 0;
        Integer isGod = 0;
        Integer isDog = 0;


        public int forBit(){
            int bit = 0;
            if(isDoc > 0){
                bit |= 1<<0;
            }
            if(isMoking > 0){
                bit |= 1<<1;
            }
            if(isGod > 0){
                bit |= 1<<2;
            }
            if(isDog > 0){
                bit |= 1<<3;
            }
            return bit;
        }
        tiaojian t = new tiaojian();

        boolean isMatch = (forBit() & t.forBit()) > 0;
    }

}

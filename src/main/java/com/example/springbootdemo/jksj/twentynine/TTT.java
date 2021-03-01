package com.example.springbootdemo.jksj.twentynine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TTT {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> totalList = new ArrayList<>();
        totalList.add(1);
        totalList.add(4);
        totalList.add(5);
        totalList.add(4);
        totalList.add(2);
        totalList.add(6);
        totalList.add(8);
        totalList.add(7);
        totalList.add(9);
        totalList.add(0);
        int offset = totalList.size() / 3;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

//        Thread thread = new Thread(new MyCallable(),"t1");
//        thread.start();

//        Thread.sleep(1000);
//        System.out.println("主线程完成");

        FutureTask futureTask = new FutureTask(new MyCallable());
        FutureTask futureTask2 = new FutureTask(new MyCallableTwo());

        Thread thread = new Thread(futureTask,"ttt1");
        Thread thread1 = new Thread(futureTask2,"ttt2");
        thread.start();
        thread1.start();
        System.out.println("主线程：获取数据" + futureTask.get());

        Thread.sleep(1000);
        System.out.println("主线 :" + Thread.currentThread().getName() + "程结束");

    }


    public static int findRepeatNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return num;
            }
        }
        return res;
    }


}

package com.example.springbootdemo.lambda;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LambdaTest {
    public static void main(String[] args) {
        User user1 = new User("zhangsan",18,"20201207");
        User user2 = new User("lisi",18,"20201208");
        User user3 = new User("wangwu",18,"20201209");
        User user4 = new User("zhaoliu",18,"20201210");
        User user5 = new User("zhangsan",18,"20201207");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        System.out.println("初始化的list：" + userList);

        List<User> zhangsan = userList.stream().filter(e -> e.getName().equals("zhangsan")).collect(Collectors.toList());
        System.out.println("过滤后：" + zhangsan);

        Map<String, String> collect = userList.stream().collect(Collectors.toMap(User::getName, User::getNo,(k1,k2) -> k1));
        Map<String, User> collect1 = userList.stream().collect(Collectors.toMap(User::getName, Function.identity(),(k1,k2)->k1));
        System.out.println("value为实体本身map：" + collect1);
        System.out.println("map集合user" + collect);

        UserDto userDto = new UserDto();
        System.out.println("copy priview:" + userDto);
        BeanUtils.copyProperties(user1,userDto);
        System.out.println("====================================");
        System.out.println("copy:" + userDto);

        System.out.println("...............................");
        Comparable<Integer> comparable = new Comparable<Integer>() {
            @Override
            public int compareTo(Integer o) {
                return Integer.compare(0,100);
            }
        };
        int i = comparable.compareTo(2);
        System.out.println(i);
        
        Comparable<Integer> comparable1 = (x) -> Integer.compare(x,100);
        int i1 = comparable1.compareTo(1001);
        System.out.println(i1);

        // 只能有一个返回
        Supplier<String> res = () -> "hello world~";
        String s = res.get();
        System.out.println(s);
        int[] a = new int[2];
        int[] arr = new int[]{1,2};
        int aa = a.length - 1;
        System.out.println("---------------------------------------");
        long res1 = sideEffectSum(1000);
        long res2 = sideEffectParallelSum(1000);
        System.out.println("res1,顺序流处理：" + res1 + "res2,并行流处理的结果：" + res2);


        NoReturnMultiParam noReturnMultiParam = LambdaTest::doubleNum;
        System.out.println(noReturnMultiParam.method(3));



    }

    public static int doubleNum(int a ){
        System.out.println("sss");
        return a * 2;
    }




    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        private  long total = 0;

        public synchronized void add(long value) {
            total += value;
        }
    }

    public int[] getRes(int[] arr,int n){
        int[] b = {1,2,3,4,5,6,7};
        Map<Integer,Integer> hashTable = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(hashTable.containsKey(n - arr[i])){
                return new int[]{hashTable.get(n - arr[i]),i};
            }
            hashTable.put(arr[i],i);
        }
        return new int[0];
    }
}

package com.example.springbootdemo.jksj.frotysaven;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserProxy {

    private User user;

    public UserProxy() {
        this.user = new User();
    }

    public Object createProxy(Object proxyObject) {
        Class<?>[] interfaces = proxyObject.getClass().getInterfaces();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(proxyObject);
        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(),interfaces,dynamicProxyHandler);
    }

    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxyObject;

        public DynamicProxyHandler(Object proxyObject) {
            this.proxyObject = proxyObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("进入代理类开始代理");
            Object invoke = method.invoke(proxyObject, args);
            System.out.println("代理完毕");
            return null;
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] strs = new String[]{"xyb","yyy"};

        UserProxy userProxy = new UserProxy();
        IUser user = (IUser) userProxy.createProxy(new User());
        user.sing();

        String content = "abcabcabcabcbbbbbbbbb";
        String content1 = "abcabcabcabcbbbbbbbbbbb";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(content.getBytes());
        byte[] digest1 = md5.digest(content1.getBytes());
        System.out.println("digest: "+ digest + " --digest1: " +digest1);

    }


}


package com.example.springbootdemo.lock.redislock;

import com.example.springbootdemo.util.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
@Service
public class RedisLock {
    @Autowired
    RedisUtil redisUtils;
    public void mockLock() throws InterruptedException {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取本机ip
        String ip = addr.getHostAddress();
        //此key存放的值为任务执行的ip，
        // expire_time 不能设置为永久，避免死锁
        boolean lock = redisUtils.tryLock("lock_key", ip, 0);
        if (lock) {
            System.out.println("获取分布式锁成功");
            run();
            //释放锁
            redisUtils.unLock("lock_key",ip);
            System.out.println("释放分布式锁成功");
        } else {
            System.out.println("获得分布式锁失败");
            ip = (String) redisUtils.get("lock_key");
            System.out.println(ip+"正在执行该任务");
            return;
        }
    }
    public void run() throws InterruptedException {
        System.out.println("业务执行中");
        Thread.sleep(60 * 3);
        System.out.println("业务执行结束");
    }
}

package com.example.springbootdemo.jksj.eighteen;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleUpdater {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private Long initialDelayInSeconds;
    private long periodInSeconds;
    private Updater updater;

    public ScheduleUpdater(Long initialDelayInSeconds, long periodInSeconds, Updater updater) {
        this.initialDelayInSeconds = initialDelayInSeconds;
        this.periodInSeconds = periodInSeconds;
        this.updater = updater;
    }

    public void run(){
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行更新方法");
            }
        },this.initialDelayInSeconds,this.periodInSeconds, TimeUnit.SECONDS);
    }
}

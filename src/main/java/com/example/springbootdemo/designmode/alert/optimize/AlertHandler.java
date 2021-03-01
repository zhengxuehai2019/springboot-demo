package com.example.springbootdemo.designmode.alert.optimize;

import com.example.springbootdemo.designmode.alert.AlertRule;
import com.example.springbootdemo.designmode.alert.Notification;

public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}

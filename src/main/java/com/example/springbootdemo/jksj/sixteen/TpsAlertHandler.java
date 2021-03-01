package com.example.springbootdemo.jksj.sixteen;

import com.example.springbootdemo.designmode.alert.AlertRule;
import com.example.springbootdemo.designmode.alert.Notification;
import com.example.springbootdemo.designmode.alert.NotificationEmergencyLevel;
import com.example.springbootdemo.designmode.alert.optimize.AlertHandler;
import com.example.springbootdemo.designmode.alert.optimize.ApiStatInfo;

public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        Long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if(tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()){
            notification.notify(NotificationEmergencyLevel.URGENCY,"次数通知");
        }
    }
}

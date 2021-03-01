package com.example.springbootdemo.jksj.sixteen;

import com.example.springbootdemo.designmode.alert.AlertRule;
import com.example.springbootdemo.designmode.alert.Notification;
import com.example.springbootdemo.designmode.alert.optimize.ApiStatInfo;

/**
 * 优化分为两部分：
 *  1.将check（）函数多个参数封装成 ApiStatInfo 类；
 *  2.引入 handler 的概念，把 if 逻辑分担在各个handler中；
 */
public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initializeBeans(){
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule,notification));
        // alert.addAlertHandler(new ...);
    }

    public Alert getAlert(){
        return alert;
    }

    private static final ApplicationContext instance = new ApplicationContext();
    private ApplicationContext(){
        initializeBeans();
    }

    public static  ApplicationContext getInstance(){
        return instance;
    }

    public static class Demo {
        public static void main(String[] args) {
            ApiStatInfo apiStatInfo = new ApiStatInfo();
            ApplicationContext.getInstance().getAlert().check(apiStatInfo);
        }
    }

}

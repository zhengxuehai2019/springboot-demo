package com.example.springbootdemo.jksj.sixteen;

import com.example.springbootdemo.designmode.alert.optimize.AlertHandler;
import com.example.springbootdemo.designmode.alert.optimize.ApiStatInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 优化 API接口监控告警
 * 分为两部分：
 *  1.将check（）函数的多个入参封装成 ApiStatInfo 类；
 *  2.引入 handler 的概念，将 if 判断逻辑分散在各个 handler 中；
 */
public class Alert {
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler){
        this.alertHandlers.add(alertHandler);
    }
    public void check(ApiStatInfo apiStatInfo){
        for (AlertHandler alertHandler : alertHandlers) {
            alertHandler.check(apiStatInfo);
        }
    }
}

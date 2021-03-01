package com.example.springbootdemo.designmode.alert.optimize;

import lombok.Data;

@Data
public class ApiStatInfo extends Alert{
    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;


    @Override
    public void addAlertHandler(AlertHandler alertHandler) {
        if(true){
            return;
        }
        
        super.addAlertHandler(alertHandler);
    }
}

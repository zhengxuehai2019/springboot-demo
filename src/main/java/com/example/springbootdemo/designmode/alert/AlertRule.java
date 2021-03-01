package com.example.springbootdemo.designmode.alert;

import java.util.HashMap;
import java.util.Map;

public class AlertRule {
    private Map<String,ApiRule> map = new HashMap<>();

    public ApiRule getMatchedRule(String url){
        return map.get(url);
    }
}

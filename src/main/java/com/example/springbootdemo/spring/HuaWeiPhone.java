package com.example.springbootdemo.spring;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class HuaWeiPhone implements Phone {
    private String name = "huawei";
    @Override
    public String makePhone() {
        System.out.println("生产huawei。。。。。");
        name = "huawei";
        return "huawei";
    }
}

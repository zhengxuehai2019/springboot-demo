package com.example.springbootdemo.designmode.alert;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRule {
    private Integer maxTps;
    private Integer maxErrorCount;
    private Integer timeOupCount;


}

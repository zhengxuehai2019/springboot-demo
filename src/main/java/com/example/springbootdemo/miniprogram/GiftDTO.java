package com.example.springbootdemo.miniprogram;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GiftDTO {
    /**
     * 索引
     */
    private Integer index;


    /**
     * 奖品名称
     */
    private String name;

    /**
     * 奖品编号
     */
    private String no;


    /**
     * 中奖概率
     */
    private Double probability;


    public static void main(String[] args) {

    }
}

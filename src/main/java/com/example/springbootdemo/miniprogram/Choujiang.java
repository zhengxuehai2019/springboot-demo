package com.example.springbootdemo.miniprogram;

import com.example.springbootdemo.util.MathUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class Choujiang {

    public static int lottery(List<Double> orignalRates) {

        if (orignalRates == null || orignalRates.isEmpty()) {
            return -1;
        }

        int size = orignalRates.size();

        // 计算总概率，这样可以保证不一定总概率是1
        double sumRate = 0d;
        for (double rate : orignalRates) {
            sumRate += rate;
        }

        // 计算每个物品在总概率的基础下的概率情况
        List<Double> sortOrignalRates = new ArrayList<>(size);
        Double tempSumRate = 0d;
        for (double rate : orignalRates) {
            tempSumRate += rate;
            sortOrignalRates.add(tempSumRate / sumRate);
        }

        // 根据区块值来获取抽取到的物品索引
        double nextDouble = Math.random() * 100;
        sortOrignalRates.add(nextDouble);
        Collections.sort(sortOrignalRates);

        return sortOrignalRates.indexOf(nextDouble);
    }


    public int getPrizeIndex(List<Prize> prizes) {
        DecimalFormat df = new DecimalFormat("######0.00");
        int random = -1;
        try{
            //计算总权重
            double sumWeight = 0;
            for(Prize p : prizes){
                sumWeight += p.getPrize_weight();
            }

            //产生随机数
            double randomNumber;
            randomNumber = Math.random();

            //根据随机数在所有奖品分布的区域并确定所抽奖品
            double d1 = 0;
            double d2 = 0;
            for(int i=0;i<prizes.size();i++){
                d2 += Double.parseDouble(String.valueOf(prizes.get(i).getPrize_weight()))/sumWeight;
                if(i==0){
                    d1 = 0;
                }else{
                    d1 +=Double.parseDouble(String.valueOf(prizes.get(i-1).getPrize_weight()))/sumWeight;
                }
                if(randomNumber >= d1 && randomNumber <= d2){
                    random = i;
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("生成抽奖随机数出错，出错原因：" +e.getMessage());
        }
        return random;
    }

    /**
     * 计算自身相对于总体的比例
     *
     * @param self 自身
     * @param all  总体
     * @return 比例
     */
    private static float getPercent(Integer self, Integer all) {
        // 比例计算出来会有很多小数，为了看得清晰，要四舍五入一下
        float v = new BigDecimal(self / all.floatValue()).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        return v;
    }

    /**
     * 根据比例，在100之间计算出区间跨度，进一步来计算中奖区间
     *
     * @param percent 比例
     * @return 跨度
     */
    private static int getRandom(float percent) {
        // 如果getPercent中没有四舍五入，那么就需要在这里四舍五入
        return new BigDecimal(percent * 100).intValue();
    }


}

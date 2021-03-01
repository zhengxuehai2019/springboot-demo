package com.example.springbootdemo.jksj.twentyfive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Metrics {
    // Map的key是接口名称，value对应接口请求的响应时间或时间戳；
    private Map<String, List<Double>> responseTimes = new HashMap<>();
    private Map<String, List<Double>> timestamps = new HashMap<>();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();


    public void test(){
        Map map = new HashMap();

    }

//    public void startRepeatedReport(long period, TimeUnit unit) {
//        executor.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                Gson gson = new Gson();
//                Map > stats = new HashMap<>();
//                for (Map.Entry > entry :responseTimes.entrySet()){
//                    String apiName = entry.getKey();
//                    List apiRespTimes = entry.getValue();
//                    stats.putIfAbsent(apiName, new HashMap<>());
//                    stats.get(apiName).put("max", max(apiRespTimes));
//                    stats.get(apiName).put("avg", avg(apiRespTimes));
//                }
//                for (Map.Entry > entry :timestamps.entrySet()){
//                    String apiName = entry.getKey();
//                    List apiTimestamps = entry.getValue();
//                    stats.putIfAbsent(apiName, new HashMap<>());
//                    stats.get(apiName).put("count", (double) apiTimestamps.size());
//                }
//                System.out.println(gson.toJson(stats));
//            }
//        }, 0, period, unit);
//    }


}

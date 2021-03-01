package com.example.springbootdemo.jksj.sixteen;

import com.example.springbootdemo.designmode.alert.AlertRule;
import com.example.springbootdemo.designmode.alert.Notification;
import com.example.springbootdemo.designmode.alert.NotificationEmergencyLevel;

/**
 * API监控接口监控警告
 *
 * 总结：
 *      用到了类的组合方式将每个api的通知规则，以及通知的级别内容定义为单独的类 然后用一个统一的类进行功能的封装完成具体业务。
 *      如果添加一个功能，每秒钟接口超时请求个数，超过某个预先设置的最大阈值时出发告警发送通知，
 *      需要改动(注释部分)：
 *          1.增加timeoupCount（超时接口数量）
 *          2.增加if 判断如果超时数量大于预先设定的值那么告警
 */
public class ApiMonitoring {
    /**
     * 存储告警规则类
     */
    private AlertRule rule;
    /**
     * 告警通知类 传入需要通知级别 和 通知消息  支持邮件、短信、微信、手机等多种通知渠道。
     */
    private Notification notification;

    public ApiMonitoring(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    /**
     *
     * @param api               具体api
     * @param requestCount      请求次数
     * @param errorCount        错误次数
     * @param durationIfSeconds 设定的时间
     *
     *
     * 此方法如果增加一个类型就需要添加参数，并且增加 if 判断。
     */
    public void check(String api,
                      Long requestCount,
                      Long errorCount,
                      Long durationIfSeconds
                     // Long timeOutCount
    ){
        // 计算在传入的时间durationIfSeconds内api请求的次数requestCount
        Long tps = requestCount / durationIfSeconds;
        // 计算自定义的时间段内请求次数炒股某个规则设定的值那么通知报警
        if(tps > rule.getMatchedRule(api).getMaxTps()){
            // 具体通知报警
            notification.notify(NotificationEmergencyLevel.URGENCY,"...服务访问次数超过...次");
        }
        // 通过参数传入的报错次数大于某个api设定的报错次数报警
        if(errorCount > rule.getMatchedRule(api).getMaxErrorCount()){
            notification.notify(NotificationEmergencyLevel.SEVERE,"...服务错误次数超过预定");
        }
//        Long timeOutTps = timeOutCount / durationIfSeconds;
//        if(timeOutCount > rule.getMatchedRule(api).getTimeOupCount()){
//            notification.notify(NotificationEmergencyLevel.URGENCY,"超时接口告警");
//        }
    }
}

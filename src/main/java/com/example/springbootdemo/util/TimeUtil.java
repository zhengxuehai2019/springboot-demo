package com.example.springbootdemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    public static void main(String[] args) throws ParseException {
        String format = "yyyy-MM-dd HH:mm:ss";
        Date startTime = new SimpleDateFormat(format).parse("2021-02-20 08:00:00");
        Date endTime = new SimpleDateFormat(format).parse("2021-02-26 24:00:00");
        Date now = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat(format);
        String format2 = format1.format(now);
        Date nowDate = new SimpleDateFormat(format).parse(format2);
        boolean effectiveDate = isEffectiveDate(nowDate, startTime, endTime);
        System.out.println(effectiveDate);
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}

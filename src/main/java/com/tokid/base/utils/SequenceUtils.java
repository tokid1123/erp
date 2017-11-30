package com.tokid.base.utils;
/*
* @Description:
* @author king
* @date 2017/11/22 15:55
*/

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Joe Xie
 * Date: 2015/12/9
 * Time: 17:39
 */
public final class SequenceUtils {

    private static AtomicInteger counterLong = new AtomicInteger(0);
    private static AtomicInteger counterMinute = new AtomicInteger(0);
    private static AtomicInteger counterSecond = new AtomicInteger(0);

    /**
     * 生成长整型序列id
     */
    public static long getLongUID() {
        if (counterLong.get() > 999) {
            counterLong.set(1);
        }
        long time = System.currentTimeMillis();
        return time * 1000 + counterLong.incrementAndGet();
    }

    public static String getMinuteUID(String head) {
        return getUID(head, counterMinute, "yyyyMMddHHmm");
    }

    public static String getSecondUID(String head) {
        return getUID(head, counterSecond, "yyyyMMddHHmmss");
    }

    private static String getUID(String head, AtomicInteger integer, String pattern){
        if (integer.get() > 999) {
            integer.set(1);
        }
        String day = format(System.currentTimeMillis(), pattern);
        Long minute = Long.parseLong(day)*1000;

        minute = minute + integer.incrementAndGet();
        return (head + minute);
    }

    public static String format(long millis, String pattern) {
        return DateFormatUtils.format(new Date(millis), pattern, null, null);
    }

}


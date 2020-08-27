package com.code.vv.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2020/8/25.
 * com.code.vv.common
 * 字符串-日期转换工具
 * @author Zjianru
 */
public class DateFormat {

    /**
     * 字符串转日期
     * @param dateString 日期字符串
     * @return Date 对象
     */
    public static Date stringToDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(dateString);
            System.out.println("dateString------------->"+dateString);
            System.out.println("date------------->"+date.getTime());
            System.out.println("date------------->"+date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期转字符串
     * @param date 日期对象
     * @return String 日期字符串
     */
    public static String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}

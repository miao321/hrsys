package com.hrsys.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式的处理工具类
 * @author Lofu
 *
 */
public class DateUtil {
	/** 按xxxx-xx-xx字符串格式传入日期，不含时分秒 */
	public static Date stringToDay(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(time);
		} catch (ParseException e) {
			throw new RuntimeException("时间数据保存异常，建议重新插入");
		}
	}
	
	/** 按yyyy-MM-dd HH:mm:ss字符串格式传入日期，包含时分秒 */
	public static Date StringToHMS(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(time);
		} catch (ParseException e) {
			throw new RuntimeException("时间数据保存异常，建议重新插入");
		}
	}
	
	/** 传入当前时间，精确到时分秒 */
	public static Date getNow() {
		return new Date();
	}
}

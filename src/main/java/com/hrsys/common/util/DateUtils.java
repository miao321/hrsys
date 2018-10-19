package com.hrsys.common.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import org.apache.log4j.chainsaw.Main;
//import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

public class DateUtils {
	/**
	 * 获取当前时间
	 * @return 返回短时间格式 yyyy-MM-dd
	 */
	public static Date getNowDateShort()
	{
		 Date date = new Date(); 
		 Date new_date=new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
	     String dateNowStr = sdf.format(date);  
	     
	     try {
			new_date = sdf.parse(dateNowStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	     return new_date;
	}
	
	/**
	 * 获取当前时间
	 * @return 返回字符串格式 yyyy-MM-dd
	 */
	public static String getNowDateShort(Date date)
	{

	
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
	     String dateNowStr = sdf.format(date);  
		
	     return dateNowStr;
	}
	
	/**
	 * 获取当前时间
	 * @return 返回字符串短时间格式yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowDate(Date date)
	{
	
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
	     String dateNowStr = sdf.format(date);  
	
	     return dateNowStr;
	}	
	/**
	 * 获取当前时间
	 * @return 返回短时间格式yyyy-MM-dd HH:mm:ss
	 */
	public static Date getNowDate()
	{
		 Date date = new Date(); 
		 Date new_date=new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
	     String dateNowStr = sdf.format(date);  
	     
	     try {
			new_date = sdf.parse(dateNowStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	     return new_date;
	}
	
	
	/**
	   * 得到当前时间延后或前移几天的时间,delay为前移或后延的天数
	   */
	  public static Date getOneDay(int delay) {
		  Calendar calendar = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。    

			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
			 calendar.add(calendar.DAY_OF_MONTH, delay);
			 Date date = calendar.getTime();
			 Date new_date = new Date();
		     String dateNowStr = sdf.format(date);  
		     
		     try {
				  new_date = sdf.parse(dateNowStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}		
			     return new_date;
	  }
	  
		/**
	   * 得到所输时间延后或前移几天的时间,delay为前移或后延的天数
	   */
	  public static Date getOneDay(Date date,int delay) {
		  Calendar calendar = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。    

			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
			 calendar.setTime(date);
			 calendar.add(calendar.DAY_OF_MONTH, delay);
			 Date dateUpdate=calendar.getTime();
			 Date new_date = new Date();
		     String dateNowStr = sdf.format(dateUpdate);  
		     
		     try {
				  new_date = sdf.parse(dateNowStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}		
			     return new_date;
	  }
	  /**
	   * 获取随机日期
	   * @param beginDate
	   * @param endDate
	   * @return 返回Date对象
	   */
	  public static Date getRandomDay(String beginDate, String endDate) {
		  
		  try {  
	            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");  
	            Date start = format.parse(beginDate);// 构造开始日期  
	            Date end = format.parse(endDate);// 构造结束日期  
	            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。  
	            if (start.getTime() >= end.getTime()) {  
	                return null;  
	            }  
	            long date = random(start.getTime(), end.getTime());  
	            	Date date_temp=new Date(date);
	            	Date date_new=getOneDay(date_temp,0);
	            return date_new;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return null;  
		
	}
	  private static long random(long begin, long end) {  
	        long rtn = begin + (long) (Math.random() * (end - begin));  
	        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
	        if (rtn == begin || rtn == end) {  
	            return random(begin, end);  
	        }  
	        return rtn;  
	    }  
}

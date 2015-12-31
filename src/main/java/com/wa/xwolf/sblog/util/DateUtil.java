package com.wa.xwolf.sblog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author xwolf
 * @Date 2015-04-01 14:54
 *  
 *  日期处理工具类
 */
public class DateUtil {
	
	private final String FMT_DATETIME= "yyyy-MM-dd hh:mm:ss";
	private final String FMT_DATE ="yyyy-MM-dd";
	private static final String FMT_STR_DATE="yyyyMMdd";
	
	/**
	 * 日期转换为字符串
	 * @param date
	 * @return
	 */
	public String getDateTime(Date date){
		SimpleDateFormat format = new SimpleDateFormat(FMT_DATETIME);
		return format.format(date);
	}
	/**
	 * 日期转换为日期时间字符串
	 * @param date
	 * @return
	 */
	public String getDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat(FMT_DATE);
		return format.format(date);
	}
	/**
	 * 字符串格式化为日期时间类型
	 * @param str
	 * @return
	 */
	public Date getDateTimeStr(String str){
		SimpleDateFormat format = new SimpleDateFormat(FMT_DATETIME);
	      Date date = null;
	      try {
			date =format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	      return date ;
	}
	
	/**
	 * 字符串格式化为日期类型
	 * @param str
	 * @return
	 */
	public Date getDateStr(String str){
		SimpleDateFormat format = new SimpleDateFormat(FMT_DATE);
	      Date date = null;
	      try {
			date =format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	      return date ;
	}
	/**
	 * 获取当前时间的字符串
	 * @return
	 */
	public String getNowTime(){
		SimpleDateFormat format = new SimpleDateFormat(FMT_DATETIME);
		return format.format(new Date(System.currentTimeMillis()));
	}
	
	/**
	 * 获取时间字符串命名的目录
	 * @return
	 */
	public  static String getDateContent(){
		return new SimpleDateFormat(FMT_STR_DATE).format(new Date());
	}
   
	public static void main(String[] args) {
		System.out.println(getDateContent());
		
	}
}

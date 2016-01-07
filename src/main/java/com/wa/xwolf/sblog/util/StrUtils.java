package com.wa.xwolf.sblog.util;

public class StrUtils {
	
	/**
	 * 字符串不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str){
		return org.apache.commons.lang.StringUtils.isNotBlank(str);
	}
	
	/**
	 * 字符串为空
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		return org.apache.commons.lang.StringUtils.isBlank(str);
	}
	
	/**
	 * 字符串去空
	 * @param str
	 * @return
	 */
	public static String trim(String str){
		return org.apache.commons.lang.StringUtils.trim(str);
	}
	
	
	public static void main(String[] args) {
		System.out.println(" 34 3  ");
		System.out.println(trim(" 234532"));
	}
	

}

package com.wa.xwolf.sblog.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;

/**
 *通用工具类
 */
public class CommonUtils {
	
	/**
	 * 获取访问的ip地址
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request){
		 String ip = request.getHeader("x-forwarded-for"); 
	     if (ip != null && !ip.isEmpty()) {
	      ip = ip.split(",")[0].trim();
	     }
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	         ip = request.getHeader("PRoxy-Client-IP"); 
	     } 
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	         ip = request.getHeader("WL-Proxy-Client-IP"); 
	     } 
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	         ip = request.getRemoteAddr(); 
	     } 
	     return ip; 
	}
	
/**
 * Blob 转化为 二进制
 */
	
	public static byte[]  blobToByteAry(Blob blob){
		if (blob==null){
			return null;
		}
		BufferedInputStream is = null;
		try {
			is = new BufferedInputStream(blob.getBinaryStream());
			byte[] bytes = new byte[(int) blob.length()];
			int len = bytes.length;
			int offset = 0;
			int read = 0;
	
			while (offset < len && (read = is.read(bytes, offset, len - offset)) >= 0) {
				offset += read;
			}
			return new String(bytes,"utf-8").getBytes();
		} catch (Exception e) {
			return null;
		} finally {
			try {
				is.close();
				is = null;
			} catch (IOException e) {
				return null;
			}
		}
	}

	

}

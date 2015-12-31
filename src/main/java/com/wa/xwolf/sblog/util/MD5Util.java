package com.wa.xwolf.sblog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	public static String  getMD5Encrypt(String str){
		
		try {
			MessageDigest digest =MessageDigest.getInstance("MD5");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
			
			
		
		return str;
	}

}

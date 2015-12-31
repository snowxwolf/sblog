package com.wa.xwolf.sblog.util;

import java.util.UUID;

public class UUIDUtils {
	
	public static String getLowerCase(){
		return UUID.randomUUID().toString().replace("-","").toLowerCase();
	}
	
	public static String getUppperCase(){
		return UUID.randomUUID().toString().replace("-","").toUpperCase();
	}
	
	public static void main(String[] args) {
		
		System.out.println(UUIDUtils.getLowerCase());
	}
	
	

}

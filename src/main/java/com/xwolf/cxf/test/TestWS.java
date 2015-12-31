package com.xwolf.cxf.test;

import javax.xml.ws.Endpoint;

import com.xwolf.cxf.dao.impl.HelloWSImpl;

/**
 * 发布webservice 
 * @author xwolf
 *
 */
public class TestWS {
	
	public static void main(String[] args) {
		
		Endpoint endpoint =Endpoint.publish("http://localhost:8989/Web/service", new HelloWSImpl());
		
		System.out.println("发布成功");
		
	}

}

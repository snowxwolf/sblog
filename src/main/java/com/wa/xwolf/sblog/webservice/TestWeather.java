package com.wa.xwolf.sblog.webservice;

import java.util.Arrays;
import java.util.List;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

/**
 * @author xwolf
 * 调用天气接口实现天气查询
 *
 */
public class TestWeather {
	
	public static void main(String[] args) {
		WeatherWS ws = new WeatherWS();
		WeatherWSSoap soap=ws.getWeatherWSSoap();
		ArrayOfString str=soap.getWeather("苏州",null);
		List<String> list = str.getString();
		String info =null;
	
		for (int i=0;i<list.size();i++){
			info+=list.get(i)+",";
		}
		String[] weather = info.split(",");
		System.out.println(Arrays.toString(weather));
		String[] ary =new String[8];
		ary[0]=weather[1];
		ary[1]=weather[3];
		ary[2]=weather[4];
		ary[3]=weather[5];
		ary[4]=weather[6];
		ary[5]=weather[7];
		ary[6]=weather[8];
		ary[7]=weather[9];
		
		System.out.println(info);
		System.out.println(Arrays.toString(ary));
	}

}

package com.xwolf.cxf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xwolf.cxf.pojo.User;
import com.xwolf.cxf.pojo.UserMap;
import com.xwolf.cxf.pojo.UserMap.EntryMap;
/**
 * 数据构造 模拟数据库
 * @author Administrator
 *
 */
public class UserService {
	
	/**
	 * List类型数据
	 * @return
	 */
	public static List<User> getUserList(){
		
		List<User> list = new ArrayList<User>();
		list.add(new User(1,"Jhon", 234.32));
		list.add(new User(10,"纳兰性德",432.32));
		list.add(new User(32, "Rollia",8543.32));
		list.add(new User(54, "Yellow", 690.32));
		
		return list ;
	}
	
	/**
	 * 封装Map数据
	 * @return
	 */
	public static Map<String, User> getUserMap(){
		
		Map<String, User> map = new HashMap<String, User>();
		
		map.put("1", new User(1, "测试", 232.432));
		map.put("21", new User(12,"黑狗身上白",4324D));
		map.put("23", new User(13,"白狗身上肿",(double) 432443f));
		map.put("21", new User(14,"上白",5435.54));
		
		return map;
	}

}

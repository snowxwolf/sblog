package com.xwolf.cxf.dao.impl;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.xwolf.cxf.dao.IHelloWS;
import com.xwolf.cxf.pojo.User;
import com.xwolf.cxf.util.MapOfUser;
import com.xwolf.cxf.util.UserService;

@WebService
public class HelloWSImpl implements IHelloWS {

	@Override
	public String getName(String name) {
		return "Hello,CXF: getName():"+ name+",你好 ！";
	}

	@Override
	public User getUser() {
		
		User user =new User(21, "彭天吧", 6453.43);
		return user;
	}

	@Override
	public List<User> getUserList() {
		return UserService.getUserList();
	}
    
	/**
	 * 加上XmlJavaTypeAdapter注解，用封装的类处理
	 */
	@Override
	@XmlJavaTypeAdapter(value=MapOfUser.class)
	public Map<String, User> getUserMap() {
		
		return UserService.getUserMap();
	}

}

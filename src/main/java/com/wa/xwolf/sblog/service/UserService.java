package com.wa.xwolf.sblog.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wa.xwolf.sblog.bean.User;
import com.wa.xwolf.sblog.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	/**
	 * 注册/添加一个用户
	 * @param user
	 */
	public void addUser(User user){
		userDao.addUser(user);
		System.out.println("userDao():"+user);
	}

	public User getUser(User user){
		return userDao.getUser(user);
	}
    
	public User getUser(Map<String, String> map){
		return userDao.getUser(map);
	}
}

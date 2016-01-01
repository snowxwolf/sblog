package com.wa.xwolf.sblog.dao;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wa.xwolf.sblog.bean.User;

@Repository
public interface UserDao {
	
	public void addUser(User user);
	
	public User getUser(User user);
     
	public User getUser(Map<String, String> map);

}

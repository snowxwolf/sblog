package com.wa.xwolf.sblog.dao;


import java.util.Map;

import com.wa.xwolf.sblog.bean.User;

public interface UserDao {
	
	public void addUser(User user);
	
	public User getUser(User user);
     
	public User getUser(Map<String, String> map);

}

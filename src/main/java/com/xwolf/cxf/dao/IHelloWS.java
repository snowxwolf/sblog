package com.xwolf.cxf.dao;

import java.util.List;
import java.util.Map;
import javax.jws.WebService;

import com.xwolf.cxf.pojo.User;


@WebService
public interface IHelloWS {
	
	public String getName(String name );
	
	public User getUser();
	
	public List<User> getUserList();
	
	public Map<String, User> getUserMap();

}

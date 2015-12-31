package com.xwolf.cxf.util;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.xwolf.cxf.pojo.User;
import com.xwolf.cxf.pojo.UserMap;
import com.xwolf.cxf.pojo.UserMap.EntryMap;

/**
 * map转化为为普通实体类的处理方法
 * 
 * @author xwolf
 * @Date 2015-05-30 10:26AM
 *
 */
public class MapOfUser extends XmlAdapter<UserMap, Map<String, User>> {

	@Override
	public Map<String, User> unmarshal(UserMap v) throws Exception {
		
	           Map<String,User> mapUser = new HashMap<String, User>();
	           for (EntryMap map :v.getEntryMaps()){
	        	   mapUser.put(map.getKey(), map.getValue());
	           }
		return  mapUser;
	}

	@Override
	public UserMap marshal(Map<String, User> v) throws Exception {
		UserMap userMap = new UserMap();
		for(String key: v.keySet()) {
		userMap.getEntryMaps().add(new EntryMap(key,v.get(key)));
		}
		
		return userMap;
	}
	
	

}

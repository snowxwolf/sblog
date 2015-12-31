package com.wa.xwolf.sblog.dao;

import java.util.Map;



public interface ContentDao {
	
	//保存内容
	public void saveContent(Map<String, Object> map);
	//查询内容
	public Map<String, Object> findContents(String id);

}

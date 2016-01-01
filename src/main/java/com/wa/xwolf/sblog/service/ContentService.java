package com.wa.xwolf.sblog.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.xwolf.sblog.dao.ContentDao;

@Service
public class ContentService {
	@Autowired
	private ContentDao contentDao;
    
	//保存内容
		public void saveContent(Map<String, Object> map){
			contentDao.saveContent(map);
		}
		//查询内容
		public Map<String, Object> findContents(String id){
			return contentDao.findContents(id);
		}
}

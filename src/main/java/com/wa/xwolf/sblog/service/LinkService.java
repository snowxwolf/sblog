package com.wa.xwolf.sblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.xwolf.sblog.bean.Link;
import com.wa.xwolf.sblog.dao.LinkDao;

@Service
public class LinkService {
	
	@Autowired
	private LinkDao linkDao;
     
public void addLink(Link link){
	linkDao.addLink(link);
}
	
	public void deleteLink(int id){
		linkDao.deleteLink(id);
	}
	
	public Link findById(int id){
	return	linkDao.findById(id);
	}
	
	public List<Link> findLinks(Map<String,Object> map){
		return linkDao.findLinks(map);
	}
	
	public void updateLink(Link link){
		linkDao.updateLink(link);
	}
	
	public int findTotal(Map<String,Object> map){
		return linkDao.findTotal(map);
	}
	
	public List<Link> findAllParentLink(){
		return linkDao.findAllParentLink();
	}
	
	public List<Link> findChildLink(int parentId){
		return linkDao.findChildLink(parentId);
	}

}

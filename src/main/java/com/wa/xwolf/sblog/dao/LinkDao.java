package com.wa.xwolf.sblog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wa.xwolf.sblog.bean.Link;

@Repository
public interface LinkDao {
	
	public void addLink(Link link);
	
	public void deleteLink(int id);
	
	public Link findById(int id);
	
	public List<Link> findLinks(Map<String,Object> map);
	
	public void updateLink(Link link);
	
	public int findTotal(Map<String,Object> map);
	
	public List<Link> findAllParentLink();
	
	public List<Link> findChildLink(int parentId);

}

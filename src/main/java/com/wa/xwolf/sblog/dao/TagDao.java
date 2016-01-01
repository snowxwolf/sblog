package com.wa.xwolf.sblog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wa.xwolf.sblog.bean.Tag;

@Repository
public interface TagDao {
	
	public void saveTag(Map<String,Object> map);
	
	public void deleteTag(int id);
	
	public void updateTag(Map<String,Object> map);
	
	public List<Tag> findTags(Map<String,Object> map);
	
	public int findTotal(Map<String,Object> map);
	
	public Tag findById(int id);
	
	public List<Tag> findTagTree();

}

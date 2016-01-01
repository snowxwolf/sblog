package com.wa.xwolf.sblog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wa.xwolf.sblog.bean.Type;

@Repository
public interface TypeDao {
	
	public void saveType(Type type);
	
	public void deleteType(int id);
	
	 public Type findById(int id);
	 
	 public void updateType (Type type);
	 
	 public List<Type> findTypes(Map<String, Object> map);
	 
	 public int findTotal (Map<String, Object> map);
	 
	 public List<Type> findParentTypes();
	 
	 /**
		 * 查询父菜单id查所有的子菜单
		 * @param parentId
		 * @return
		 */
		public List<Type> findAllSonType(int id);
}

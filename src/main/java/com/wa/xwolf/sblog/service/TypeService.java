package com.wa.xwolf.sblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.xwolf.sblog.bean.Type;
import com.wa.xwolf.sblog.dao.TypeDao;

@Service
public class TypeService {

	@Autowired
	private TypeDao typeDao;

	public void saveType(Type type) {
		typeDao.saveType(type);
	}

	public void deleteType(int id) {
		typeDao.deleteType(id);
	}

	public Type findById(int id) {
		return typeDao.findById(id);
	}

	public void updateType(Type type) {
		typeDao.updateType(type);
	}

	public List<Type> findTypes(Map<String, Object> map) {
		return typeDao.findTypes(map);
	}

	public int findTotal(Map<String, Object> map) {
		return typeDao.findTotal(map);
	}

	public List<Type> findParentTypes() {
		return typeDao.findParentTypes();
	}

	/**
	 * 查询父菜单id查所有的子菜单
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Type> findAllSonType(int id) {
		return typeDao.findAllSonType(id);
	}
	
}

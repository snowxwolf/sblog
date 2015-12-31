package com.wa.xwolf.sblog.dao;

import java.util.List;

import com.wa.xwolf.sblog.bean.Menu;

public interface MenuDao {
	
	public List<Menu> findAllMenus();
	
	public Menu findById(int id);
	
	public void deleteById(int id);
	
	public void addMenu(Menu menu);
	
	public void updateMenu(Menu menu);
	/*
	 * 查询所有的父菜单
	 */
	public List<Menu> findAllParentMenu();
	/**
	 * 查询父菜单id查所有的子菜单
	 * @param parentId
	 * @return
	 */
	public List<Menu> findAllSonMenu(int parentId);

}

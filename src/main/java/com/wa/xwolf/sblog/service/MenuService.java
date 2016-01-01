package com.wa.xwolf.sblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.xwolf.sblog.bean.Menu;
import com.wa.xwolf.sblog.dao.MenuDao;

@Service
public class MenuService {

	@Autowired
	private MenuDao menuDao;

	public List<Menu> findAllMenus() {
		return menuDao.findAllMenus();
	}

	public Menu findById(int id) {
		return menuDao.findById(id);
	}

	public void deleteById(int id) {
		menuDao.deleteById(id);
	}

	public void addMenu(Menu menu) {
		menuDao.addMenu(menu);
	}

	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);
	}

	/*
	 * 查询所有的父菜单
	 */
	public List<Menu> findAllParentMenu() {
		return menuDao.findAllParentMenu();
	}

	/**
	 * 查询父菜单id查所有的子菜单
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Menu> findAllSonMenu(int parentId) {
		return menuDao.findAllSonMenu(parentId);
	}
}

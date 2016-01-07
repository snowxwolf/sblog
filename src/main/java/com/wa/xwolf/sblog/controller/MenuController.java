package com.wa.xwolf.sblog.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wa.xwolf.sblog.bean.Menu;
import com.wa.xwolf.sblog.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	  
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	 private MenuService menuService;
	  
	@RequestMapping("/menuList")
     public String toMenuList(){
    	 return "menu/menu_list";
     }
	@RequestMapping("/findAllMenus")
	public void findAllMenus
	     (HttpServletRequest request,HttpServletResponse response,Writer writer){
		
		List<Menu> parentMenus =menuService.findAllParentMenu();
		JSONObject obj = new JSONObject();
		JSONArray ary= new JSONArray();
		for (int i=0;i<parentMenus.size();i++){
			JSONObject obj1 = new JSONObject();
			Menu parentMenu = parentMenus.get(i);
			obj1.put("id", parentMenu.getId());
			obj1.put("name", parentMenu.getMenuName());
			obj1.put("icon", parentMenu.getIcon());
			obj1.put("url",parentMenu.getUrl());
			List<Menu> sonMenus = menuService.findAllSonMenu(parentMenu.getId());
			JSONArray ary2 = new JSONArray();
			for (int j=0;j<sonMenus.size();j++){
				Menu sonMenu = sonMenus.get(j); 
				
				JSONObject obj2 = new JSONObject();
				obj2.put("id", sonMenu.getId());
				obj2.put("name", sonMenu.getMenuName());
				obj2.put("icon", sonMenu.getIcon());
				obj2.put("url",sonMenu.getUrl());
				ary2.add(obj2);
			}
			obj1.put("sonMenus", ary2);
			ary.add(obj1);
			
		}
		obj.put("menus", ary);
		try {
			writer.write(obj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
			log.error("列出所有菜单项出错,"+e.getMessage());
		}
		
	}
	/**
	 * 菜单列表
	 */
	@RequestMapping("/findAllMenusTree")
	public void findAllMenusTree
	     (HttpServletRequest request,HttpServletResponse response,Writer writer){
		
		List<Menu> parentMenus =menuService.findAllParentMenu();
		JSONObject obj = new JSONObject();
		JSONArray ary= new JSONArray();
		for (int i=0;i<parentMenus.size();i++){
			JSONObject obj1 = new JSONObject();
			Menu parentMenu = parentMenus.get(i);
			obj1.put("id", parentMenu.getId());
			obj1.put("name", parentMenu.getMenuName());
			obj1.put("icon", parentMenu.getIcon());
			obj1.put("url",parentMenu.getUrl());
			obj1.put("createTime", parentMenu.getCreateTime());
			List<Menu> sonMenus = menuService.findAllSonMenu(parentMenu.getId());
			JSONArray ary2 = new JSONArray();
			for (int j=0;j<sonMenus.size();j++){
				Menu sonMenu = sonMenus.get(j); 
				
				JSONObject obj2 = new JSONObject();
				obj2.put("id", sonMenu.getId());
				obj2.put("name", sonMenu.getMenuName());
				obj2.put("icon", sonMenu.getIcon());
				obj2.put("url",sonMenu.getUrl());
				obj2.put("createTime", sonMenu.getCreateTime());
				ary2.add(obj2);
			}
			obj1.put("children", ary2);
			ary.add(obj1);
			
		}
		obj.put("rows", ary);
		try {
			writer.write(obj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
			log.error("列出所有菜单项出错,"+e.getMessage());
		}
		
	}
	/**
	 * 删除菜单项 
	 * @param id 菜单项id
	 * @param writer
	 */
	@RequestMapping("/deleteMenuById")
	public void deleteMenu(@RequestParam("id")int id,Writer writer){
		log.info("删除菜单项,菜单ID为"+id);
		JSONObject object = new JSONObject();
		try {
			menuService.deleteById(id);
			object.put("success",true);
			object.put("msg","菜单项删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除菜单项失败,失败信息为:"+e.getMessage());
			object.put("success",false);
			object.put("msg","菜单项删除失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 到添加菜单页面
	 * @return
	 */
	@RequestMapping("/toAddMenu")
	public String toAdd(){
		return "menu/menu_add";
	}
	/**
	 * 生成上一级菜单
	 * @param writer
	 */
	@RequestMapping("/getParentMenu")
	public void geneParentMenu(Writer writer){
		
		try {
			
			List<Menu> menus = menuService.findAllParentMenu();
			JSONArray ary = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("id",0);
			obj.put("name","默认值");
			ary.add(obj);
			for (int i=0;i<menus.size();i++){
				Menu menu = menus.get(i);
				JSONObject object = new JSONObject();
				object.put("id",menu.getId());
				object.put("name", menu.getMenuName());
				ary.add(object);
			}
			writer.write(ary.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
			log.error("添加菜单项失败,"+e.getMessage());
		}
		
	}
	/**
	 * 添加菜单
	 */
	@RequestMapping("/addMenu")
	public void addMenu(@RequestParam String name,@RequestParam String url,
			@RequestParam String icon,@RequestParam String parentId,Writer writer){
		Menu menu = new Menu();
	//	String parentId = request.getParameter("parentId");
		//String name = request.getParameter("name");
		//String url = request.getParameter("url");
	//	String icon = request.getParameter("icon");
		menu.setCreateTime(new Date());
		menu.setParentMenuId(Integer.parseInt(parentId));
		menu.setMenuName(name);
		menu.setIcon(icon);
		menu.setUrl(url);
		JSONObject object = new JSONObject();
		try {
			log.info("添加的菜单为:{}"+menu);
			menuService.addMenu(menu);
			object.put("success",true);
			object.put("msg","菜单项添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("添加菜单项失败"+e.getMessage());
			object.put("success",false);
			object.put("msg","菜单项添加删除失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 到更新菜单页面
	 * @return
	 */
	@RequestMapping("/updateMenu")
	public ModelAndView updateMenu(@RequestParam("id")String id,Model model,HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		Menu menu = menuService.findById(Integer.parseInt(id));
		model.addAttribute("menu",menu);
		view.setViewName("menu/menu_update");
		return view;
	}
	
	/**
	 * 更新菜单
	 */
	@RequestMapping("/update")
	public void updateMenu(HttpServletRequest request,Writer writer){
		Menu menu = new Menu();
		String id = request.getParameter("id");
		String parentId = request.getParameter("parentId");
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		String icon = request.getParameter("icon");
		menu.setUpdateTime(new Date());
		menu.setParentMenuId(Integer.parseInt(parentId));
		menu.setMenuName(name);
		menu.setIcon(icon);
		menu.setUrl(url);
		menu.setId(Integer.parseInt(id));
		JSONObject object = new JSONObject();
		try {
			menuService.updateMenu(menu);
			object.put("success",true);
			object.put("msg","菜单项更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("更新菜单项失败"+e.getMessage());
			object.put("success",false);
			object.put("msg","菜单项更新失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

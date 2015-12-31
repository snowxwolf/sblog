package com.wa.xwolf.sblog.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wa.xwolf.sblog.bean.Link;
import com.wa.xwolf.sblog.bean.Menu;
import com.wa.xwolf.sblog.dao.LinkDao;
/**
 * 友情链接
 * @author xwolf
 * @date 2015-06-21 13:50
 *
 */
@Controller
@RequestMapping("/link")
public class LinkController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private LinkDao linkDao;
	/**
	 * 到友情链接列表页面
	 * @return
	 */
	@RequestMapping("/toLinkList")
	public String toLinkList(){
		return "link/linkList";
	}
	/**
	 * 获取所有连接
	 * @param request
	 * @param writer
	 */
	@RequestMapping("/linkList")
	public void linkList(HttpServletRequest request,Writer writer){
		List<Link> parentLinks=linkDao.findAllParentLink();
		JSONObject obj = new JSONObject();
		JSONArray ary= new JSONArray();
		for (int i=0;i<parentLinks.size();i++){
			JSONObject obj1 = new JSONObject();
			Link parentLink = parentLinks.get(i);
			obj1.put("descr", parentLink.getDescr());
			obj1.put("name", parentLink.getName());
			obj1.put("url", parentLink.getUrl());
			obj1.put("type", parentLink.getType());
			obj1.put("status", parentLink.getStatus());
			obj1.put("id", parentLink.getId());
			
			List<Link> childLinks = linkDao.findChildLink(parentLink.getId());
			JSONArray ary2 = new JSONArray();
			for (int j=0;j<childLinks.size();j++){
				JSONObject obj2 = new JSONObject();
				Link childLink= childLinks.get(j);
				obj2.put("descr", childLink.getDescr());
				obj2.put("name", childLink.getName());
				obj2.put("url", childLink.getUrl());
				obj2.put("type", childLink.getType());
				obj2.put("status", childLink.getStatus());
				obj2.put("id", childLink.getId());
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
			logger.error("获取链接树形列表失败!"+e.getMessage());
		}
	}
	/**
	 * 到添加link的页面
	 * @return
	 */
	@RequestMapping("/toAddLink")
	public String toAddLink(){
		
		return "link/addLink";
	}
	/**
	 * 添加link
	 * @param request
	 * @param writer
	 */
	@RequestMapping("/addLink")
	public void addLink(HttpServletRequest request,Writer writer){
		Link link = new Link();
		String url = request.getParameter("url");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		String parentId = request.getParameter("parentId");
		String status = request.getParameter("status");
		String type = request.getParameter("type");
		link.setDescr(descr);
		link.setName(name);
		link.setUrl(url);
		link.setStatus(status);
		link.setParentId(Integer.parseInt(parentId));
		link.setType(type);
		JSONObject object = new JSONObject();
		try {
			linkDao.addLink(link);
			object.put("success",true);
			object.put("msg","链接添加成功");
			logger.info(url+", 添加成功 !");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("success",false);
			object.put("msg","链接添加失败");
			logger.error(url+", 添加失败 !");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 删除链接
	 * @param id
	 * @param request
	 * @param writer
	 */
	@RequestMapping("/deleteLink")
	public void deleteLink(@RequestParam("id") String id,HttpServletRequest request,Writer writer){
		
		logger.info("删除菜单项,菜单ID为"+id);
		JSONObject object = new JSONObject();
		try {
			linkDao.deleteLink(Integer.parseInt(id));
			object.put("success",true);
			object.put("msg","链接删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除链接失败,失败信息为:"+e.getMessage());
			object.put("success",false);
			object.put("msg","链接删除失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 到修改页面
	 * @return
	 */
	@RequestMapping("/toUpdateLink")
	public ModelAndView toUpdateLink(@RequestParam("id") String id,Model model){
		ModelAndView view = new ModelAndView();
		Link link = linkDao.findById(Integer.parseInt(id));
		view.setViewName("link/updateLink");
		model.addAttribute("link",link);
		return view;
	}
	/**
	 * 更新link
	 * @param id
	 * @param request
	 * @param writer
	 */
	@RequestMapping("/updateLink")
	public void updateLink(HttpServletRequest request,Writer writer){
		
		Link link = new Link();
		String id = request.getParameter("id");
		String url = request.getParameter("url");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		String parentId = request.getParameter("parentId");
		String status = request.getParameter("status");
		String type = request.getParameter("type");
		link.setDescr(descr);
		link.setName(name);
		link.setUrl(url);
		link.setStatus(status);
		link.setParentId(Integer.parseInt(parentId));
		link.setType(type);
		link.setId(Integer.parseInt(id));
		JSONObject object = new JSONObject();
		try {
			linkDao.updateLink(link);
			object.put("success",true);
			object.put("msg","链接更新成功");
			logger.info(url+", 更新成功 !");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("success",false);
			object.put("msg","链接更新失败");
			logger.error(url+", 更新失败 !");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 获取父项链接
	 */
	@RequestMapping("/getParentLink")
	public void getParentLink(Writer writer){
try {
			
			List<Link> links = linkDao.findAllParentLink();
			JSONArray ary = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("id",0);
			obj.put("name","默认值");
			ary.add(obj);
			for (int i=0;i<links.size();i++){
				Link link = links.get(i);
				JSONObject object = new JSONObject();
				object.put("id",link.getId());
				object.put("name", link.getName());
				ary.add(object);
			}
			writer.write(ary.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("加载父链接失败,"+e.getMessage());
		}
		
		
	}

}

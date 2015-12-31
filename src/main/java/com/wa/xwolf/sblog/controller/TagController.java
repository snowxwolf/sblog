package com.wa.xwolf.sblog.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wa.xwolf.sblog.bean.Tag;
import com.wa.xwolf.sblog.dao.TagDao;

@Controller
@RequestMapping("/tag")
public class TagController {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private TagDao tagDao;
	/**
	 *到 标签列表 
	 * @return
	 */
	@RequestMapping("/toTagList")
	public String toTagList(){
		return "tag/tag_list";
	}
	/**
	 * 标签列表
	 * @return
	 */
	@RequestMapping("/tagList")
	public void tagList(HttpServletRequest request,Writer writer){
		
		try {
			String page = request.getParameter("page");
			String rows =request.getParameter("rows");
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("page", (Integer.parseInt(page)-1)*Integer.parseInt(rows));
			map.put("pageSize", Integer.parseInt(rows));
			List<Tag> list =tagDao.findTags(map);
			int total =tagDao.findTotal(map);
			JSONObject object = new JSONObject();
			object.put("page", page);
			object.put("rows", list);
			object.put("total", total);
			writer.write(object.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
			log.error("标签列表失败,"+e.getMessage());
		}
		
	}
	/**
	 * 详情页
	 * @return
	 */
	@RequestMapping("/toTagDetail")
	public String toDetail (@RequestParam("id")String id,Model model){
		Tag tag = tagDao.findById(Integer.parseInt(id));
		model.addAttribute("tag",tag);
		return "tag/tag_view";
	}
	/**
	 * 到添加标签页面 
	 * @return
	 */
	@RequestMapping("/toAddTag")
	public String toAddTag(){
		return "tag/tag_add";
	}
	/**
	 * 添加标签
	 * @param request
	 * @param writer
	 */
	@RequestMapping("/saveTag")
	public void saveTag(HttpServletRequest request,Writer writer){
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		Map<String,Object> map = new HashMap<String, Object>();
		JSONObject object = new JSONObject();
		map.put("name",name);
		map.put("desc", desc);
		try {
			tagDao.saveTag(map);
			object.put("result",true);
			object.put("msg","标签添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("标签添加失败,"+e.getMessage());
			object.put("result",false);
			object.put("msg","标签添加失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    /**
     * 删除标签
     */
	@RequestMapping("/deleteTag")
	public void deleteTag(@RequestParam("id")String id,Writer writer){
		JSONObject object = new JSONObject();
		try {
			tagDao.deleteTag(Integer.parseInt(id));
			object.put("result",true);
			object.put("msg","标签删除成功");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.error("标签删除失败,"+e.getMessage());
			object.put("result",false);
			object.put("msg","标签添加失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 到更新页面
	 * @return
	 */
	@RequestMapping("/toUpdateTag")
	public String toUpdateTag (@RequestParam("id")String id,Model model){
		Tag tag = tagDao.findById(Integer.parseInt(id));
		model.addAttribute("tag",tag);
		return "tag/tag_update";
	}
	
	/**
	 * 更新标签
	 * @return
	 */
	@RequestMapping("/updateTag")
	public void updateTag (HttpServletRequest request,Writer writer){
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject object = new JSONObject();
		map.put("id",Integer.parseInt(id));
		map.put("name",name);
		map.put("desc",desc);
		try {
			tagDao.updateTag(map);
			object.put("result",true);
			object.put("msg","标签更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("result",false);
			object.put("msg","标签更新失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 获取下拉标签树
	 * @param request
	 * @param response
	 * @param writer
	 */
	@RequestMapping("/findTagTree")
	public void getTagTree(HttpServletRequest request,HttpServletResponse response,Writer writer){
		
		List<Tag> list = tagDao.findTagTree();
		JSONArray ary = new JSONArray();
		for(Tag tag : list){
			JSONObject obj = new JSONObject();
			obj.put("id", tag.getId());
			obj.put("text", tag.getName());
			ary.add(obj);
		}
		
		try {
			writer.write(ary.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

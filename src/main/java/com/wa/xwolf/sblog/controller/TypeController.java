package com.wa.xwolf.sblog.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wa.xwolf.sblog.bean.Type;
import com.wa.xwolf.sblog.service.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private TypeService typeService;
	/**
	 * 到文章类别列表
	 * @return
	 */
	@RequestMapping("/toTypeList")
	public String toTypeList(){
		return "type/type_list";
	}
	/**
	 * 到添加类别页面
	 * @return
	 */
	@RequestMapping("/toAddType")
	public String toAddType(){
		return "type/type_add";
	}
	/**
	 * 类别列表 
	 */
	@RequestMapping("/typeList")
	public void typeList(HttpServletRequest request,Writer writer){
		List<Type> parentTypes =typeService.findParentTypes();
		JSONObject obj = new JSONObject();
		JSONArray ary= new JSONArray();
		for (int i=0;i<parentTypes.size();i++){
			JSONObject obj1 = new JSONObject();
			Type parentType = parentTypes.get(i);
			obj1.put("id", parentType.getId());
			obj1.put("name", parentType.getName());
			obj1.put("descr", parentType.getDescr());
			obj1.put("parentId",parentType.getParentId());
			List<Type> sonTypes =typeService.findAllSonType(parentType.getId());
			JSONArray ary2 = new JSONArray();
			for (int j=0;j<sonTypes.size();j++){
				Type sonType = sonTypes.get(j); 
				
				JSONObject obj2 = new JSONObject();
				obj2.put("id", sonType.getId());
				obj2.put("name", sonType.getName());
				obj2.put("descr", sonType.getDescr());
				obj2.put("parentId",sonType.getParentId());
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
			log.error("列出所有文章分类出错,"+e.getMessage());
		}

	}
	/**
	 * 获取上一级菜单列表
	 */
	@RequestMapping("/getParentType")
	public void getParentType(HttpServletRequest request,Writer writer){
		List<Type> parentTypes =typeService.findParentTypes();
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		obj.put("id",0);
		obj.put("name","默认值");
		ary.add(obj);
		for (int i=0;i<parentTypes.size();i++){
			Type type = parentTypes.get(i);
			
			JSONObject object = new JSONObject();
			object.put("id",type.getId());
			object.put("name", type.getName());
			ary.add(object);
		}
		try {
			writer.write(ary.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
			log.error("获取上级菜单列表失败,"+e.getMessage());
		}
	}
  /**
   * 添加类别
   * @param request
   * @param writer
   */
	@RequestMapping("/addType")
	public void addType(HttpServletRequest request,Writer writer){
		String parentId = request.getParameter("parentId");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		Type type = new Type();
		type.setDescr(descr);
		type.setName(name);
		type.setParentId(Integer.parseInt(parentId));
		JSONObject object = new JSONObject();
		try {
			typeService.saveType(type);
			object.put("result",true);
			object.put("msg","文章类别添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("添加文章类别失败."+e.getMessage());
			object.put("result",false);
			object.put("msg","文章类别添加失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 删除分类
	 */
	@RequestMapping("/deleteType")
	public void deleteType(HttpServletRequest request,Writer writer){
		String id = request.getParameter("id");
		JSONObject object = new JSONObject();
		try {
			typeService.deleteType(Integer.parseInt(id));
			object.put("result",true);
			object.put("msg","文章类别删除成功");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.error("删除文章类别失败."+e.getMessage());
			object.put("result",false);
			object.put("msg","文章类别删除失败");
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
	 */
	@RequestMapping("/toUpdateType")
	public ModelAndView toUpdateType(@RequestParam("id")String id,Model model){
		ModelAndView view = new ModelAndView();
		Type type = typeService.findById(Integer.parseInt(id));
		model.addAttribute("type",type);
		view.setViewName("type/type_update");
		return view;
	}
	/**
	 * 更新文章类别
	 */
	@RequestMapping("/updateType")
	public void updateType(HttpServletRequest request,Writer writer){
		
		String parentId = request.getParameter("parentId");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		String id = request.getParameter("id");
		Type type = new Type();
		type.setDescr(descr);
		type.setName(name);
		type.setParentId(Integer.parseInt(parentId));
		type.setId(Integer.parseInt(id));
		JSONObject object = new JSONObject();
		try {
			typeService.updateType(type);
			object.put("result",true);
			object.put("msg","文章类别更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("更新文章类别失败."+e.getMessage());
			object.put("result",false);
			object.put("msg","文章类别更新失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

package com.wa.xwolf.sblog.controller;


import java.io.IOException;
import java.io.Writer;
import java.sql.Blob;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.wa.xwolf.sblog.bean.Diary;
import com.wa.xwolf.sblog.dao.DiaryDao;

/**
 * @author xwolf
 * @version 1.0
 *  
 *  2015-01-15 10:06
 *  
 *  my 24th birthday
 *
 */
@Controller
@RequestMapping("/diary")
public class DiaryController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private DiaryDao diaryDao;
	/**
	 * 到日记列表页面
	 * @return
	 */
	@RequestMapping("/toDiaryList")
	public String toDiary(){
		return "diary/diary_list";
	}
	/**
	 * 添加日记
	 */
	@RequestMapping("/saveDiary")
	public void saveDiary(HttpServletRequest request,Writer writer){
		String title = request.getParameter("title");
		String weather = request.getParameter("weather");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		JSONObject object = new JSONObject();
	try {
		Blob blob =new SerialBlob(content.getBytes());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title",title);
		map.put("status",0);//0:正常态,1:已删除
		map.put("author",author);
		map.put("time", new Date());
		map.put("weather", weather);
		map.put("content", blob);
		diaryDao.saveDiary(map);
		object.put("result",true);
		object.put("msg","日记添加成功");
	} catch (Exception e) {
		e.printStackTrace();
		object.put("result",false);
		object.put("msg","日记添加失败");
	} finally{
		try {
			writer.write(object.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 }
	/**
	 * 逻辑删除
	 */
	@RequestMapping("/updateStatus")
	public void updateStatus(@RequestParam("id")String id,HttpServletRequest request,Writer writer){
		
		JSONObject object = new JSONObject();
		try {
			diaryDao.deleteDiary(Integer.parseInt(id));
			log.info("逻辑删除日记成功");
			object.put("result",true);
			object.put("msg","日记删除成功");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.error("逻辑删除日记失败,"+e.getMessage());
			object.put("result",false);
			object.put("msg","日记删除失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 彻底删除
	 */
	@RequestMapping("/deleteById")
	public void deleteDiary(@RequestParam("id")String id,HttpServletRequest request,Writer writer){
		
		JSONObject object = new JSONObject();
		try {
			diaryDao.deleteDiarys(Integer.parseInt(id));
			log.info("彻底删除日记成功");
			object.put("result",true);
			object.put("msg","彻底日记删除成功");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.error("彻底删除日记失败,"+e.getMessage());
			object.put("result",false);
			object.put("msg","彻底日记删除失败");
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 查看详情
	 * @return
	 */
	@RequestMapping("/toView")
	public String toView(@RequestParam("id")String id,Model model){
		Map<String, Object > map= diaryDao.findById(Integer.parseInt(id));
		String content = new String((byte[])map.get("content"));
		model.addAttribute("title", map.get("title"));
		model.addAttribute("weather", map.get("weather"));
		model.addAttribute("time", map.get("time"));
		model.addAttribute("author", map.get("author"));
		model.addAttribute("content",content);
		return "diary/diary_view";
	}
	
	/**
	 * 到编辑页面
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public String toEditor(@RequestParam("id")String id,Model model){
		Map<String, Object > map= diaryDao.findById(Integer.parseInt(id));
		String content = new String((byte[])map.get("content"));
		model.addAttribute("id", map.get("id"));
		model.addAttribute("title", map.get("title"));
		model.addAttribute("weather", map.get("weather"));
		model.addAttribute("time", map.get("time"));
		model.addAttribute("author", map.get("author"));
		model.addAttribute("content",content);
		return "diary/diary_update";
	}
	/**
	 * 日记列表
	 * @param writer
	 */
	@RequestMapping("/listDiarys")
	public void ListDiarys(HttpServletRequest request,Writer writer){
		//TODO 部分查询条件待完善 
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		String title =request.getParameter("title");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title","%"+title+"%");
		map.put("page", (Integer.parseInt(page)-1)*Integer.parseInt(rows));
		map.put("pageSize", Integer.parseInt(rows));
		int total = diaryDao.findTotal(map);
		List<Diary> list = diaryDao.finDiaries(map);
		JSONObject object = new JSONObject();
		object.put("rows",list);
		object.put("total",total);
		try {
			writer.write(object.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 到添加日记页面
	 */
	
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "diary/diary_add";
	}
	
	/**
	 * 更新日记
	 */
	@RequestMapping("/updateDiary")
	public void updateDiary(HttpServletRequest request,Writer writer){
		String title = request.getParameter("title");
		String weather = request.getParameter("weather");
		String author = request.getParameter("author");
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		JSONObject object = new JSONObject();
	try {
		Blob blob =new SerialBlob(content.getBytes());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title",title);
		map.put("status",0);//0:正常态,1:已删除
		map.put("author",author);
		map.put("time", new Date());
		map.put("weather", weather);
		map.put("content", blob);
		map.put("id", Integer.parseInt(id));
		diaryDao.updateDiary(map);
		object.put("result",true);
		object.put("msg","日记添加成功");
	} catch (Exception e) {
		e.printStackTrace();
		object.put("result",false);
		object.put("msg","日记添加失败");
	} finally{
		try {
			writer.write(object.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 }

}

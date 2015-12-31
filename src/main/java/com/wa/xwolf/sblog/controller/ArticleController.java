package com.wa.xwolf.sblog.controller;

import java.io.IOException;
import java.io.Writer;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;








import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.wa.xwolf.sblog.bean.Article;
import com.wa.xwolf.sblog.dao.ArticleDao;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ArticleDao articleDao;
	/**
	 * 文章列表页面
	 * @return
	 */
	@RequestMapping("/articleList")
	public String toArticle(){
		return "article/article_list";
	}
	/**
	 * 至添加文章页面
	 * @return
	 */
	@RequestMapping("/toAddArticle")
	public String toAddArticle(){
		return "article/article_add";
	}
	/**
	 * 添加文章
	 * @param request
	 * @param writer
	 * @throws SQLException 
	 * @throws SerialException 
	 */
	@RequestMapping("/addArticle")
	public void addArticle(HttpServletRequest request,Writer writer){
		String title =request.getParameter("title");
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		String url =request.getParameter("url");
		
		String tag =request.getParameter("tag");
		String type =request.getParameter("type");
		Blob blob =null;
		JSONObject object = new JSONObject();
		try {
			blob = new SerialBlob(content.getBytes());
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("title",title);
			map.put("tag", tag);
			map.put("content",blob);
			map.put("publishTime", new Date());
			map.put("author",author);
			map.put("url", url);
			map.put("type",type);
			map.put("status","0");
	        articleDao.addArticle(map);
	        object.put("result", true);
	        object.put("msg","添加新文章成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("添加文章失败,"+e.getMessage());
			  object.put("result",false);
		        object.put("msg","添加新文章失败");
		} finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 *条件查询文章 
	 */
	@RequestMapping("/findArticles")
	public void findArticles(HttpServletRequest request,Writer writer){
		
		String title = request.getParameter("title");
		String start =request.getParameter("start");
		String end =request.getParameter("end");
		String type =request.getParameter("type");
		String pages= request.getParameter("page");
		String rows =request.getParameter("rows");
		int page =1;
		int pageSize=10;
		if (pages!=null && pages.trim().length()>0){
			page=Integer.parseInt(pages);
		}
		if (rows!=null && rows.trim().length()>0){
			pageSize=Integer.parseInt(rows);
		}
		
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("title","%"+title+"%");
		map.put("type", type);
		map.put("start", start);
		map.put("end",end);
		map.put("page",page-1);
		map.put("pageSize",pageSize);
		System.out.println("当前页面：========"+page);
		try {
			List<Article> list = articleDao.findArticles(map);
			int total = articleDao.findTotal(map);
			JSONObject object = new JSONObject();
			object.put("page", page);
			object.put("rows",list);
			object.put("total", total);
			writer.write(object.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("文章列表失败,"+e.getMessage());
		}
	}
  /**
   * 根据id获取内容
   * @param request
   * @param writer
   * @param model
   * @return
   */
	@RequestMapping("/getContentById")
	public ModelAndView getContentById(HttpServletRequest request,Writer writer,Model model){
		String id = request.getParameter("id");
		ModelAndView view = new ModelAndView();
		Map<String,Object> map = articleDao.getContentById(Integer.parseInt(id));
		String content = new String((byte[])map.get("content"));
		model.addAttribute("content",content);
		model.addAttribute("author",map.get("author"));
		model.addAttribute("title",map.get("title"));
		model.addAttribute("url",map.get("url"));
		model.addAttribute("publishDate",map.get("publish_time"));
		view.setViewName("article/article_view");
		return view;
	}
	
	/**
	   * 根据id获取内容
	   * @param request
	   * @param writer
	   * @param model
	   * @return
	   */
		@RequestMapping("/toUpdate")
		public ModelAndView toupdate(HttpServletRequest request,Writer writer,Model model){
			String id = request.getParameter("id");
			ModelAndView view = new ModelAndView();
			Map<String,Object> map = articleDao.getContentById(Integer.parseInt(id));
			String content = new String((byte[])map.get("content"));
			model.addAttribute("id",map.get("id"));
			model.addAttribute("content",content);
			model.addAttribute("author",map.get("author"));
			model.addAttribute("title",map.get("title"));
			model.addAttribute("url",map.get("url"));
			model.addAttribute("type",map.get("type"));
			model.addAttribute("tag",map.get("tag"));
			view.setViewName("article/article_update");
			return view;
		}
		
		/**
		 * 更新文章
		 * @param request
		 * @param writer
		 * @throws SQLException 
		 * @throws SerialException 
		 */
		@RequestMapping("/updateArticle")
		public void updateArticle(HttpServletRequest request,Writer writer){
			String title =request.getParameter("title");
			String content = request.getParameter("content");
			String author = request.getParameter("author");
			String url =request.getParameter("url");
			String id = request.getParameter("id");
			String tag =request.getParameter("tag");
			String type =request.getParameter("type");
			Blob blob =null;
			JSONObject object = new JSONObject();
			try {
				blob = new SerialBlob(content.getBytes());
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("title",title);
				map.put("tag", tag);
				map.put("content",blob);
				map.put("author",author);
				map.put("url", url);
				map.put("type",type);
				map.put("status","0");
				map.put("id",Integer.parseInt(id));
		        articleDao.updateArticle(map);
		        object.put("result", true);
		        object.put("msg","更新文章成功");
			} catch (Exception e) {
				e.printStackTrace();
				log.error("更新文章失败,"+e.getMessage());
				  object.put("result",false);
			        object.put("msg","更新新文章失败");
			} finally{
				try {
					writer.write(object.toJSONString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
}

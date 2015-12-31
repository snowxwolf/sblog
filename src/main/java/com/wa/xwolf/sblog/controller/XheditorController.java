 package com.wa.xwolf.sblog.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;





import com.alibaba.fastjson.JSONObject;
import com.wa.xwolf.sblog.dao.ContentDao;
import com.wa.xwolf.sblog.util.UUIDUtils;

/**
 * 整合xheditor测试案例
 *
 */
@Controller
public class XheditorController {
	
	private Logger log = Logger.getLogger(XheditorController.class);
	@Autowired
	  ContentDao contentDao;
	
	@RequestMapping("/xheditor")
	public String toBlog(){
		return "editor/xheditor";
	}
	/**
	 * xheditor上传图片
	 * @param request
	 * @param response
	 * @param writer
	 */
	@RequestMapping("/upload")
	public void uploadImage(@RequestParam("filedata") MultipartFile file,HttpServletRequest request,HttpServletResponse response,
			Writer writer){
		//String fileName = file.getOriginalFilename();
		
	}
	/**
	 * 保存内容
	 * @param request
	 * @param response
	 * @param writer
	 */
	@RequestMapping("/saveContent")
	public void save(HttpServletRequest request,HttpServletResponse response,Writer writer) {
		String title = request.getParameter("title");
		String org = request.getParameter("org");
		String content = request.getParameter("content");
		java.sql.Blob blob=null;
		JSONObject object = new JSONObject();
		try {
			blob = new SerialBlob(content.getBytes());
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id",UUIDUtils.getLowerCase());
			map.put("title",title);
			map.put("org", org);
			map.put("content",blob);
			map.put("publishDate", new Date());
			contentDao.saveContent(map);
			object.put("result", true);
			object.put("msg","保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(new Date()+"内容保存失败,error Message ="+e.getMessage());
			object.put("result", false);
			object.put("msg","保存失败");
		} finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 列出内容信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/listContent")
	public ModelAndView toList
         (HttpServletRequest request,HttpServletResponse response,Model model){
		ModelAndView view = new ModelAndView();
		Map<String, Object > map = contentDao.findContents("0cfe4a5b991743fea7e18df94c871d48");
		//以byte[] 方式取出blog类型的数据 
		String list = new String((byte[])map.get("content"));
		model.addAttribute("content",list);
		return view;
	}

}

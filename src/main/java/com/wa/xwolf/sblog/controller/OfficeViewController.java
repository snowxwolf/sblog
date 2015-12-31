package com.wa.xwolf.sblog.controller;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.wa.xwolf.sblog.bean.Uploader;
import com.wa.xwolf.sblog.bean.User;
import com.wa.xwolf.sblog.util.DateUtil;
import com.wa.xwolf.sblog.util.OfficeConventer;

/**
 * 附件管理
 * 仿照百度文库等在线预览的实现
 * 
 * @Date 2015-06-18 20:23:56
 * @author xwolf
 * @version 1.0
 * 
*/
@Controller
@RequestMapping("/office")
public class OfficeViewController {
	
	private Logger logger =Logger.getLogger(OfficeViewController.class);
   /**
    * 到预览页面
    * @param request
    * @param response
    * @param writer
    */
	@RequestMapping("/view")
	public String toView(){
		
		return "office/onlineView";
	}
	/**
	 * 将文件上传并转化为 SWF格式
	 * @param request
	 * @param response
	 * @param writer
	 */
	@RequestMapping("/upload")
	public void uploadFile(HttpServletRequest request,HttpServletResponse response,Writer writer){
		MultipartHttpServletRequest multRequest = (MultipartHttpServletRequest) request;
	    
	  MultipartFile file = multRequest.getFile("file");
	  User user = (User) request.getSession().getAttribute("user");
          // 文件名称 
	    String fileName = file.getOriginalFilename();
	    //文件大小
	    String fileSize =Long.toString(file.getSize());
	    String path = request.getServletContext().getContextPath();
	  
	    //文件上传路径 
	    String filePath = path+File.separator+"upload"+File.separator+DateUtil.getDateContent();
	   File uploadFile = new File(filePath+File.separator+fileName);
	   
	   OfficeConventer conventer = new OfficeConventer(fileName);
	   //执行转换
	   conventer.conver();
	   Uploader uploader = new Uploader();
	   uploader.setFileName(fileName);
	   uploader.setUploadTime(new Date());
	   uploader.setUserId(user.getId());
	   uploader.setRemark("上传文件大小为:"+Long.parseLong(fileSize)/1024/1024+" M.");
	   uploader.setFilePath(filePath+File.separator+fileName);
	  if (!uploadFile.getParentFile().exists()){
		  uploadFile.getParentFile().mkdirs();
	  }
	  JSONObject object = new JSONObject();
	  // 上传文件到指定的目录
	  try {
		FileCopyUtils.copy(file.getBytes(), uploadFile);
		object.put("result", true);
		object.put("msg", "文件上传成功!");
	} catch (Exception e) {
		e.printStackTrace();
		logger.error("文件上传失败:" + e.getMessage());
		object.put("result", true);
		object.put("msg", "文件上传成功!");
	}finally{
		
		try {
			writer.write(object.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  
	}
	

}

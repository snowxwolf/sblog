package com.wa.xwolf.sblog.controller;


import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author xwolf
 *
 *  @version 1.0
 *  
 *  2015-01-11 19:31
 */
@Controller
public class UEditorController {
	
	@RequestMapping("/ueditor")
	public ModelAndView toUe(){
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("editor/ueditor");
		//View view = new FreeMarkerView();
		return modelview;
	}
	/**
	 * ueditor上传图片
	 */
	@RequestMapping("/uploadImage")
	public void uploadImage
	 (HttpServletRequest request,HttpServletResponse response,Writer writer){
		
	}

}

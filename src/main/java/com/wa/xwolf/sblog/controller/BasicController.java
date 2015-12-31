package com.wa.xwolf.sblog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;



/**
 * 
 * @author xwolf
 * @Date 2015-04-01 10:10
 *  
 *  异常控制器
 */
public class BasicController  {
	
	@InitBinder
	public void Resolver(){
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView exception500(){
		ModelAndView view = new ModelAndView();
		view.setViewName("exception/500");
		return view;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ModelAndView exception404(){
		ModelAndView view = new ModelAndView();
		view.setViewName("exception/404");
		return view;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public ModelAndView exception403(){
		ModelAndView view = new ModelAndView();
		view.setViewName("exception/403");
		return view;
	}

	
}

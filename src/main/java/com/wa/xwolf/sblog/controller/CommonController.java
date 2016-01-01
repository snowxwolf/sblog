package com.wa.xwolf.sblog.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.wa.xwolf.sblog.bean.User;
import com.wa.xwolf.sblog.service.UserService;
import com.wa.xwolf.sblog.util.CommonUtils;
import com.wa.xwolf.sblog.util.DESUtil;
import com.wa.xwolf.sblog.util.UUIDUtils;

/**
 * 登录,注册,首页
 * @author Administrator
 *
 */
@Controller
public class CommonController {
	
	@Autowired
	private UserService userService;
	
	private Logger log = Logger.getLogger(CommonController.class);
	/**
	 * 至注册页面 
	 * @return
	 */
	@RequestMapping("/toReg")
	public String toreg(){
		return "common/reg";
	}
	/**
	 * 用户注册
	 * @param request
	 * @param writer
	 * @Date  2015-06-13 10:18
	 */
	@RequestMapping("/reg")
	public void reg(HttpServletRequest request,Writer writer){
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		
		User user = new User();
		user.setId(UUIDUtils.getLowerCase());
		user.setUsername(name);
		user.setPwd(DESUtil.getEncryptString(password));
		user.setRegip(CommonUtils.getIp(request));
		user.setRegtime(new Date());
		JSONObject object = new JSONObject() ;
		
		try {
			userService.addUser(user);
			object.put("success",true);
			log.info(name+"在"+new Date()+"注册成功！");
		} catch (Exception e) {
			log.info("用户注册失败:"+e.getMessage());
			e.printStackTrace();
			object.put("success",false);
		}finally{
			try {
				writer.write(object.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
     
	/**
	 * 到首页
	 * @return
	 */
	@RequestMapping("/index")
	public String toIndex(){
		
	  return "common/index";	
	}
	/**
	 * 到登录页面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "common/login";
	}
	/**
	 * 登录
	 * @param request
	 * @param writer
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request,Writer writer){
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("pwd", DESUtil.getEncryptString(password));
		User user = userService.getUser(map);
		JSONObject object = new JSONObject() ;
		log.info("登录的用户:"+user);
		if(user==null){
			object.put("success",false);
		}else{
			log.info(name+"在"+new Date()+"登录系统");
			request.getSession().setAttribute("user", user);
			object.put("success",true);
		}
		
		try {
			writer.write(object.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 用户注销
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		session.removeAttribute("user");
		
		try {
			
			response.sendRedirect(request.getContextPath()+"/toLogin.htm");
			log.info(user.getUsername()+"在"+new Date()+"退出系统!");
		} catch (IOException e) {
			e.printStackTrace();
			log.info(user.getUsername()+"在"+new Date()+"退出系统失败,"+e.getMessage());
		}
		
	}
}

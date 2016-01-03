package com.wa.xwolf.sblog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wa.xwolf.sblog.bean.User;

/**
 * 
 * @author xwolf
 * 登录过滤器
 * 2015-01-16 09:00
 *
 */
public class LoginFilter implements Filter {
  
	private Logger logger =Logger.getLogger(LoginFilter.class);
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
           HttpServletRequest request=(HttpServletRequest) arg0;
           HttpServletResponse response =(HttpServletResponse) arg1;
           HttpSession session = request.getSession();
           
          User user = (User) session.getAttribute("user");
          String url = request.getRequestURL().toString();
          logger.info("请求的url为:{}"+url);
          boolean isPass = false;
          if (url.endsWith(".gif")||url.endsWith(".css")||url.endsWith(".jpg")||
        		  url.endsWith(".js")|| url.endsWith(".bmp")||url.endsWith(".png")){
        	  isPass=true;
          }
          if(user!=null){
        	  isPass=true;
          }
          //登陆，注册页面跳过
          if(url.endsWith("toLogin.htm")|| url.endsWith("toReg.htm")){
        	  isPass=true;
          }
     
        if(!isPass){
        	response.sendRedirect(request.getContextPath()+"/toLogin.htm");
        	logger.info("用户未登陆,不能访问,为其跳转到登陆页面");
        
        }
      
        arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	

}

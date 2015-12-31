package com.wa.xwolf.sblog.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;


public class PrivilegeMenu extends TagSupport {
	
	private static final long serialVersionUID = 2002595771175869033L;
	private String id ;
	private String name ;
	private String url ;//对应的链接
	private String key ;
	private String css;
	
	private String click ;
	private String target;
   
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@Override
	public int doStartTag() throws JspException {
		
		JspWriter jspWriter  =pageContext.getOut();
		
		try {
			jspWriter.print("<a ");
			if (StringUtils.isNotBlank(id)){
				jspWriter.write("id="+id);
			}
			if (StringUtils.isNotBlank(name)){
				jspWriter.write(" name = \""+name+"\"");
			}
			@SuppressWarnings("unchecked")
			List<String> privileges = (List<String>) pageContext.getSession().getAttribute("privileges");
			if(!privileges.contains(key)){
				jspWriter.write(" href = javascript:alert('您没有访问权限');");
			}else {
				
				if (StringUtils.isNotBlank(url)){
					jspWriter.write(" href = \""+url+"\"");
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				jspWriter.print(" >");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter jspWriter = pageContext.getOut();
		try {
			jspWriter.write("</a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}

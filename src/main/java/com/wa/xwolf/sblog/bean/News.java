package com.wa.xwolf.sblog.bean;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 新闻实体类
 * @author xwolf
 * 2015-01-12 19:30
 *
 */
public class News implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id ;
	
	private String title ;
	
	private String org ;//来源
	
	private String url ;//指定链接
	
	private String status ;//状态
	
	private Date time ;//发布时间 
	
	private Blob text ;//内容
	
  
	public News(){
		super();
	}
	
	
	public News(Integer id, String title, String org, String url,
			String status, Date time, Blob text) {
		super();
		this.id = id;
		this.title = title;
		this.org = org;
		this.url = url;
		this.status = status;
		this.time = time;
		this.text = text;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getOrg() {
		return org;
	}


	public void setOrg(String org) {
		this.org = org;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public Blob getText() {
		return text;
	}


	public void setText(Blob text) {
		this.text = text;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	 

}

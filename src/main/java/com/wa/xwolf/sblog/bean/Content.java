package com.wa.xwolf.sblog.bean;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;



public class Content implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id ;
	private String org ;//来源
	private String title ;//标题
	public Blob content;//内容
	private Date publishDate;//发布时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Blob getContent() {
		return content;
	}
	public void setContent(Blob content) {
		this.content = content;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	
	
	

}

package com.wa.xwolf.sblog.bean;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 文章实体类
 * @author xwolf
 *@version 1.0
 * 2015-01-12 09:59
 */
public class Article implements Serializable {
	
	private static final long serialVersionUID = -1648219815244978520L;

	private Integer id ;
	
	private String title ;
	
	private String author;
	
	private String url ;//来源链接
	
	private String type ;//文章类型
	
	private Date publishTime ;//发布时间
	
	private String status ;//文章状态: 0:待发布,1:已发布,2:已删除
	
	private Blob content;
	
	private String miniType ;//类型下的小分值
	
	private String tag ;
	
	

	public Article() {
		super();
	}
	
	

	public Article(Integer id, String title, String author, String url,
			String type, Date publishTime, String status,
			Blob content, String miniType, String tag) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.url = url;
		this.type = type;
		this.publishTime = publishTime;
		this.status = status;
		this.content = content;
		this.miniType = miniType;
		this.tag = tag;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public String getMiniType() {
		return miniType;
	}

	public void setMiniType(String miniType) {
		this.miniType = miniType;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

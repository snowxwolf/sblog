package com.wa.xwolf.sblog.bean;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 日记类
 * @author xwolf
 *  @version 1.0
 *  2015-01-12 10:50
 *
 */
public class Diary implements Serializable {


	private static final long serialVersionUID = 1L;
	
	 private Integer id ;
	 
	 private String title ;
	 
	 private String author;
	 
	 private Blob content ;
	 
	 private Date time ;
	 
	 private String weather;//天气情况
	 
	 private String status ;
	 
	 public Diary(){
		 super();
	 }
	 

	public Diary(Integer id, String title, String author, Blob content,
			Date time, String weather,String status) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.time = time;
		this.weather = weather;
		this.status=status;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

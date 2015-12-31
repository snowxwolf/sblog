package com.wa.xwolf.sblog.bean;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author xwolf
 * 2015-01-12 19:57
 *  日志类
 */
public class Log  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id ;
	private String username ;
	private String type ;//日志类型
	private String url ;
	private String desc ;
	private Date visitime;
	private String ip ;
	
	public Log(){
		super();
	}

	public Log(Integer id, String username, String type, String url,
			String desc, Date visitime, String ip) {
		super();
		this.id = id;
		this.username = username;
		this.type = type;
		this.url = url;
		this.desc = desc;
		this.visitime = visitime;
		this.ip = ip;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getVisitime() {
		return visitime;
	}

	public void setVisitime(Date visitime) {
		this.visitime = visitime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

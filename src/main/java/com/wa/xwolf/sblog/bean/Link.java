package com.wa.xwolf.sblog.bean;

import java.io.Serializable;

/**
 * 友情链接实体类
 * @author xwolf
 * @Date 2015-01-12 18:47
 *
 */
public class Link implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name ;
	private Integer parentId;
	private String url ;
	private String type ;//友情链接的类别
	private String descr ;//描述
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Link [id=" + id + ", name=" + name + ", parentId=" + parentId
				+ ", url=" + url + ", type=" + type + ", descr=" + descr
				+ ", status=" + status + "]";
	}
	
	

}

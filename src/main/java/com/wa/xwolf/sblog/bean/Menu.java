package com.wa.xwolf.sblog.bean;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 菜单项
 * @author xwolf
 * @version 1.0
 * 2015-01-09 11:20
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer parentMenuId;//上一级菜单
	private String menuName;//菜单名称
	private String url;//菜单url
	private String icon ;//菜单图标 
	private Date createTime ;
	private String createUserId;
	private String updateUserId;
	private Date updateTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this);
	}

}

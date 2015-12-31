package com.wa.xwolf.sblog.bean;

import java.io.Serializable;

/**
 *角色 
 * @author xwolf
 * @Date 2015-06-20 16:45:47
 *
 */

public class Role implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1325681111001126264L;
	private Integer id ;
	private String name ;
	private String remark;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
	
	

}

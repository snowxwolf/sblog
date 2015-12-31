package com.wa.xwolf.sblog.bean;

import java.io.Serializable;

/**
 * @author xwolf
 *  文章标签实体类
 *  2015-01-13 11:11
 */
public class Tag implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private Integer id ;
	
	private String name ;
	
	private String desc ;

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}

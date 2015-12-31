package com.wa.xwolf.sblog.bean;

import java.io.Serializable;
/**
 * 文章类别实体类
 * @author xwolf
 *  
 *  2015-01-13 11:36
 */
public class Type implements Serializable {

	private static final long serialVersionUID = 6196653805843093800L;
	
	private Integer id ;
	
	private String name ;
	
	private String descr ;
	
	private Integer parentId;

	public Type(Integer id, String name, String descr, Integer parentId) {
		super();
		this.id = id;
		this.name = name;
		this.descr = descr;
		this.parentId = parentId;
	}

	public Type() {
		super();
	}

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

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	

}

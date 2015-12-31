package com.wa.xwolf.sblog.bean;

import java.io.Serializable;

public class Authority implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9175171763301628974L;
	private Integer id ;
	private String name ;
	private String descr ;
	
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
	

}

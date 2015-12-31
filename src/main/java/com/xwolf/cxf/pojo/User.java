package com.xwolf.cxf.pojo;

/**
 * USER实体类
 * @author Administrator
 *
 */
public class User {
	
	private Integer id ;
	private String name ;
	private Double saraly;
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
	public Double getSaraly() {
		return saraly;
	}
	public void setSaraly(Double saraly) {
		this.saraly = saraly;
	}
	public User() {
		super();
	}
	public User(Integer id, String name, Double saraly) {
		super();
		this.id = id;
		this.name = name;
		this.saraly = saraly;
	}
	
	

}

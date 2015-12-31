package com.wa.xwolf.sblog.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户实体类
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id ;
	private String username;
	private String pwd ;
	private Date regtime;//注册时间
	private String regip;
	private Date lastLoginTime;
	private String remark;
	private String status;
	public User() {
		super();
	}
	
	public User(String id, String username, String pwd,
			Date regtime, String regip, Date lastLoginTime, String remark,String status
			) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.regtime = regtime;
		this.regip = regip;
		this.lastLoginTime = lastLoginTime;
		this.remark = remark;
		this.status=status;
	
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd
				+ ", regtime=" + regtime + ", regip="
				+ regip + ", lastLoginTime=" + lastLoginTime + ", remark="
				+ remark+",status="+status+"]";
	}
	
	
	
	

}

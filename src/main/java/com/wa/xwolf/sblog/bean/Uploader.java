package com.wa.xwolf.sblog.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传实体类
 * @author xwolf
 * @Date 2015-0-17 11:26:42
 *
 */
public class Uploader implements Serializable {
	private static final long serialVersionUID = -6628861397086925193L;
	private Integer id ;
	private String fileName ;
	private String filePath;
	private String userId;
	private Date uploadTime;
	private String remark ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

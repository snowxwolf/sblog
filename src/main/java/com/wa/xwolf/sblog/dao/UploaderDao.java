package com.wa.xwolf.sblog.dao;

import org.springframework.stereotype.Repository;

import com.wa.xwolf.sblog.bean.Uploader;

@Repository
public interface UploaderDao {
	
	//上传文件
	public void upload(Uploader uploader)throws Exception;

}

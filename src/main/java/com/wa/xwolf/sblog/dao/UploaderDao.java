package com.wa.xwolf.sblog.dao;

import com.wa.xwolf.sblog.bean.Uploader;

public interface UploaderDao {
	
	//上传文件
	public void upload(Uploader uploader)throws Exception;

}

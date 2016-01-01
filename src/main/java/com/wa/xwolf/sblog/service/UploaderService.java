package com.wa.xwolf.sblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.xwolf.sblog.bean.Uploader;
import com.wa.xwolf.sblog.dao.UploaderDao;

@Service
public class UploaderService {

	@Autowired
	private UploaderDao uploaderDao;

	// 上传文件
	public void upload(Uploader uploader) throws Exception {
		uploaderDao.upload(uploader);
	}

}

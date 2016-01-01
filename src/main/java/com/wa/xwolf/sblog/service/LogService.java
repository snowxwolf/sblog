package com.wa.xwolf.sblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.xwolf.sblog.bean.Log;
import com.wa.xwolf.sblog.dao.LogDao;

@Service
public class LogService {

	@Autowired
	private LogDao logDao;

	void addLog(Log log) {
		logDao.addLog(log);
	}

	List<Log> findLogs(Map<String, String> map) {
		return logDao.findLogs(map);
	}

}

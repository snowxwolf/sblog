package com.wa.xwolf.sblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.tools.javac.util.List;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;
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

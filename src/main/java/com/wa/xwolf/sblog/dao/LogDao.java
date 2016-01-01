package com.wa.xwolf.sblog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wa.xwolf.sblog.bean.Log;


@Repository
public interface LogDao {
	
	void addLog(Log log);
	
	List<Log> findLogs(Map<String,String> map);

}

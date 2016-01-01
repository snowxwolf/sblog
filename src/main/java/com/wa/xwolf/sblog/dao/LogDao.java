package com.wa.xwolf.sblog.dao;

import org.springframework.stereotype.Repository;

import com.sun.tools.javac.util.List;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;
import com.wa.xwolf.sblog.bean.Log;


@Repository
public interface LogDao {
	
	void addLog(Log log);
	
	List<Log> findLogs(Map<String,String> map);

}

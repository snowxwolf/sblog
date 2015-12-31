package com.wa.xwolf.sblog.quartz.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * @author Administrator
 * 
 *定义要执行的任务job
 */
public class MyJob implements Job {
	
	private Logger logger=Logger.getLogger(this.getClass());

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.warn("quartz job 任务调用....");
		
        System.out.println(new Date()+"job开始执行,"+arg0.getTrigger());
	}

}

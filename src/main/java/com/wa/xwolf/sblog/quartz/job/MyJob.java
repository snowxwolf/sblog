package com.wa.xwolf.sblog.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class MyJob  implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
         //org.quartz.Scheduler scheduler = arg0.getScheduler();
	}

}

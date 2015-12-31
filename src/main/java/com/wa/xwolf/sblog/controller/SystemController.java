package com.wa.xwolf.sblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {
	/**
	 * 服务器信息监控
	 * @return
	 */
	@RequestMapping("/serverInfo")
	public String seeServerInfo(){
		return "system/server_info";
	}

}

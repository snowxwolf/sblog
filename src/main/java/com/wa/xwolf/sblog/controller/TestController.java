package com.wa.xwolf.sblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String toIndex(){
		return "test";
	}

}

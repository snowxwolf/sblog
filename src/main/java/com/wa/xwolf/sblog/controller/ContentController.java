package com.wa.xwolf.sblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/content")
public class ContentController {
	 /**
	  * 到添加内容页面
	  * @return
	  */
	@RequestMapping("/toAddContent")
	public String toAdd(){
		return "content/content_add";
	}

}

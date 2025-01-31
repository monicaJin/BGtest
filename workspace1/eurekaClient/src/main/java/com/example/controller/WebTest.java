package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.config.mysql.*;

//不能用restcontroller, @RestController注解相当于@ResponseBody和@Controller合在一起的作用。在使用@RestController注解Controller时，Controller中的方法无法返回jsp页面，或者html，配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
@Controller
@RequestMapping("/webtest")
public class WebTest {
	
	private static final Logger log = LoggerFactory.getLogger(WebTest.class);

	public WebTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	//@RequestMapping中的路径一定不要和返回的页面名称完全相同，这样会报500的错误！！！！
	//http://192.168.103.175:9001/webtest/dbtestpage
	@RequestMapping("/dbtestpage")
	public String dbwebpage(Model model) {
		//return "redirect:/static/index.html";
		Sys_Order order=new Sys_Order();
		order.setId("idtest");
		order.setClient_document_no("doctest");
		
		//将用户信息保存到Model对象中
        model.addAttribute("order",order);
		
		return "/webtest/dbtest";
	}
	@RequestMapping("/dbtestpage2")
	public String dbwebpage2() {
		//return "redirect:/static/index.html";
		
		return "/webtest/dbtest2";
	}

}

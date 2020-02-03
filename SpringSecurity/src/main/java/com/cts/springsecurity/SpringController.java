package com.cts.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringController {
	
	@RequestMapping("/")
	public String Login()
	{
		return "index";
	}
	
	@RequestMapping("/admin")
	public  String admin()
	{
		return "admin";
	}
	
	@RequestMapping("/user")
	public String user()
	{
		return "user";
	}
  
}

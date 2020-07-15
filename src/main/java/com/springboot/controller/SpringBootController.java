package com.springboot.controller;

import com.springboot.model.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController //@Controller与 @ResponseBody的结合
public class SpringBootController {
	
	@Resource
	private Demo demo;
	
	@RequestMapping("/")
	public String geeting() {
		return "hello," + demo.getName();
	}
}

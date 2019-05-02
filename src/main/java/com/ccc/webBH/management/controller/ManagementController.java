package com.ccc.webBH.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagementController {

	@RequestMapping("/orderMgmt")
	public String test() {
		return "orderManagement";
	}
	
	@RequestMapping("/productMgmt")
	public String test1() {
		return "productManagement";
	}
	
	@RequestMapping("/userMgmt")
	public String test2() {
		return "userManagement";
	}
}

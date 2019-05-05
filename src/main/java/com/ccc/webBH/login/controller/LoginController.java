package com.ccc.webBH.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.ccc.webBH.management.dao.UserDAO;
import com.ccc.webBH.management.entiy.Account;


@Controller
public class LoginController {
	
	@Autowired
	UserDAO userdao;
	
	
	@GetMapping("/Login")
	public String showLogin(Model modal) {
		Account acc =new Account();
		modal.addAttribute("account",acc);
		return "login";
	}
	
	@PostMapping("/signup")
	public String sigup(@ModelAttribute("account") Account acc) {
		acc.setCode("CUS");
		acc.setIdAcc("not");
		userdao.addNew(acc);
		return "product";
	}
}

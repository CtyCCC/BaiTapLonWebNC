package com.ccc.webBH.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ccc.webBH.login.config.UserDetailimpl;
import com.ccc.webBH.management.dao.UserDAO;
import com.ccc.webBH.management.entiy.Account;


@Controller
public class LoginController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDAO userdao;
	
	
	@GetMapping("/Login")
	public String showLogin(Model modal) {
		Account acc =new Account();
		modal.addAttribute("account",acc);
		return "login";
	}
	
	@PostMapping("/signup")
	public String sigup(@ModelAttribute("account") Account acc,HttpServletRequest req) {
		acc.setCode("CUS");
		acc.setIdAcc("not");
		userdao.addNew(acc);
		authenticateUserAndSetSession(acc,req);
		return "redirect:/product";
	}
	
	 private void authenticateUserAndSetSession(Account user, HttpServletRequest request) {
	        String username = user.getUserName();
	        String password = user.getPass();
	        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

	        // generate session if one doesn't exist
	        request.getSession();

	        token.setDetails(new WebAuthenticationDetails(request));
	        Authentication authenticatedUser = authenticationManager.authenticate(token);

	        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	    }
}

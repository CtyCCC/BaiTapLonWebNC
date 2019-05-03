package com.ccc.webBH.management.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccc.webBH.management.dao.UserDAO;
import com.ccc.webBH.management.entiy.Account;

@Controller
public class ManagementController {
	
	@Autowired
	UserDAO dao;
	
	
	@RequestMapping("/orderMgmt")
	public String test() {
		return "orderManagement";
	}
	
	@RequestMapping("/productMgmt")
	public String test1() {
		return "productManagement";
	}
	
	@RequestMapping("/userMgmt")
	public String test2(Model model) {
		ArrayList<Account> arrAcc = new ArrayList<Account>();
		arrAcc = dao.getAllAccount();
		model.addAttribute("listAccount",arrAcc);
		
//		String id = dao.autoIdAcc(arrAcc);
//		Account a = new Account("ACC4", "ADM", "chienprp123", "123", "Trần Đình Cường", "chien@adsada", "1", "6465465", "tân binhnf");
//		
//		int kq = dao.updateAcc(a);
//		if (kq>0)
//			System.out.println("okeee");
//		else
//			System.out.println("lỗi");
		return "userManagement";
	}
	
	@RequestMapping(value="/deleteAcc",method=RequestMethod.POST)
	public void delete(HttpServletRequest request) {
		System.out.println("đâsdkjasdlkjadlkajdkl");
		String id = request.getParameter("idAcc");
		System.out.println(id);
//		if(dao.deleteAcc(id) > 0)
//			System.out.println("Xóa thành công!!");
	}
}

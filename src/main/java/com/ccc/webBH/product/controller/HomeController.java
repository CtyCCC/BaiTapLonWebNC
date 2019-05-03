package com.ccc.webBH.product.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ccc.webBH.product.dao.ProductDAO;
import com.ccc.webBH.product.entity.Product;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	ProductDAO dao;
	
	@GetMapping("/product")
	public String product(Model model) {
		ArrayList<Product> ds = (ArrayList<Product>) dao.getAllProductByType("Car");
		model.addAttribute("dsCar", ds);
		return "product";
	}
	
	@GetMapping("/phukien")
	public String phukien(Model model) {
		ArrayList<Product> ds = (ArrayList<Product>) dao.getAllProductByType("Accessories");
		model.addAttribute("dsPK", ds);
		return "phukien";
	}
	
	@GetMapping("/product-detail")
	public String productDetail(Model model, HttpServletRequest req){
		String idPro = req.getParameter("idPro");
		Product pr = (Product) dao.getAllProductById(idPro);
		model.addAttribute("pro", pr);
		System.out.println(pr);
		return "product-detail";
	}
}

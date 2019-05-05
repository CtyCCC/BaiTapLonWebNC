package com.ccc.webBH.product.controller;


import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccc.webBH.product.dao.ProductDAO;
import com.ccc.webBH.product.entity.Cart;
import com.ccc.webBH.product.entity.Product;

/**
 * Handles requests for the application home page.
 */
@Controller
@Transactional
public class HomeController {
	
	@Autowired
	ProductDAO dao;
	
	@GetMapping("/product")
	public String product(Model model, HttpSession session) {
		HashMap<String,Cart> cartItems = (HashMap<String, Cart>) session.getAttribute("CartItems");
		int quan = 0;
		if(!(cartItems == null)) {
			quan = cartItems.size();			
		}
		ArrayList<Product> ds = (ArrayList<Product>) dao.getAllProductByType("Car");
		model.addAttribute("quantity",quan);
		model.addAttribute("dsPro", ds);
		model.addAttribute("cmd", "product");
		return "product";
	}
	
	@GetMapping("/phukien")
	public String phukien(Model model,HttpSession session) {
		HashMap<String,Cart> cartItems = (HashMap<String, Cart>) session.getAttribute("CartItems");
		int quan = 0;
		if(!(cartItems == null)) {
			quan = cartItems.size();			
		}
		ArrayList<Product> ds = (ArrayList<Product>) dao.getAllProductByType("Accessories");
		model.addAttribute("quantity",quan);
		model.addAttribute("dsPro", ds);
		model.addAttribute("cmd", "phukien");
		return "product";
	}
	
	@GetMapping("/product-detail")
	public String productDetail(Model model, HttpServletRequest req,HttpSession session){
		HashMap<String,Cart> cartItems = (HashMap<String, Cart>) session.getAttribute("CartItems");
		int quan = 0;
		String idPro = req.getParameter("idPro");
		Product pr = (Product) dao.getProductById(idPro);
		model.addAttribute("pro", pr);
		model.addAttribute("quantity",quan);
		return "product-detail";
	}
	
	@PostMapping("/addCart")
	public @ResponseBody String addCart(HttpServletRequest req,HttpSession session) {
		String idPro = req.getParameter("idPro");
		System.out.println(idPro);

		ArrayList<String> dsIdPro = (ArrayList<String>) session.getAttribute("dsIdPro");
		int kt = 0;
		if(dsIdPro == null) {
			dsIdPro = new ArrayList<String>();
			dsIdPro.add(idPro);
		}else {
			for(int i = 0; i<dsIdPro.size();i++) {
				if(dsIdPro.get(i).equals(idPro)) {
					kt++;
				}
			}
			if(kt==0) {
				dsIdPro.add(idPro);
			}
		}
		
		
		//Kiá»ƒm tra xem Ä‘Ã£ cÃ³ Cart nÃ o trong session chÆ°a...náº¿u chÆ°a thÃ¬ táº¡o
		HashMap<String,Cart> cartItems = (HashMap<String, Cart>) session.getAttribute("CartItems");
		if (cartItems == null) {
            cartItems = new HashMap<String,Cart>();
        }
		
		//Kiá»ƒm tra product Ä‘Ã£ cÃ³ trong session chÆ°a
		Product pro = dao.getProductById(idPro);
		if(cartItems.containsKey(idPro)) {  	//Náº¿u Ä‘Ã£ cÃ³ thÃ¬ cáº­p nháº­t sá»‘ lÆ°á»£ng thÃªm 1
			Cart item = cartItems.get(idPro);
			item.setProduct(pro);
			item.setQuantity(item.getQuantity()+1);
			cartItems.put(idPro, item);
		}else {		//Náº¿u chÆ°a cÃ³ thÃ¬ thÃªm item Ä‘Ã³ vÃ o 
			Cart item = new Cart();
			item.setProduct(pro);
			item.setQuantity(1);
			cartItems.put(idPro, item);
		}
		
		//ThÃªm cart vÃ o session
		session.setAttribute("CartItems", cartItems);
		session.setAttribute("dsIdPro", dsIdPro);
		return cartItems.size()+"";
	}
	
	@GetMapping("/cart")
	public String cart(HttpSession session,Model model) {
		//Kiá»ƒm tra session
		HashMap<String,Cart> cartItems = (HashMap<String, Cart>) session.getAttribute("CartItems");
		ArrayList<String> dsIdPro = (ArrayList<String>) session.getAttribute("dsIdPro");
		ArrayList<Cart> dsCart = new ArrayList<Cart>();
		
		//Chuyá»ƒn dá»¯ liá»‡u session thÃ nh 1 máº£ng cÃ¡c item trong cart
		if(cartItems!=null && dsIdPro!=null){
			for (int i=0; i<dsIdPro.size();i++) {
				Cart item = cartItems.get(dsIdPro.get(i));
				if(item !=null) {
					dsCart.add(item);
				}			
			}
		}else {
			System.out.println("Ko co san pham trong gio hang!");
		}
		
		//TÃ­nh tá»•ng tiá»�n
		double totalPrice = 0;
		for(int i=0;i<dsCart.size();i++) {
			totalPrice += (dsCart.get(i).getProduct().getPrice()*dsCart.get(i).getQuantity());
		}
		
		//GÃ¡n giÃ¡ trá»‹ cho model Ä‘á»ƒ font-end sá»­ dá»¥ng
		model.addAttribute("dsCart", dsCart);
		model.addAttribute("quantity",dsCart.size());
		model.addAttribute("totalPrice", totalPrice);
		return "cart";
	}
	
	@PostMapping("/deleteCart")
	public @ResponseBody String removeCart(HttpServletRequest req,HttpSession session ) {
		String key = req.getParameter("key");
		System.out.println(key);
		//Kiá»ƒm tra vÃ  xÃ³a item khá»�i session CartItems
		HashMap<String,Cart> cartItems = (HashMap<String, Cart>) session.getAttribute("CartItems");
		if (cartItems == null) {
            cartItems = new HashMap<String,Cart>();
        }
		if(cartItems.containsKey(key)) {
			cartItems.remove(key);
		}
		
		//Kiá»ƒm tra vÃ  xÃ³a idPro khá»�i session dsIdPro
		ArrayList<String> dsIdPro = (ArrayList<String>) session.getAttribute("dsIdPro");
		if(dsIdPro == null) {
			dsIdPro = new ArrayList<String>();
		}
		for(int i = 0; i < dsIdPro.size(); i++) {
			if(dsIdPro.get(i).equals(key)) {
				dsIdPro.remove(i);
			}
		}
		return "OK!";
	}
	
	@PostMapping("/upQuantity")
	public @ResponseBody void upQuantity(HttpServletRequest req,HttpSession session ) {
		String key = req.getParameter("key");
		HashMap<String,Cart> cartItems = (HashMap<String, Cart>) session.getAttribute("CartItems");
		if(cartItems!=null){
			Cart c = cartItems.get(key);
			c.setQuantity(cartItems.get(key).getQuantity()+1);
			cartItems.replace(key, c);
		}
	}
	
	@PostMapping("/downQuantity")
	public @ResponseBody void downQuantity(HttpServletRequest req,HttpSession session ) {
		String key = req.getParameter("key");
		HashMap<String,Cart> cartItems = (HashMap<String, Cart>) session.getAttribute("CartItems");
		if(cartItems!=null){
			Cart c = cartItems.get(key);
			c.setQuantity(cartItems.get(key).getQuantity()-1);
			cartItems.replace(key, c);
		}
	}
	
	@GetMapping("/searchKeyword")
	public String searchByKeyWord(Model model, HttpSession session, HttpServletRequest req) {
		String keyword = req.getParameter("keyword");
		String cmd = req.getParameter("cmd");
		HashMap<String,Cart> cartItems = (HashMap<String, Cart>) session.getAttribute("CartItems");
		int quan = 0;
		if(!(cartItems == null)) {
			quan = cartItems.size();			
		}
		ArrayList<Product> ds = (ArrayList<Product>) dao.getAllProductWithKeyWord(keyword,cmd);
		model.addAttribute("quantity",quan);
		model.addAttribute("dsPro", ds);
		model.addAttribute("cmd", cmd);
		return "product";
	}
	
	@GetMapping("/searchPrice")
	public String searchByPrice(Model model, HttpSession session, HttpServletRequest req) {
		double min = Double.parseDouble(req.getParameter("lower"));
		double max = Double.parseDouble(req.getParameter("upper"));
		String cmd = req.getParameter("cmd");
		System.out.println();
		HashMap<String,Cart> cartItems = (HashMap<String, Cart>) session.getAttribute("CartItems");
		int quan = 0;
		if(!(cartItems == null)) {
			quan = cartItems.size();			
		}
		ArrayList<Product> ds = (ArrayList<Product>) dao.getAllProductWithPrice(min, max, cmd);
		model.addAttribute("quantity",quan);
		model.addAttribute("dsPro", ds);
		model.addAttribute("cmd", cmd);
		return "product";
	}
}

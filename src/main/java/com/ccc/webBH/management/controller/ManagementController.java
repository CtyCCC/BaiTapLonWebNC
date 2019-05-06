package com.ccc.webBH.management.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ccc.webBH.management.dao.OrderDAO;
import com.ccc.webBH.management.dao.ProDAO;
import com.ccc.webBH.management.dao.UserDAO;
import com.ccc.webBH.management.entiy.Account;
import com.ccc.webBH.management.entiy.OrderDetail;
import com.ccc.webBH.management.entiy.Orders;
import com.ccc.webBH.product.entity.Product;

@Controller
public class ManagementController {

	@Autowired
	UserDAO dao;

	@Autowired
	OrderDAO odDao;

	@Autowired
	ProDAO proDao;

	//PHẦN PRODUCTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT-----------------------------------------------
	@RequestMapping("/productMgmt")
	public String test1(Model model, Principal principal) {
		ArrayList<Product> arrPro = new ArrayList<Product>();
		arrPro = proDao.getAllPro();
		model.addAttribute("listPro",arrPro);
		
		String isLogin = "not";
		Account acc = new Account();
		//Kiểm tra login và đỗ dữ liệu cho user
		if(principal!= null && !"".equals(principal.getName())) {
			acc = dao.getAccountByUserName(principal.getName());
			isLogin = "ok";
		}
		model.addAttribute("isLogin", isLogin);
		model.addAttribute("user", acc);
		
		return "productManagement";
	}

	@RequestMapping(value="/deletePro",method=RequestMethod.POST)
	public @ResponseBody void deletepro(HttpServletRequest request) {
		String id = request.getParameter("idPro");
		System.out.println(id);
		if(proDao.deletePro(id) > 0)
			System.out.println("Xóa thành công!!");
		else
			System.out.println("ko xóa được vì forience key");
	}

	@RequestMapping(value="/editPro",method=RequestMethod.POST)
	public @ResponseBody void editpro(HttpServletRequest request) {

		String idPro = request.getParameter("id");
		String namePro = request.getParameter("name");
		String publicationYear1 = request.getParameter("year");
		int publicationYear = Integer.parseInt(publicationYear1);
		String supplier = request.getParameter("sup");
		String type = request.getParameter("type");
		String price1 = request.getParameter("price");
		double price = Double.parseDouble(price1);
		String des = request.getParameter("des");
		String urlImage = request.getParameter("url");
		//System.out.println(idPro+","+ namePro +","+publicationYear+","+ supplier+","+ type +","+price +","+des +","+urlImage);

		Product pro = new Product(idPro, namePro, publicationYear, supplier, type, price, des, urlImage);

		if(proDao.updatePro(pro) > 0)
			System.out.println("Sửa thành công!!");
		else
			System.out.println("Ko sửa đc");
	}

	@RequestMapping(value="/addPro",method=RequestMethod.POST)
	public @ResponseBody void addpro(HttpServletRequest request) {

		String  idPro = "chien";
		String namePro = request.getParameter("name");
		String publicationYear1 = request.getParameter("year");
		int publicationYear = Integer.parseInt(publicationYear1);
		String supplier = request.getParameter("sup");
		String type = request.getParameter("type");
		String price1 = request.getParameter("price");
		double price = Double.parseDouble(price1);
		String des = request.getParameter("des");
		String urlImage1 = request.getParameter("url");
		String urlImage = "public/images/" + urlImage1;

		//System.out.println(idPro+","+ namePro +","+publicationYear+","+ supplier+","+ type +","+price +","+des +","+urlImage);

		Product pro = new Product(idPro, namePro, publicationYear, supplier, type, price, des, urlImage);

		if(proDao.addPro(pro) > 0)
			System.out.println("Thêm thành công!!");
		else
			System.out.println("Ko Thêm đc");
	}


	//PHẦN ORDERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR-----------------------------------------------------
	
	String idOrAjax = "";//bí quá chơi biến toàn cục tạm
	
	@RequestMapping("/orderMgmt")
	public String test(Model model, Principal principal) {
		
		//get all order
		ArrayList<Orders> arrOd = new ArrayList<Orders>();
		arrOd = odDao.getAllOrder();
		model.addAttribute("listOrder", arrOd);
		
		//chưa chọn order nào thì bảng order detail để null
//		ArrayList<OrderDetail> arr = null;
//		model.addAttribute("listOrderDetail",arr);
		
		//Kiểm tra login và đỗ dữ liệu cho user
		String isLogin = "not";
		Account acc = new Account();
		if(principal!= null && !"".equals(principal.getName())) {
			acc = dao.getAccountByUserName(principal.getName());
			isLogin = "ok";
		}
		model.addAttribute("isLogin", isLogin);
		model.addAttribute("user", acc);
		
		//Order detail, biến toàn cục có giá trị khi click vào row trong bảng order, gửi ajax lên
		ArrayList<OrderDetail> arrOD = new ArrayList<OrderDetail>();
		if (idOrAjax.equals("")) {
			model.addAttribute("listOrderDetail",null);
		}else {
			arrOD = odDao.getODDByOrderID(idOrAjax);
			model.addAttribute("listOrderDetail",arrOD);
		}
		
		return "orderManagement";
	}
	
	@RequestMapping(value="/fillODDTable",method=RequestMethod.POST)
	public @ResponseBody void fillTable(HttpServletRequest request, Model model) {
		
		idOrAjax = request.getParameter("idOrder");
		
	}


	//PHẦN USERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR-----------------------------------------------------
	@RequestMapping("/userMgmt")
	public String test2(Model model, Principal principal) {
		ArrayList<Account> arrAcc = new ArrayList<Account>();
		arrAcc = dao.getAllAccount();
		model.addAttribute("listAccount",arrAcc);

		String isLogin = "not";
		Account acc = new Account();
		//Kiểm tra login và đỗ dữ liệu cho user
		if(principal!= null && !"".equals(principal.getName())) {
			acc = dao.getAccountByUserName(principal.getName());
			isLogin = "ok";
		}
		model.addAttribute("isLogin", isLogin);
		model.addAttribute("user", acc);
		
//		System.out.println(dao.getAllUserName());
//		System.out.println(dao.getAllEmail());

		return "userManagement";
	}

	@RequestMapping(value="/deleteAcc",method=RequestMethod.POST)
	public @ResponseBody void delete(HttpServletRequest request) {
		String id = request.getParameter("idAcc");
		if(dao.deleteAcc(id) > 0)
			System.out.println("Xóa thành công!!");
		else
			System.out.println("ko xóa được vì forience key");
	}

	@RequestMapping(value="/editAcc",method=RequestMethod.POST)
	public @ResponseBody void edit(HttpServletRequest request) {
		String idAcc = request.getParameter("idAcc");
		String nameCus = request.getParameter("nameCus");
		String gender1 = request.getParameter("gender");
		int gender = 0;
		if (gender1.equals("Nam"))
			gender = 1;
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		//String userName = request.getParameter("user");
		//String code = request.getParameter("role");
		//String pass = request.getParameter("pass");
		//System.out.println(id+","+ nameCus +","+gender+","+ phone+","+ email +","+address +","+user +","+role +","+pass);

		if(dao.updateAcc(idAcc, nameCus, email, phone, gender, address) > 0)
			System.out.println("Sửa thành công!!");
		else
			System.out.println("Ko sửa đc");
	}

	@RequestMapping(value="/addAcc",method=RequestMethod.POST)
	public @ResponseBody void add(HttpServletRequest request, ModelAndView m) {

		String idAcc = "chien"; //ko có dùng id này, tạo cho có thôi
		String nameCus = request.getParameter("nameCus");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String userName = request.getParameter("user");
		String code = request.getParameter("role");
		String pass = request.getParameter("pass");
		System.out.println(idAcc+","+ nameCus +","+gender+","+ phone+","+ email +","+address +","+userName +","+code +","+pass);

		boolean add = true;
		ArrayList<String> arrEmail = dao.getAllEmail();
		ArrayList<String> arrUser = dao.getAllUserName();
		for (String u : arrUser) {
			if (userName.equals(u))
				add = false;
		}
		for (String e : arrEmail) {
			if (email.equals(e))
				add = false;
		}
		if (add) {
			Account ac = new Account(idAcc, code, userName, pass, nameCus, email, gender, phone, address);
			if(dao.addNew(ac) > 0)
				System.out.println("Thêm thành công!!");
			else
				System.out.println("Ko Thêm đc");
		}else {
			System.out.println("ko thêm được, trùng dữ liệu !!");
		}
		m.addObject("message", "trùng dữ liệu");
	}
}
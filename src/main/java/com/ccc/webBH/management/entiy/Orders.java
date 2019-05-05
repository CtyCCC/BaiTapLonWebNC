	package com.ccc.webBH.management.entiy;

import java.util.ArrayList;

public class Orders {

	private String idOrder;
	private String idAcc;
	private String dateCreate;
	private String totalPrice;
	private ArrayList<OrderDetail> arrODD;
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public String getIdAcc() {
		return idAcc;
	}
	public void setIdAcc(String idAcc) {
		this.idAcc = idAcc;
	}
	public String getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ArrayList<OrderDetail> getArrODD() {
		return arrODD;
	}
	public void setArrODD(ArrayList<OrderDetail> arrODD) {
		this.arrODD = arrODD;
	}
	public Orders(String idOrder, String idAcc, String dateCreate, String totalPrice, ArrayList<OrderDetail> arrODD) {
		super();
		this.idOrder = idOrder;
		this.idAcc = idAcc;
		this.dateCreate = dateCreate;
		this.totalPrice = totalPrice;
		this.arrODD = arrODD;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Orders [idOrder=" + idOrder + ", idAcc=" + idAcc + ", dateCreate=" + dateCreate + ", totalPrice="
				+ totalPrice + ", arrODD=" + arrODD + "]";
	}
	
}

package com.ccc.webBH.management.entiy;

public class OrderDetail {
	
	private String idDetail;
	private String idOrder;
	private String idPro;
	private String quantity;
	private String price;
	public String getIdDetail() {
		return idDetail;
	}
	public void setIdDetail(String idDetail) {
		this.idDetail = idDetail;
	}
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public String getIdPro() {
		return idPro;
	}
	public void setIdPro(String idPro) {
		this.idPro = idPro;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public OrderDetail(String idDetail, String idOrder, String idPro, String quantity, String price) {
		super();
		this.idDetail = idDetail;
		this.idOrder = idOrder;
		this.idPro = idPro;
		this.quantity = quantity;
		this.price = price;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDetail [idDetail=" + idDetail + ", idOrder=" + idOrder + ", idPro=" + idPro + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	

}

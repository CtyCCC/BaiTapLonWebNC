package com.ccc.webBH.product.entity;

public class FormMail {
	private String idSP;
	private String nameSP;
	private String quantity;
	private String price;
	private String tt;
	public String getIdSP() {
		return idSP;
	}
	public void setIdSP(String idSP) {
		this.idSP = idSP;
	}
	public String getNameSP() {
		return nameSP;
	}
	public void setNameSP(String nameSP) {
		this.nameSP = nameSP;
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
	public String getTt() {
		return tt;
	}
	public void setTt(String tt) {
		this.tt = tt;
	}
	@Override
	public String toString() {
		return "FormMail [idSP=" + idSP + ", nameSP=" + nameSP + ", quantity=" + quantity + ", price=" + price + ", tt="
				+ tt + "]";
	}
	public FormMail(String idSP, String nameSP, String quantity, String price, String tt) {
		super();
		this.idSP = idSP;
		this.nameSP = nameSP;
		this.quantity = quantity;
		this.price = price;
		this.tt = tt;
	}
	public FormMail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

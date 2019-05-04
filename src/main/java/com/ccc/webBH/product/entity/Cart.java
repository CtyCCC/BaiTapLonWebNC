package com.ccc.webBH.product.entity;


public class Cart {
	private Product product;
	private int quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [product=" + product + ", quantity=" + quantity + "]";
	}
	public Cart(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

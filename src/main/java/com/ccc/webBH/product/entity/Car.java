package com.ccc.webBH.product.entity;

public class Car {
	private String idCar;
	private String nameCar;
	private int namSX;
	private String idNSX;
	private double price;
	private String desCar;
	private String urlImage;
	public String getIdCar() {
		return idCar;
	}
	public void setIdCar(String idCar) {
		this.idCar = idCar;
	}
	public String getNameCar() {
		return nameCar;
	}
	public void setNameCar(String nameCar) {
		this.nameCar = nameCar;
	}
	public int getNamSX() {
		return namSX;
	}
	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}
	public String getIdNSX() {
		return idNSX;
	}
	public void setIdNSX(String idNSX) {
		this.idNSX = idNSX;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesCar() {
		return desCar;
	}
	public void setDesCar(String desCar) {
		this.desCar = desCar;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	@Override
	public String toString() {
		return "Car [idCar=" + idCar + ", nameCar=" + nameCar + ", namSX=" + namSX + ", idNSX=" + idNSX + ", price="
				+ price + ", desCar=" + desCar + ", urlImage=" + urlImage + "]";
	}
	public Car(String idCar, String nameCar, int namSX, String idNSX, double price, String desCar, String urlImage) {
		super();
		this.idCar = idCar;
		this.nameCar = nameCar;
		this.namSX = namSX;
		this.idNSX = idNSX;
		this.price = price;
		this.desCar = desCar;
		this.urlImage = urlImage;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}

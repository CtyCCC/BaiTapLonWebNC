package com.ccc.webBH.product.entity;

public class Product {
	private String idPro;
	private String namePro;
	private int publicationYear;
	private String supplier;
	private String type;
	private double price;
	private String des;
	private String urlImage;
	
	public Product(String idPro, String namePro, int publicationYear, String supplier, String type, double price,
			String des, String urlImage) {
		super();
		this.idPro = idPro;
		this.namePro = namePro;
		this.publicationYear = publicationYear;
		this.supplier = supplier;
		this.type = type;
		this.price = price;
		this.des = des;
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		return "Product [idPro=" + idPro + ", namePro=" + namePro + ", publicationYear=" + publicationYear + ", supplier="
				+ supplier + ", type=" + type + ", price=" + price + ", des=" + des + ", urlImage=" + urlImage + "]";
	}

	public String getIdPro() {
		return idPro;
	}

	public void setIdPro(String idPro) {
		this.idPro = idPro;
	}

	public String getNamePro() {
		return namePro;
	}

	public void setNamePro(String namePro) {
		this.namePro = namePro;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}

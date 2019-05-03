package com.ccc.webBH.management.entiy;

public class Account {

	private String idAcc;
	private String code;
	private String userName;
	private String pass;
	private String nameCus;
	private String email;
	private String gender;
	private String phone;
	private String address;
	public String getIdAcc() {
		return idAcc;
	}
	public void setIdAcc(String idAcc) {
		this.idAcc = idAcc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNameCus() {
		return nameCus;
	}
	public void setNameCus(String nameCus) {
		this.nameCus = nameCus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Account(String idAcc, String code, String userName, String pass, String nameCus, String email, String gender,
			String phone, String address) {
		super();
		this.idAcc = idAcc;
		this.code = code;
		this.userName = userName;
		this.pass = pass;
		this.nameCus = nameCus;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
}

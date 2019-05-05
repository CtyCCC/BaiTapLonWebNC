package com.ccc.webBH.login.entity;

public class Role {

	private String code;
	private String rolename;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Role(String code, String rolename) {
		super();
		this.code = code;
		this.rolename = rolename;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

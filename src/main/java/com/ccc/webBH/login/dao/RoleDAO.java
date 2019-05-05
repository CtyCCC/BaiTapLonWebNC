package com.ccc.webBH.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ccc.webBH.login.entity.RoleMapper;

@Repository
public class RoleDAO {

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public String getRolebyCode(String code) {
		String sql = "select * from Roles where code = ?";
		RoleMapper rolemapper =new RoleMapper();
		return template.queryForObject(sql,new Object[] {code},rolemapper).getRolename();
	}
}

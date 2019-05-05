package com.ccc.webBH.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ccc.webBH.login.entity.AccountMapper;
import com.ccc.webBH.management.entiy.Account;


@Repository         
public class AccountDAO {
	
	@Autowired
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public Account getInfoAccbyName(String username) {
		String sql = "select * from Account where username = ?";
		AccountMapper accountmapper = new AccountMapper();
		return template.queryForObject(sql, new Object[] {username},accountmapper);
	}
}

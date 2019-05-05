package com.ccc.webBH.login.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ccc.webBH.login.entity.AccountMapper;
import com.ccc.webBH.management.entiy.Account;

@Component
@Repository
public class AccountDAO  extends JdbcDaoSupport{
	
//	@Autowired
//	JdbcTemplate template;
//	
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//	}
	
	public AccountDAO(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.setDataSource(dataSource);
	}
	public Account getInfoAccbyName(String username) {
		String sql = "select * from Account where username = ?";
		AccountMapper accountmapper = new AccountMapper();
		return this.getJdbcTemplate().queryForObject(sql, new Object[] {username},accountmapper);
	}
}

package com.ccc.webBH.login.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ccc.webBH.login.entity.RoleMapper;

@Component
@Repository
public class RoleDAO extends JdbcDaoSupport {

//	@Autowired
//	JdbcTemplate template;
//
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//	}
public RoleDAO(DataSource dataSource) {
	// TODO Auto-generated constructor stub
	this.setDataSource(dataSource);
}
	public String getRolebyCode(String code) {
		String sql = "select * from Roles where code = ?";
		RoleMapper rolemapper =new RoleMapper();
		return this.getJdbcTemplate().queryForObject(sql,new Object[] {code},rolemapper).getRolename();
	}
}

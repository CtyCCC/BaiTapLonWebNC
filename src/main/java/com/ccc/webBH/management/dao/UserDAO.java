package com.ccc.webBH.management.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ccc.webBH.management.entiy.Account;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public ArrayList<Account> getAllAccount(){
		String sql = "select * from Account";
		return (ArrayList<Account>) template.query(sql, new RowMapper<Account>() {
			public Account mapRow(ResultSet rs, int row) throws SQLException {
				String gender ="Nam";
				if (rs.getString(7).equals("0")) 
					gender = "Nữ";
				Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), gender, rs.getString(8), rs.getString(9));
				return a;
			}
		});
	}
	
	public int deleteAcc(String idAcc) {
		String sql =  "delete from Account where idAcc = '" + idAcc +"'";
		int kq = 0;
		try {
			kq = template.update(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	
	public int updateAcc (Account ac) {
		String sql = "update Account set code = '"+ac.getCode()+"', userName = '"+ac.getUserName()+"', pass = '"+ac.getPass()+"', nameCus = N'"+ac.getNameCus()+
				"', email = '"+ac.getEmail()+"', gender = '"+ac.getGender()+"', phone = '"+ac.getPhone()+"', addresss = N'"+ac.getAddress()+ "' where idAcc = '"+ac.getIdAcc()+"'";
		
		int kq = 0;
		try {
			kq = template.update(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	
	public int addNew(Account ac ) {
		String id = autoIdAcc(getAllAccount());
		String sql = "insert into Account values ('"+id+"','"+ac.getCode()+"','"+ac.getUserName()+"','"+ac.getPass()+"',N'"+ac.getNameCus()+"','"+
		ac.getEmail()+"','"+ac.getGender()+"','"+ac.getPhone()+"',N'"+ac.getAddress()+"')";
		int kq = 0;
		try {
			kq = template.update(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	public String autoIdAcc(ArrayList<Account> arr) {
		int count = arr.size()+1;
		return "ACC"+count+"";
	}
}

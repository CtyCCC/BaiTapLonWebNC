package com.ccc.webBH.management.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ccc.webBH.login.entity.AccountMapper;
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
	
	public int updateAcc (String idAcc, String nameCus, String email, String phone, int gender, String address) {
		String sql = "update Account set nameCus = N'"+nameCus+
				"', email = '"+email+"', gender = "+gender+", phone = '"+phone+"', addresss = N'"+address+ "' where idAcc = '"+idAcc+"'";
		
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
		int gender = 0;
		if (ac.getGender().equals("Nam"))
			gender = 1;
		String sql = "insert into Account values ('"+id+"','"+ac.getCode()+"','"+ac.getUserName()+"','"+ac.getPass()+"',N'"+ac.getNameCus()+"','"+
		ac.getEmail()+"',"+gender+",'"+ac.getPhone()+"',N'"+ac.getAddress()+"')";
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
	
	public Account getAccountByUserName(String userName){
		String sql = "select * from Account where userName = ?";
		return template.queryForObject(sql,new Object[] {userName}, new RowMapper<Account>() {
			public Account mapRow(ResultSet rs, int row) throws SQLException {
				String gender ="Nam";
				if (rs.getString(7).equals("0")) 
					gender = "Nữ";
				Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), gender, rs.getString(8), rs.getString(9));
				return a;
			}
		});
	}
	public ArrayList<String> getAllUserName(){
		String sql = "select userName from Account";
		return (ArrayList<String>) template.query(sql, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int row) throws SQLException {
				String user = rs.getString(1);
				return user;
			}
		});
	}
	public ArrayList<String> getAllEmail(){
		String sql = "select email from Account";
		return (ArrayList<String>) template.query(sql, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int row) throws SQLException {
				String email = rs.getString(1);
				return email;
			}
		});
	}
	
	public Account geAccbytUserName(String username) throws EmptyResultDataAccessException{
		String sql = "select * from Account  where userName = ?";
		AccountMapper accmapper =new AccountMapper();
		return template.queryForObject(sql,new Object[] {username},accmapper);
	}
	public Account  getAccbyEmail(String email) throws EmptyResultDataAccessException{
		String sql = "select * from Account where email = ?";
		AccountMapper accmapper = new AccountMapper();
		return template.queryForObject(sql,new Object[] {email},accmapper );
	}
	
}

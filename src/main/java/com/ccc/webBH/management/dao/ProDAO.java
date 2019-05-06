package com.ccc.webBH.management.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ccc.webBH.product.entity.Product;

@Repository
public class ProDAO {
	
	@Autowired
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public ArrayList<Product> getAllPro(){
		String sql = "select * from Product order by supplier";
		return (ArrayList<Product>) template.query(sql, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product p = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getString(7), rs.getString(8));
				return p;
			}
		});
	}
	
	public int deletePro(String idPro) {
		String sql =  "delete from Product where idPro = '" + idPro +"'";
		int kq = 0;
		try {
			kq = template.update(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	
	public int updatePro (Product pro) {
		
		String sql = "update Product set namePro = N'"+pro.getNamePro()+
									"', publicationYear = "+pro.getPublicationYear()+
									", supplier = N'"+pro.getSupplier()+
									"', typee = '"+pro.getType()+
									"', price = "+pro.getPrice()+
									", descriptions = N'"+pro.getDes()+
									"', urlImage = '"+pro.getUrlImage()+"' where idPro = '"+pro.getIdPro()+"'";
		
		int kq = 0;
		try {
			kq = template.update(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	
	public int addPro (Product pro) {
		String id = autoIdPro(getAllPro());
		System.out.println("id mới nè:" +id);
		String sql = "insert into Product values ('"+id+"',N'"+pro.getNamePro()+"',"+pro.getPublicationYear()+
													",N'"+pro.getSupplier()+"','"+pro.getType()+
													"',"+pro.getPrice()+",N'"+pro.getDes()+"', '"+pro.getUrlImage()+"')";
		
		int kq = 0;
		try {
			kq = template.update(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	
	public String autoIdPro(ArrayList<Product> arr) {
		int count = arr.size()+1;
		return "C"+count+"";
	}

}
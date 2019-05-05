package com.ccc.webBH.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ccc.webBH.product.entity.Product;

@Repository
public class ProductDAO {

	// Do bên cấu hình đặt name là template nên bên đây autowired by name là teamplate
	@Autowired
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//Cách 1
	//Lấy ds tất cả pro
	public List<Product> getAllProduct(){
		String sql = "Select * from Product";
		return template.query(sql, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product c = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5),rs.getDouble(6), rs.getString(7), rs.getString(8));
				return c;
			}
		});
	}
	
	//Cách 2 (có thể dùng cách này để lấy all và ngược lại)
	//Lấy ds pro theo loại
	public List<Product> getAllProductByType(String type) {
        String sql = "Select * from Product where typee = ?";
        List<Map<String, Object>> list = template.queryForList(sql,new Object[] {type});
        List<Product> ds = new ArrayList<Product>();
        for(int i = 0;i<list.size();i++) {
        	Map<String, Object> m = list.get(i);
        	Product c = new Product(m.get("idPro")+"",m.get("namePro")+"",Integer.parseInt(m.get("publicationYear")+""),m.get("supplier")+"",m.get("typee")+"",Double.parseDouble(m.get("price")+""),m.get("descriptions")+"",m.get("urlImage")+"");
        	ds.add(c);
        }
        return ds;
    } 
	
	//Lấy product theo id
	public Product getProductById(String idPro){
		String sql = "Select * from Product where idPro = ?";
		return template.queryForObject(sql,new Object[] {idPro} ,new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product c = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5),rs.getDouble(6), rs.getString(7), rs.getString(8));
				return c;
			}
		});
	}
	
	//Tìm product theo từ khóa
	public List<Product> getAllProductWithKeyWord(String key, String cmd){
		String sql = "select * from Product";
		if(cmd.equals("product")) {
			sql = "select * from Product WHERE typee = 'Car' AND namePro LIKE '%"+key+"%'";
		}
		if(cmd.equals("phukien")) {
			sql = "select * from Product WHERE typee = 'Accessories' AND namePro LIKE '%"+key+"%'";
		}
		
		return template.query(sql, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product c = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5),rs.getDouble(6), rs.getString(7), rs.getString(8));
				return c;
			}
		});
	}
	
	//Tìm theo khoảng price
	public List<Product> getAllProductWithPrice(double min, double max, String cmd){
		String sql = "select * from Product";
		if(cmd.equals("product")) {
			sql = "select * from Product WHERE typee = 'Car' AND price >="+min+" AND price <="+max;
		}
		if(cmd.equals("phukien")) {
			sql = "select * from Product WHERE typee = 'Accessories' AND price >="+min+" AND price <="+max;
		}
		
		return template.query(sql, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product c = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5),rs.getDouble(6), rs.getString(7), rs.getString(8));
				return c;
			}
		});
	} 
}

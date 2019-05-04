package com.ccc.webBH.management.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ccc.webBH.management.entiy.OrderDetail;
import com.ccc.webBH.management.entiy.Orders;

@Repository
public class OrderDAO {

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public ArrayList<Orders> getAllOrder(){
		String sql = "select * from Orders order by dateCreate";
		return (ArrayList<Orders>) template.query(sql, new RowMapper<Orders>() {
			public Orders mapRow(ResultSet rs, int row) throws SQLException {
				ArrayList<OrderDetail> arrODD = getODDByOrderID(rs.getString(1));
				Orders od = new Orders(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), arrODD);
				return od;
			}
		});
	}

	public ArrayList<OrderDetail> getODDByOrderID(String odId){
		String sql = "select * from OrderDetail where idOrder = '"+odId+"'";
		return (ArrayList<OrderDetail>) template.query(sql, new RowMapper<OrderDetail>() {
			public OrderDetail mapRow(ResultSet rs, int row) throws SQLException {
				OrderDetail odD = new OrderDetail(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return odD;
			}
		});
	}
}

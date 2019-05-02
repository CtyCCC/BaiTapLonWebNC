package com.ccc.webBH.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ccc.webBH.product.entity.Car;

@Repository
public class ProductDAO {

	// Do bên cấu hình đặt name là template nên bên đây autowired by name là teamplate
	@Autowired
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//Cách 1
	//Lấy ds tất cả car
	public List<Car> getAllCar(){
		String sql = "Select * from Car";
		return template.query(sql, new RowMapper<Car>() {
			public Car mapRow(ResultSet rs, int row) throws SQLException {
				Car c = new Car(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getDouble(5), rs.getString(6), rs.getString(7));
				return c;
			}
		});
	}
	
	//Cách 2 (có thể dùng cách này để lấy all và ngược lại)
	//Lấy ds car theo idNSX
	public List<Car> getAllCarByIdNSX(String idNSX) {
        String sql = "Select * from Car where idNSX = ?";
        List<Map<String, Object>> list = template.queryForList(sql,new Object[] {idNSX});
        List<Car> ds = new ArrayList<Car>();
        for(int i = 0;i<list.size();i++) {
        	Map<String, Object> m = list.get(i);
        	Car c = new Car(m.get("idCar")+"",m.get("nameCar")+"",Integer.parseInt(m.get("namSX")+""),m.get("idNSX")+"",Double.parseDouble(m.get("price")+""),m.get("desCar")+"",m.get("urlImage")+"");
        	ds.add(c);
        }
        return ds;
    } 
	
}

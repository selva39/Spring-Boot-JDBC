package com.example.demo.ctrl;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.User_tbl;

public class UserMapper implements RowMapper<User_tbl> {

	@Override
	public User_tbl mapRow(ResultSet rs, int rowNum) throws SQLException {
		User_tbl user=new User_tbl();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		return user;
	}

}

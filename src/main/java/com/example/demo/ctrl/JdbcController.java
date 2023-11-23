package com.example.demo.ctrl;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User_tbl;

@RestController
public class JdbcController {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@RequestMapping("/insert")
	public String index()
	{
		jdbc.execute("insert into user_tbl(name,email) values('saravana','saravana@gmail.com')");
		jdbc.execute("insert into user_tbl(name,email) values('sneha','sneha@gmail.com')");
		return "inserted successfully";
	}
	@RequestMapping("/update")
	public String update()
	{
		jdbc.execute("update user_tbl set name='saravanakumar' where id=5");
		return "update Successfully";
	}
	@RequestMapping("/delete")
	public String delete()
	{
		jdbc.execute("delete from user_tbl where id=6");
		return "deleted successfully";
	}
	@RequestMapping("/fetch")
	public List<User_tbl> fetch()
	{
	List<User_tbl>list=jdbc.query("select * from user_tbl",new UserMapper());
	return list;
	}
	@RequestMapping("/create")
	public String create()
	{
		jdbc.execute("create table user_details(uid int primary key auto_increment, phoneNumber varchar(10))");
		return "created table succesfully";
	}
	
}

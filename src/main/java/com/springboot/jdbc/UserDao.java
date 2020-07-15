package com.springboot.jdbc;

import java.util.ArrayList;
import java.util.List;

import com.springboot.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BeanPropertyBindingResult;

import javax.annotation.Resource;

@Repository
public class UserDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void save(User user) {
		String sql = "insert into user_info(name,age,ctime,mtime) values(?,?,?,?)";
		List<Object> params = new ArrayList<>();
		params.add(user.getName());
		params.add(user.getAge());
		params.add(user.getCtime());
		params.add(user.getMtime());
		jdbcTemplate.update(sql, params.toArray());
	}
	
	public void update(User user) {
		String sql = "update user_info set name=?,age=?,mtime=? where id=?";
		List<Object> params = new ArrayList<>();
		params.add(user.getName());
		params.add(user.getAge());
		params.add(user.getMtime());
		params.add(user.getId());
		jdbcTemplate.update(sql, params.toArray());
	}

	public void delete(long id) {
		String sql = "delete from user_info where id=?";
		jdbcTemplate.update(sql, id);
	}

	public User getById(long id) {
		String sql = "select * from user_info where id=?";
		//如果这样写，当查询结果为空时会报错
//		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
//		return jdbcTemplate.queryForObject(sql, new Object[] {id}, rowMapper);
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		List<User> users = jdbcTemplate.query(sql, new Object[] {id}, rowMapper);
		if(users.isEmpty()){
			return null;
		}
		return users.get(0);
	}
}

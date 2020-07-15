package com.springboot.jdbc;

import com.springboot.model.User;

public interface UserServiceJdbc {
	public void save(User user);
	public void update(User user);
	public void delete(long id);
	public User getById(long id);
}

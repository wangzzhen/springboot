package com.springboot.jpa;

public interface UserServiceJpa {
	public void save(UserJpa user);
	public void update(UserJpa user);
	public void delete(long id);
	public UserJpa getById(long id);
}

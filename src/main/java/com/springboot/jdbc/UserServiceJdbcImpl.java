package com.springboot.jdbc;

import org.springframework.stereotype.Service;

import com.springboot.model.User;

import javax.annotation.Resource;

@Service
public class UserServiceJdbcImpl implements UserServiceJdbc {

	//官方现在不推荐用autowired属性注入
//	@Autowired
	@Resource
	private UserDao userDao;
	
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
	}

	@Override
	public User getById(long id) {
		return userDao.getById(id);
	}

}

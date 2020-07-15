package com.springboot.mybatis;

import com.springboot.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceMybatisImpl implements UserServiceMybatis {

//	@Autowired
	@Resource
	private UserMapper userMapper;
	
	@Override
	public void save(User user) {
		userMapper.save(user);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public void delete(long id) {
		userMapper.delete(id);
	}

	@Override
	public User getById(long id) {
		return userMapper.getById(id);
	}

}

package com.springboot.jpa;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceJpaImpl implements UserServiceJpa {

//	@Autowired
	@Resource
	private UserRepository UserRepository;
	
	@Override
	public void save(UserJpa user) {
		UserRepository.save(user);
	}

	@Override
	public void update(UserJpa user) {
		UserRepository.save(user);
	}

	@Override
	public void delete(long id) {
		UserRepository.deleteById(id);
	}

	@Override
	public UserJpa getById(long id) {
		return UserRepository.findById(id);
	}

}

package com.test.springboot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.springboot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.jdbc.UserServiceJdbc;
import com.springboot.model.User;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JdbcTest {
	
	@Resource
	private UserServiceJdbc userServiceJdbc;
	
	@Test
	public void test() {
		System.out.println("test starting");
		User result = userServiceJdbc.getById(15);
		if(result != null){
			result.setName("csUpdate");
			result.setMtime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			userServiceJdbc.update(result);
		}else {
			User user = new User();
			user.setName("csAdd");
			user.setAge(24);
			String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			user.setCtime(now);
			user.setMtime(now);
			userServiceJdbc.save(user);
		}
		System.out.println("test end");
	}

}

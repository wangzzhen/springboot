package com.test.springboot;

import com.springboot.Application;
import com.springboot.jpa.UserJpa;
import com.springboot.jpa.UserServiceJpa;
import com.springboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JpaTest {
	
	@Resource
	private UserServiceJpa userServiceJpa;
	
	@Test
	public void test() {
		System.out.println("test starting");
		UserJpa result = userServiceJpa.getById(1);
		if(result != null){
			result.setName("csUpdate");
			result.setMtime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			userServiceJpa.update(result);
		}else {
			UserJpa user = new UserJpa();
			user.setName("csAdd");
			user.setAge(24);
			String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			user.setCtime(now);
			user.setMtime(now);
			userServiceJpa.save(user);
		}
		System.out.println("test end");
	}

}

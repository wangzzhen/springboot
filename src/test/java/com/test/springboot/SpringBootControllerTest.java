package com.test.springboot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.springboot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.springboot.model.Demo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class SpringBootControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private Demo demo;
	
	@Test
	public void Test() throws Exception {
		String string = "hello," + demo.getName();
		System.out.println(string);
		mockMvc.perform(	//执行一个请求
				MockMvcRequestBuilders.get("/"). //构造一个请求
				accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())//执行完后的断言
				.andExpect(content().string(equalTo(string)))
				.andDo(MockMvcResultHandlers.print())//对执行的结果做的事情
				.andReturn();//执行完后返回结果
	}
}

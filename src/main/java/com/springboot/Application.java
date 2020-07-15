package com.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
//			System.out.println("Spring boot starting");
////			//获取所有定义的bean的名字
////			String[] beanNames = ctx.getBeanDefinitionNames();
////			for(String beanName : beanNames) {
////				System.out.println(beanName);
////			}
////			System.out.println("Spring boot end");
		};
	}
}

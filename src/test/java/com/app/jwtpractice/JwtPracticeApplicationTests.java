package com.app.jwtpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class JwtPracticeApplicationTests implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;


	@Test
	void contextLoads() {
	}

	@Override
	public void run(String... args) throws Exception {
		String[] beans = applicationContext.getBeanDefinitionNames();
		for(String bean : beans) {
			System.out.println(bean);
		}
	}

	@Test
	public void checkBean() {
		try {
			run();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

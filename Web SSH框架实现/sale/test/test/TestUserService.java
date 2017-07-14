package test;

import org.junit.Test;
import org.lqz.sale.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

	@Test
	public void test01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		UserService us = (UserService) ac.getBean("userService");
	}
}

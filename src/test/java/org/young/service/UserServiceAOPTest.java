package org.young.service;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.young.entity.User;

public class UserServiceAOPTest {
	UserService service;

	@Before
	public void init() {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (UserService) context.getBean("userService");
	}

	@Test
	public void testSave() {
		User user = new User("张三", (byte) 1, new Date());

		service.save(user);
	}

	@Test
	public void testLoad() {

		service.load("test1");
	}

}

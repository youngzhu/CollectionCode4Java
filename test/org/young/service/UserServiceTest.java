package org.young.service;

import java.lang.reflect.Proxy;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.young.dao.UserDao;
import org.young.dao.UserDaoImpl;
import org.young.entity.User;
import org.young.proxy.LogInterceptor;
import org.young.proxy.TimeLogInterceptor;

public class UserServiceTest {
	UserService service;

	// @Before
	// public void init() {
	// UserDao dao = new UserDaoImpl();
	// service = new UserServiceImpl(dao);
	// }

	/**
	 * 使用代理-service
	 */
	// @Before
	// public void init() {
	// UserDao dao = new UserDaoImpl();
	// service = new UserServiceImpl(dao);
	//
	// LogInterceptor logInterceptor = new LogInterceptor();
	// logInterceptor.setTarget(service);
	//
	// service = (UserService) Proxy.newProxyInstance(service.getClass()
	// .getClassLoader(), service.getClass().getInterfaces(),
	// logInterceptor);
	// }

	/**
	 * 使用代理-service + dao
	 */
	@Before
	public void init() {
		// dao代理
		UserDao dao = new UserDaoImpl();
		TimeLogInterceptor timeLog = new TimeLogInterceptor();
		timeLog.setTarget(dao);
		dao = (UserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(),
				dao.getClass().getInterfaces(), timeLog);

		// service 代理
		service = new UserServiceImpl(dao);
		LogInterceptor logInterceptor = new LogInterceptor();
		logInterceptor.setTarget(service);

		service = (UserService) Proxy.newProxyInstance(service.getClass()
				.getClassLoader(), service.getClass().getInterfaces(),
				logInterceptor);
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

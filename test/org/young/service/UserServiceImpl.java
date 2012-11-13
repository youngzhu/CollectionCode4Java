package org.young.service;

import org.young.dao.UserDao;
import org.young.entity.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User load(String id) {
		return userDao.load(id);
	}

	public void save(User user) {
		userDao.save(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}

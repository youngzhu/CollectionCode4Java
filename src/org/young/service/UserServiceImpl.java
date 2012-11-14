package org.young.service;

import org.young.dao.UserDao;
import org.young.entity.User;

/**
 * 
 *
 * @author by Young.ZHU
 *		on 2012-11-14
 *
 * Package&FileName: org.young.service.UserServiceImpl
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl(){}
	
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

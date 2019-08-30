package org.young.dao;

import org.young.entity.User;

public interface UserDao {

	User load(String id);

	void save(User user);

}

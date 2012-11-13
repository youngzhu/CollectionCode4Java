package org.young.service;

import org.young.entity.User;

public interface UserService {

	User load(String id);
	
	void save(User user);
}

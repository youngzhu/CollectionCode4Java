package org.young.dao;

import org.young.db.DB;
import org.young.entity.User;

public class UserDaoImpl implements UserDao {

	public User load(String id) {
		System.out.println("[Business Logic]Loading the user by id: " + id);
		return null;
	}

	public void save(User user) {

		System.out.println("[Business Logic]Saving the user ...");
		
		Long id = DB.generateUniqueKey();
		System.out.println("生成ID：" + id);
		user.setId(id.toString());
	}

}

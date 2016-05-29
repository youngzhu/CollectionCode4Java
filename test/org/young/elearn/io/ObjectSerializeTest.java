package org.young.elearn.io;

import java.io.Serializable;
import java.util.Date;

import org.junit.Test;
import org.young.elearn.str.io.ObjectSerialize;

public class ObjectSerializeTest extends ObjectSerialize {

	@Test
	public void testWriteObject() {
		User user = new User();
		
		user.username = "Jack";
		user.password = "1234567";
		user.age = 20;
		user.gender = "male";
		user.regDay = new Date();
		user.martialStatus = false;
		
		// 文件的后缀名不影响，无论是 txt，io，甚至是没有后缀
		ObjectSerialize.writeObject(user, "d:\\tmp\\obj");
	}

	@Test
	public void testReadObject() {
		User user = (User) ObjectSerialize.readObject("d:\\tmp\\obj");
		System.out.println(user);
	}
}

class User implements Serializable {

	private static final long serialVersionUID = 7967476135812239100L;

	String username;
	/*
	 * 不想被序列化存储的字段可以用 transient 修饰
	 */
	transient String password;
	int age;
	String gender;
	Date regDay;
	boolean martialStatus;
	String nationality;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + ", gender=" + gender + ", regDay=" + regDay
				+ ", martialStatus=" + martialStatus + ", nationality=" + nationality + "]";
	}

}
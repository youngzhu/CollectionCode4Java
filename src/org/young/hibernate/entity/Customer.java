package org.young.hibernate.entity;

import java.util.Date;

/**
 * 客户
 *
 * @author by Young.ZHU
 *		on 2013-1-29
 *
 * Package&FileName: org.young.hibernate.entity.Customer
 */
public class Customer {
	
	private String id; // 客户ID
	
	private char gender; // 性别
	
	private Date birthday; // 出生年月

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.getId()
				+ "|| GENDER: " + this.getGender()
				+ "|| BIRTHDAY: " + this.getBirthday();
	}
}

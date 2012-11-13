package org.young.entity;

import java.util.Date;

public class User {

	private String id;
	
	private String name; // 姓名
	
	private byte gender; // 性别：0-女 1-男
	
	private Date birthday; // 出生年月
	
	public User(){}
	
	public User(String name, byte gender, Date birthday) {
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		
		return "[" + "id:" + this.id + "|"
				+ "name:" + this.name + "|"
				+ "gender:" + this.gender + "|" 
				+ "birthday:" + this.birthday + "]";
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}

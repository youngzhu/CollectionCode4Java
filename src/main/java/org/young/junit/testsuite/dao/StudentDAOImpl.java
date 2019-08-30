package org.young.junit.testsuite.dao;

import org.young.junit.testsuite.entity.Student;

public class StudentDAOImpl implements StudentDAO {

	public void add(Student stu) {
		// log
		System.out.println("--------------Add a student -------------");
	}

	public void delete(String id) {
		// log
		System.out.println("--------------Delete a student by id -------------");
	}

	public void update(Student stu) {
		// log
		System.out.println("--------------Update a student -------------");
	}

	/**
	 * 如果 id 为 null 或者 空串，则返回 null
	 * 否则，返回一个 Student 对象
	 */
	public Student load(String id) {
		// log
		System.out.println("--------------Load a student by id  ===" + id);
		
		if (null != id && !"".equals(id.trim())) {
			return new Student();
		}
		
		return null;
	}

}

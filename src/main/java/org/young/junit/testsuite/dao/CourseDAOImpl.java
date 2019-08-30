package org.young.junit.testsuite.dao;

import org.young.junit.testsuite.entity.Course;

public class CourseDAOImpl implements CourseDAO {

	public void add(Course course) {
		// log
		System.out.println("--------------Add a course -------------");
	}

	public void delete(String id) {
		// log
		System.out.println("--------------Delete a course by id -------------");
	}

	public void update(Course course) {
		// log
		System.out.println("--------------Update a course -------------");
	}

	/**
	 * 如果 id 为 null 或者 空串，则返回 null
	 * 否则，返回一个 Course 对象
	 */
	public Course load(String id) {
		// log
		System.out.println("--------------Load a course by id  ===" + id);
		
		if (null != id && !"".equals(id.trim())) {
			return new Course();
		}
		
		return null;
	}

}

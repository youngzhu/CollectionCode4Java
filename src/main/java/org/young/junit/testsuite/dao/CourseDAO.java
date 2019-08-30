package org.young.junit.testsuite.dao;

import org.young.junit.testsuite.entity.Course;

public interface CourseDAO {

	// 增
	void add(Course course);
	
	// 删
	void delete(String id);
	
	// 改
	void update(Course course);
	
	// 查
	Course load(String id);
}

package org.young.junit.testsuite.dao;

import org.young.junit.testsuite.entity.Student;

public interface StudentDAO {

	// 增
	void add(Student stu);
	
	// 删
	void delete(String id);
	
	// 改
	void update(Student stu);
	
	// 查
	Student load(String id);
}

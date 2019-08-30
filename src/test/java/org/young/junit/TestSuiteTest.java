package org.young.junit;

import static org.junit.Assert.*;
import junit.framework.TestSuite;

import org.junit.Test;

/**
 * TestSuite 的使用
 *
 * @author by Young.ZHU
 *		on 2013-9-27
 *
 * Package&FileName: org.young.junit.TestSuiteTest
 */
public class TestSuiteTest {

	@Test
	public void test() {
		TestSuite suite = new TestSuite();
		fail("Not yet implemented");
	}
	

}

interface StudentDao {
	// 增
	void addStudent(Student stu);
	
	// 删
	void deleteStudent(String id);
	
	// 改
	void updateStudent(Student stu);
	
	// 查
	void loadStudent(String id);
}

class StudentDaoImpl implements StudentDao {

	public void addStudent(Student stu) {
		// TODO Auto-generated method stub
		
	}

	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		
	}

	public void updateStudent(Student stu) {
		// TODO Auto-generated method stub
		
	}

	public void loadStudent(String id) {
		// TODO Auto-generated method stub
		
	}
	
}


class Student {
	
}
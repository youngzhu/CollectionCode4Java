package org.young.junit.testsuite;

import junit.framework.TestCase;

import org.young.junit.testsuite.dao.StudentDAO;
import org.young.junit.testsuite.dao.StudentDAOImpl;
import org.young.junit.testsuite.entity.Student;

public class StudentDAOTest extends TestCase {
	
	private StudentDAO dao;
	
	/**
	 * 创建 DAO 实例
	 */
	public void setUp() {
		dao = new StudentDAOImpl();
	}

	public void testAdd() {
		Student stu = new Student();
		
		dao.add(stu);
	}

	public void testDelete() {
		
		dao.delete("id");
	}

	public void testUpdate() {
		Student stu = new Student();
		
		dao.update(stu);
	}

	public void testLoadWithId() {
		
		Student stu = dao.load("xyz");
		
		assertNotNull(stu);
	}
	
	public void testLoadWithNullOrEmptyStr() {
		
		Student stu = dao.load("");
		assertNull(stu);
		
		stu = dao.load(null);
		assertNull(stu);
	}

}

package org.young.junit.testsuite;

import junit.framework.TestSuite;


public class AllTest {

	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite("All Test");
		
		/*
		 * StudentDAOTest 类的全部测试方法
		 */
		suite.addTest(new TestSuite(StudentDAOTest.class));
		/*
		 * CourseDAOTest 类的部分方法
		 */
		suite.addTest(CourseDAOTest.suite());
		
		return suite;
	}

}

package org.young.junit.testsuite;

import org.junit.Before;
import org.junit.Test;
import org.young.junit.testsuite.dao.CourseDAO;
import org.young.junit.testsuite.dao.CourseDAOImpl;
import org.young.junit.testsuite.entity.Course;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Suite 的实现方式一
 * 
 * 	public static Test suite(){} 的方式
 *
 * @author by Young.ZHU
 *		on 2013-9-30
 *
 * Package&FileName: org.young.junit.testsuite.CourseDAOTest
 */
public class CourseDAOTest extends TestCase {
	
	private CourseDAO dao;
	
	public CourseDAOTest() {
		super();
	}

	public CourseDAOTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		dao = new CourseDAOImpl();
	}
	
	/**
	 * 注意：继承 TestCase 后，JUnit 4 里的 @Before 、@Test 等注解就没用了
	 * 
	 * @Before 的功能可由方法 setUp() 实现
	 */
	@Before
	public void init() {
		System.out.println("fsdfsdf");
		dao = new CourseDAOImpl();
	}
	
	/**
	 * 执行这个测试类的部分方法
	 * 
	 * 方法头必须是这样的 public static junit.framework.Test suite()
	 * 即，静态（static） 的
	 * 
	 * @return
	 */
	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite();
		
		/*
		 * 字符串参数为想要执行的该测试类的方法
		 */
		suite.addTest(new CourseDAOTest("testLoad"));
		suite.addTest(new CourseDAOTest("testAdd"));
		
		return suite;
	}

	@Test
	public void testAdd() {
		Course course = new Course();
		
		dao.add(course);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoad() {
		Course course = dao.load("course_id");
		
		assertNotNull(course);
	}

}

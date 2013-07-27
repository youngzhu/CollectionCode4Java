package org.young.sh.dao;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.young.hibernate.dao.ICustomerDAO;
import org.young.hibernate.entity.Customer;

/**
 * 
 * @author by Young.ZHU
 * on 下午8:47:35 2013-7-21
 *
 * Package: org.young.sh.dao.CustomerDAOHibernateImplTest
 */
public class CustomerDAOHibernateImplTest {
	
	private ICustomerDAO customerDao;
	
	@Before
	public void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		customerDao = (ICustomerDAO) context.getBean("customerDAOHibernateImpl");
		
	}

	@Test
	public void testAdd() {
		Customer customer = new Customer();
		customer.setGender('1');
		customer.setBirthday(new Date());
		
		customerDao.add(customer);
	}
	
	@Test
	public void testLoad() {
		List<Customer> list = customerDao.load();
		
		for (Customer cst : list) {
			System.out.println(cst);
		}
	}

}

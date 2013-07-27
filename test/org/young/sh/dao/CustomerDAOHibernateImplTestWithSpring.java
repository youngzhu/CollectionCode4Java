package org.young.sh.dao;

import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.young.hibernate.dao.ICustomerDAO;
import org.young.hibernate.entity.Customer;
import org.young.log4j2.factory.LogFactory;

/**
 * 继承 AbstractTransactionalDataSourceSpringContextTests
 * 不会破坏数据现场。
 * 方法执行结束后，对数据库的操作都会回滚
 * 
 * @author by Young.ZHU
 * on 下午3:51:42 2013-7-27
 *
 * Package: org.young.sh.dao.CustomerDAOHibernateImplTestWithSpring
 */
public class CustomerDAOHibernateImplTestWithSpring extends DefaultDAOTest {
	
	private ICustomerDAO customerDao;
	
	private static final Logger logger = LogFactory.getConsoleLogger();
	
	@Test
	public void testAdd() {
		Customer customer = new Customer();
		customer.setGender('1');
		customer.setBirthday(new Date());
		
		logger.info("add Customer: " + customer);
		
		customerDao.add(customer);
	}
	
	@Test
	public void testLoad() {
	}

	public void setCustomerDao(ICustomerDAO customerDao) {
		this.customerDao = customerDao;
	}

}

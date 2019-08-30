package org.young.hibernate.service;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.young.hibernate.dao.CustomerDAOImpl;
import org.young.hibernate.dao.ICustomerDAO;
import org.young.hibernate.entity.Customer;

public class CustomerServiceTest {

	private ICustomerService service;
	private ICustomerDAO dao;
	
	@Before
	public void init() {
		service = new CustomerServiceImpl();
		dao = new CustomerDAOImpl();
		
		((CustomerServiceImpl)service).setDao(dao);
	}
	
	@Test
	public void testAdd() {
		Customer customer = new Customer();
		customer.setGender('1');
		customer.setBirthday(new Date());
		
		service.add(customer);
	}
	
	@Test
	public void testLoad() {
		
		List<Customer> list = service.load();
		
		for (Customer cst : list) {
			System.out.println(cst);
		}
	}

}

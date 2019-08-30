package org.young.hibernate.service;

import java.util.List;

import org.young.hibernate.dao.ICustomerDAO;
import org.young.hibernate.entity.Customer;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDAO dao;
	
	public void add(Customer customer) {
		
		dao.add(customer);
	}

	public ICustomerDAO getDao() {
		return dao;
	}

	public void setDao(ICustomerDAO dao) {
		this.dao = dao;
	}

	public List<Customer> load() {
		return dao.load();
	}

}

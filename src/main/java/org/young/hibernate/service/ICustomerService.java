package org.young.hibernate.service;

import java.util.List;

import org.young.hibernate.entity.Customer;

public interface ICustomerService {

	/**
	 * 添加客户
	 * 
	 * @param customer
	 */
	void add(Customer customer);

	/**
	 * 查找客户
	 * 
	 * @return 返回所有客户
	 */
	List<Customer> load();
}

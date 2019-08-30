package org.young.hibernate.dao;

import java.util.List;

import org.young.hibernate.entity.Customer;

public interface ICustomerDAO {

	/**
	 * 添加客户
	 * 
	 * @param customer
	 */
	void add(Customer customer);

	/**
	 * 查找客户
	 * 
	 * @return 返回数据库中的所有客户
	 */
	List<Customer> load();

}

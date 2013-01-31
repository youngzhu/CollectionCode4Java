package org.young.hibernate.service;

import java.util.List;

import org.young.hibernate.entity.Product;

public interface IProductService {

	void add(Product product);

	/**
	 * 返回所有的产品
	 * 
	 * @return
	 */
	List<Product> load();
}

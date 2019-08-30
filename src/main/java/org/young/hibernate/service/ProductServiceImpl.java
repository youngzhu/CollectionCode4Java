package org.young.hibernate.service;

import java.util.List;

import org.young.hibernate.dao.IProductDAO;
import org.young.hibernate.entity.Product;

public class ProductServiceImpl implements IProductService {

	private IProductDAO dao;

	public void add(Product product) {
		dao.add(product);
	}

	public IProductDAO getDao() {
		return dao;
	}

	public void setDao(IProductDAO dao) {
		this.dao = dao;
	}

	public List<Product> load() {
		return dao.load();
	}

}

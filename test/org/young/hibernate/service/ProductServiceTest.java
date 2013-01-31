package org.young.hibernate.service;

import org.junit.Before;
import org.junit.Test;
import org.young.hibernate.dao.IProductDAO;
import org.young.hibernate.dao.ProductDAOImpl;
import org.young.hibernate.entity.Product;

public class ProductServiceTest {

	private IProductService service;
	private IProductDAO dao;
	
	@Before
	public void init() {
		service = new ProductServiceImpl();
		dao = new ProductDAOImpl();
		
		((ProductServiceImpl)service).setDao(dao);
	}
	
	@Test
	public void testAdd() {
		Product product = new Product();
		
		product.setPrice(99.90);
		product.setDescription("产品说明");
		
		service.add(product);
	}

}

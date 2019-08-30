package org.young.hibernate.service;

import org.young.hibernate.dao.IOrderDAO;
import org.young.hibernate.entity.Order;

public class OrderServiceImpl implements IOrderService {

	private IOrderDAO dao;
	
	public void add(Order order) {

		dao.add(order);
	}

	public IOrderDAO getDao() {
		return dao;
	}

	public void setDao(IOrderDAO dao) {
		this.dao = dao;
	}

}

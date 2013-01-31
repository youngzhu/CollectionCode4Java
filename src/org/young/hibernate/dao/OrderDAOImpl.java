package org.young.hibernate.dao;

import org.young.hibernate.entity.Order;
import org.young.hibernate.util.HibernateUtil;

public class OrderDAOImpl extends AbstractDAO implements IOrderDAO {

	public void add(Order order) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		session.save(order);
		
		session.getTransaction().commit();
	}

}

package org.young.hibernate.dao;

import java.util.List;

import org.young.hibernate.entity.Product;
import org.young.hibernate.util.HibernateUtil;

public class ProductDAOImpl extends AbstractDAO implements IProductDAO {

	public void add(Product product) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		session.save(product);

		session.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<Product> load() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		List<Product> list = session.createQuery("from Product").list();
		session.getTransaction().commit();

		return list;
	}

}

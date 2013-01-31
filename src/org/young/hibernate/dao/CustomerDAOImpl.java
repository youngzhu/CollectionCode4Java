package org.young.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.young.hibernate.entity.Customer;
import org.young.hibernate.util.HibernateUtil;

public class CustomerDAOImpl implements ICustomerDAO {

	private Session session;
	
	public void add(Customer customer) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		session.save(customer);
		
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> load() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		List<Customer> list = session.createQuery("from Customer").list();
		session.getTransaction().commit();
		
		return list;
	}

}

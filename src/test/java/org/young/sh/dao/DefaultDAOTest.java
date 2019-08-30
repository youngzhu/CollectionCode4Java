package org.young.sh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class DefaultDAOTest extends AbstractTransactionalDataSourceSpringContextTests {
	
	private SessionFactory sessionFactory;

	@Override
	protected String[] getConfigLocations() {
		String[] configLocations = new String[]{"classpath:/applicationContext.xml"};
		
		return configLocations;
	}
	
	  
	protected void flushCurrentSession(){  
		Session session = SessionFactoryUtils.getSession(sessionFactory, false);  
	    if (null != session){  
	        session.flush();  
	    }  
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

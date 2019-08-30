package org.young.sh.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 
 * @author by Young.ZHU
 * on 下午8:42:40 2013-7-21
 *
 * Package: org.young.sh.dao.DefaultDAO
 */
public class DefaultDAO {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}

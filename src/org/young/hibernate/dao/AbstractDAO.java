package org.young.hibernate.dao;

import org.hibernate.Session;

public abstract class AbstractDAO {

	protected Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}

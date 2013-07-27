package org.young.sh.dao;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class DefaultDAOTest extends AbstractTransactionalDataSourceSpringContextTests {

	@Override
	protected String[] getConfigLocations() {
		String[] configLocations = new String[]{"classpath:/applicationContext.xml"};
		
		return configLocations;
	}
}

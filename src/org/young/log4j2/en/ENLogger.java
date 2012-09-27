package org.young.log4j2.en;

import org.young.log4j2.factory.LogFactory;
import org.young.util.CollectionUtil;

public class ENLogger {

	public void doSomething() {
		LogFactory.getENLogger().info("Log in English start ........");

		try {
			int i = Integer.valueOf("x");
		} catch (Exception e) {
			
			LogFactory.getENLogger().error(CollectionUtil.getString(e.getStackTrace()));
		}

		LogFactory.getENLogger().info("Log in English end.");
	}
}

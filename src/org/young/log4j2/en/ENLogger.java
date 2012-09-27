package org.young.log4j2.en;

import org.young.log4j2.factory.LogFactory;

public class ENLogger {

	public void doSomething() {
		LogFactory.getENLogger().info("Log in English start ........");

		try {
			int i = Integer.valueOf("x");
		} catch (Exception e) {
			LogFactory.getENLogger().error(e);
		}

		LogFactory.getENLogger().info("Log in English end.");
	}
}

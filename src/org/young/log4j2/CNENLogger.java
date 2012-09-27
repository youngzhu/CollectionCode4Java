package org.young.log4j2;

import org.young.log4j2.factory.LogFactory;

public class CNENLogger {

	public void saySomething() {
		String something = CNENLogger.class.getName();
		
		LogFactory.getCNLogger().info("我是 {}", something);
		
		LogFactory.getENLogger().info("I'm {}!!	", something);
		
		LogFactory.getConsoleLogger().info("The message is from {}	", something);
	}
}

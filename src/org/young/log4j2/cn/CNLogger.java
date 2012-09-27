package org.young.log4j2.cn;

import org.young.log4j2.factory.LogFactory;

public class CNLogger {

	public void doSomething() {
		LogFactory.getCNLogger().info("中文日志开始……");
		
		try {
			throw new NullPointerException("NullPointerException");
		} catch (Exception e) {
			LogFactory.getCNLogger().error(e);
		}
		
		LogFactory.getCNLogger().info("中文日志结束。。。");
	}
}

package org.young.log4j2.cn;

import org.young.log4j2.factory.LogFactory;
import org.young.util.CollectionUtil;

public class CNLogger {

	public void doSomething() {
		LogFactory.getCNLogger().info("中文日志开始……");
		
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			LogFactory.getCNLogger().error(CollectionUtil.getString(e.getStackTrace()));
		}
		
		LogFactory.getCNLogger().info("中文日志结束。。。");
	}
}

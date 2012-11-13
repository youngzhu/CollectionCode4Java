package org.young.proxy;

import java.lang.reflect.Method;

public class TimeLogInterceptor extends LogInterceptor {

	private long startTime;
	private long endTime; // 
	
	@Override
	public void beforeMethod(Method method) {
		startTime = System.currentTimeMillis();
		super.beforeMethod(method);
	}
	
	@Override
	public void afterMethod(Method method, Object[] args) {
		super.afterMethod(method, args);
		endTime = System.currentTimeMillis();
		System.out.println("[Log]方法-" + methodName4Log + "共耗时【 "
				+ (endTime - startTime) + "】ms");
	}
}

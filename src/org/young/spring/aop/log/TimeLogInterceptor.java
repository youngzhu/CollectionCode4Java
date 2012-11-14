package org.young.spring.aop.log;

/**
 * 
 *
 * @author by Young.ZHU
 *		on 2012-11-14
 *
 * Package&FileName: org.young.spring.aop.log.TimeLogInterceptor
 */
public class TimeLogInterceptor extends LogInterceptor {

	private long startTime;
	private long endTime; //

	@Override
	public void beforeMethod() {
		startTime = System.currentTimeMillis();
		super.beforeMethod();
	}

	@Override
	public void afterMethod() {
		super.afterMethod();
		endTime = System.currentTimeMillis();
		System.out.println("[" + super.getLogName() + "]方法-" + methodName4Log + "共耗时【 "
				+ (endTime - startTime) + "】ms");
	}

}

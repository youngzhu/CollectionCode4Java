package org.young.spring.aop.log;

import org.young.util.CollectionUtil;

/**
 * 
 *
 * @author by Young.ZHU
 *		on 2012-11-14
 *
 * Package&FileName: org.young.spring.aop.log.DefaultLogInterceptor
 */
public class DefaultLogInterceptor extends AbstractLogInterceptor {

	public void afterMethod() {

		System.out.println("[" + super.getLogName() + "] Args:" + CollectionUtil.getString(args));
		System.out.println("[" + super.getLogName() + "] Mothod-" + methodName4Log + " end.");
	}

	public void beforeMethod() {
		System.out.println("[" + super.getLogName() + "] Mothod-" + methodName4Log + " start...");
	}

}

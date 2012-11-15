package org.young.spring.aop.log;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 
 *
 * @author by Young.ZHU
 *		on 2012-11-14
 *
 * Package&FileName: org.young.spring.aop.log.LogInterceptor
 */
public abstract class AbstractLogInterceptor implements MethodInterceptor {

	private String logName;
	
	protected String methodName4Log; // 日志时记录的方法名称
	protected Object[] args; // 调用方法的参数
	
	public Object invoke(MethodInvocation method) throws Throwable {
		
//		methodName4Log = method.getThis().getClass().getCanonicalName() 
//							+ "." + method.getMethod().getName() + "(..)";
		methodName4Log = method.getThis().getClass().getName() 
							+ "." + method.getMethod().getName() + "(..)";
//		methodName4Log = method.getThis().getClass().getSimpleName() 
//							+ "." + method.getMethod().getName() + "(..)";
		
		args = method.getArguments();
		
		beforeMethod();
		Object ret = method.proceed();
		afterMethod();
		
		return ret;
	}
	
	public void afterMethod() {
	}

	public void beforeMethod() {
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

}

package org.young.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.young.util.CollectionUtil;

/**
 * 日志拦截器
 *
 * @author by Young.ZHU
 *		on 2012-11-13
 *
 * Package&FileName: org.young.proxy.LogInterceptor
 */
public class LogInterceptor implements InvocationHandler {

	private Object target; // 被代理对象
	
	protected String methodName4Log; // 日志时记录的方法名称
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		methodName4Log = target.getClass().getName() + "." + method.getName() + "(..)";
		
		beforeMethod(method);
		Object ret = method.invoke(target, args);
		
		/*
		 * proxy，代理对象本身。
		 * 	如果使用它，会使程序陷入是循环
		 */
//		System.out.println(proxy + "==============");
		
		System.out.println(target + "==============");
		afterMethod(method, args);
		
		return ret;
	}

	public void afterMethod(Method method, Object[] args) {

		System.out.println("[Log]Args:" + CollectionUtil.getString(args));
		System.out.println("[Log]Mothod-" + methodName4Log + " end.");
	}

	public void beforeMethod(Method method) {
		System.out.println("[Log]Mothod-" + methodName4Log + " start...");
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}

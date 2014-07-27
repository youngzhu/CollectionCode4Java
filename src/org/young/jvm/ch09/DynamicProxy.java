package org.young.jvm.ch09;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
	
	Object proxyObj; // 被代理的类
	
	public Object bind(Object obj) {

		this.proxyObj = obj;
		
		return Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(), proxyObj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.print("Welcom, ");
		return method.invoke(proxyObj, args);
	}

}

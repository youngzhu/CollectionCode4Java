package org.young.jvm.ch09;

import org.junit.Test;

public class DynamicProxyTest {
	
	IHello hello;

	@Test
	public void testHello() {
		hello = new Hello();
		
		hello.sayHello();
	}

	@Test
	public void testProxiedHello() {
		hello = (IHello) new DynamicProxy().bind(new Hello());
		
		hello.sayHello();
	}
}

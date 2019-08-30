package org.young.jvm.ch09;

import org.young.jvm.ch09.IHello;

public class Hello implements IHello {

	@Override
	public void sayHello() {

		System.out.println("hello world!");
	}

}

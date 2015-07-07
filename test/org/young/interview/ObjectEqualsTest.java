package org.young.interview;

import org.junit.Test;

public class ObjectEqualsTest {

	@Test
	public void testObject() {
		Object a = new Object();
		Object b = new Object();
		
		System.out.println(a.equals(b)); // false
	}
	
	@Test
	public void testString() {
		String x = new String("xyz");
		String y = new String("xyz");
		String z = "xyz";
		String zz = "xyz";
		
		System.out.println(x.equals(y)); // true
		System.out.println(x == y); // false
		
		System.out.println(x.equals(z)); // true
		System.out.println(x == z); // false
		
		System.out.println(zz.equals(z)); // true
		System.out.println(zz == z); // true
		
	}

}

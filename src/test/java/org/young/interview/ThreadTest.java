package org.young.interview;

import org.junit.Test;

public class ThreadTest {
	
	private String str1 = "ZZZZ";
	
	@Test
	public void testFinalVar() {
		
//		final String str = "test";
		/*
		 * For Java 8, it's OK .
		 * But for Java 7 or earlier, it must be declared as final
		 */
		String str = "test";
	
		(new Runnable() {
			/*
			 * 
			 *  Cannot refer to a non-final variable str inside an inner class defined in a different method
			 */
			public void run() {
				System.out.println(str);
				System.out.println(str1);
			}
		}).run();
	}
	
	@Test
	public void testA() {
		A a = new A();
		System.out.println(a.getStr());
	}
	
	@Test
	public void testB() {
		new B().setB(str1);
		
		String s = "BBBB";
		new B().setB(s);
	}
	
	class A {
		private String a;
		
		public A() {
			a = str1;
		}
		
		public String getStr() {
			return a;
		}
		
		public void setStr(String a) {
			this.a = a;
		}
	}
	
	class B {
		private String b;

		public String getB() {
			return b;
		}

		public void setB(String b) {
			this.b = b;
		}
		
	}
}

package org.young.interview;

import org.junit.Test;

public class ThreadTest {

	@Test
	public void testFinalVar() {
	
		String str = "test";
		
		(new Runnable() {
			public void run() {System.out.println(str);};
		}).run();
	}
	

}

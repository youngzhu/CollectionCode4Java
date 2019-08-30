package org.young.util;

import org.junit.Test;

public class NumberUtilTest {

	@Test
	public void test() throws Exception {
		
//		System.out.println(NumberUtil.hangeToBig(100080004.4565));
//		
//		System.out.println(NumberUtil.hangeToBig(0.4565));
		
		System.out.println(NumberUtil.getRMB(100000000010.00));
		
		System.out.println(NumberUtil.getRMB(999999999999.99));
		
		System.out.println(NumberUtil.getRMB(1999999999999.99));
	}
	
	@Test
	public void testChar2Int() {
		char c1 = '0';
		char c2 = '1';
		char c3 = '3';
		
		System.out.println(c3 - c1);
		System.out.println(c2 - c1);
		
		System.out.println((int)c1);
		System.out.println(c1);
		
	}

}

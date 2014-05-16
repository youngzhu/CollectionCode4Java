package org.young.crackingcode.ch01;

import static org.junit.Assert.*;

import org.junit.Test;

public class QA1_1Test {
	
	@Test
	public void testIsUniqueChars() {
		boolean ret1 = QA1_1.isUniqueChars("abc123@#$a");
		boolean ret2 = QA1_1.isUniqueChars("abc123@#$A");
		
		assertFalse(ret1);
		assertTrue(ret2);
	}
	
	@Test
	public void testIsUniqueChars2() {
		boolean ret1 = QA1_1.isUniqueChars2("abedfzf");
		boolean ret2 = QA1_1.isUniqueChars2("abcefxyz");
		
		assertFalse(ret1);
		assertTrue(ret2);
	}
	
	/**
	 * 测试boolean数组的初始化值。
	 * 
	 * 初始化时，为 false
	 */
	@Test
	public void testInitBooleanArr() {
		boolean[] arr = new boolean[10];
		
		for (int i = 0; i < 10 ; i++) {
			assertFalse(arr[i]);
		}
	}
}

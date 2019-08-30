package org.young.elearn.str;

import org.junit.Test;

public class StringMethodTest {

	@Test
	public void testPrintAllPosition() {
		String txt = "this is a beautifual day";
		String toFindStr = "is";
		
		StringMethod.printAllPosition(txt, toFindStr);
	}

	@Test
	public void testIsPalindrome() {
		StringMethod.isPalindrome("is si");
		StringMethod.isPalindrome("hello");
	}
	
	@Test
	public void testIsPalindrome2() {
		StringMethod.isPalindrome2("is si");
		StringMethod.isPalindrome2("hello");
	}
}

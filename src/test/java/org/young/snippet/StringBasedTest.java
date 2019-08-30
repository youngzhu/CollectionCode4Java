package org.young.snippet;


import org.junit.Assert;
import org.junit.Test;

public class StringBasedTest extends StringBased {

	@Test
	public void testReverse() {
		String str1 = "abcdefg";
		String str2 = "1234567890";
		
		Assert.assertEquals("gfedcba", StringBased.reverse(str1));
		Assert.assertEquals("0987654321", StringBased.reverse(str2));
	}

}

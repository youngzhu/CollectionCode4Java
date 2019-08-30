package org.young.util;


import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilTest {

	@Test
	public void testDoCalculate() throws Exception {
		String formula = "$0 + $1";
		
		Number val1 = new BigDecimal(100);
		Number val2 = new BigDecimal(100);
		
		
		Number result = MathUtil.doCalculate(formula, val1, val2);
		Assert.assertEquals(200, result.intValue());
		
		Assert.assertEquals(14, MathUtil.doCalculate("$0 + (($1 + $2) * $3) - $4", 5, 1, 2, 4, 3).intValue());
		Assert.assertEquals(14, MathUtil.doCalculate("$0 + ($1 + $2) * $3 - $4", 5, 1, 2, 4, 3).intValue());
		Assert.assertEquals(-3, MathUtil.doCalculate("$0 + ($1 - $2) * $3 / $4", 3, 2, 5, 6, 3).intValue());
		Assert.assertEquals(14.0, MathUtil.doCalculate("$0 + ($1 + $2) * $3 - $4", 5, 1, 2.0, 4, 3).doubleValue(), 0.01);
		Assert.assertEquals(0.01, MathUtil.doCalculate("$0 - $1", 100, 99.99).doubleValue(), 0.01);
		Assert.assertEquals(0.02, MathUtil.doCalculate("$0 - $1", 100, 99.98).doubleValue(), 0.01);
	}
	
	@Test
	public void testinfixToPostfix() {
		/*
		 * 5 + ((1 + 2) * 4) − 3
		 * to 
		 * 5 1 2 + 4 * + 3 −
		 */
//		Assert.assertEquals("helloworld", "hello world!");
		Assert.assertEquals("5 1 2 + 4 * + 3 -", MathUtil.infixToPostfix("5 + ((1 + 2) * 4) - 3"));
		Assert.assertEquals("5 1 2 + 4 * + 3 -", MathUtil.infixToPostfix("5 + (1 + 2) * 4 - 3"));
		Assert.assertEquals("3 2 5 - 6 * 3 / +", MathUtil.infixToPostfix("3 + (2-5) * 6 / 3"));
		Assert.assertEquals("a b c * + d e * f + g * +", MathUtil.infixToPostfix("a + b * c + (d * e + f ) * g"));
		
		Assert.assertEquals("5 1 2.0 + 4 * + 3 -", MathUtil.infixToPostfix("5 + (1 + 2.0) * 4 - 3"));
		
		Assert.assertEquals("100 99.99 -", MathUtil.infixToPostfix("100 - 99.99"));
		
	}
	

}

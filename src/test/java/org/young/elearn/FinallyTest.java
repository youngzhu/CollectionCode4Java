package org.young.elearn;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * finally 总是最后执行的
 * 
 * 即使try里有 return 或者 throw Exception
 *
 * @author by Young.ZHU
 *      on 2016年5月28日
 *
 * Package&FileName: org.young.elearn.FinallyTest
 */
public class FinallyTest {
	
	/**
	 * 最终抛出的异常是：ArithmeticException
	 * 
	 * 方法最终校验的也是finally里的异常
	 * 因为 ArithmeticException 是运行时异常（unchecked），所以方法可以不抛异常。
	 * 
	 * 如果finally里没有抛出这个异常，catch语句里会出现编译错误：
	 * Unhandled exception type Exception
	 * 
	 */
	@Test
	public void testException() {
		try {
			throw new FileNotFoundException();
		} catch (FileNotFoundException e) {
			throw new Exception();
		} finally {
			throw new ArithmeticException();
		}
	}

	@Test
	public void testReturn() {
		System.out.println(returnVal());
	}
	
	@Test
	public void testPrint() {
		try {
			System.out.println("try");
		} catch (Exception e) {
			System.out.println("catch");
		} finally {
			System.out.println("finally");
		}
	}
	
	/**
	 * 即使在return的情况下，finally 也会执行
	 */
	@Test
	public void testPrint2() {
		try {
			System.out.println("try");
			return ;
		} catch (Exception e) {
			System.out.println("catch");
		} finally {
			System.out.println("finally");
		}
	}
	
	private int returnVal() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}

}

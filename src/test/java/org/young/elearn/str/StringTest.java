package org.young.elearn.str;

import org.junit.Test;

public class StringTest {

	/**
	 * 直接赋值的String对象是从String pool中获取的对象
	 * 是同一个对象
	 */
	@Test
	public void test() {
		String str1 = "I am a student";
		String str2 = "I am a student";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
	}

	/**
	 * 对字符串进行操作后就不是原来的字符串了（String 是不可变的）
	 */
	@Test
	public void test1() {
		String str1 = "I am ";
		String str2 = "I am ";
		
		str1 += "a student";
		str2 += "a student";
		
		System.out.println(str1.equals(str2)); // true
		System.out.println(str1 == str2); // fasle
	}
	
	/**
	 * 跟 test1() 相比，多了 intern() 的操作
	 * 
	 * intern() 的作用就是
	 * 如果字符串对象池（String pool）有这个字符串就直接引用，
	 * 如果没有，则在对象池中创建一个。
	 */
	@Test
	public void test2() {
		String str1 = "I am ";
		String str2 = "I am ";
		
		str1 += "a student";
		str2 += "a student";
		
		str1 = str1.intern();
		str2 = str2.intern();
		
		System.out.println(str1.equals(str2)); // true
		System.out.println(str1 == str2); // true
	}
	
	@Test
	public void testString() {
		String str1 = new String("I am a student");
		String str2 = new String("I am a student");
		
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
	}
	
	@Test
	public void testString1() {
		String str1 = "I am a student";
		String str2 = new String("I am a student");
		
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
	}
}

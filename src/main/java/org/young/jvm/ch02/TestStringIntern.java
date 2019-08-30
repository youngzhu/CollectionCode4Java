package org.young.jvm.ch02;

/*
 * String.inter() 返回引用的测试
 * 
 * 
 * @author by Young.ZHU
 * 		on 2013年11月24日
 *
 * org.young.jvm.ch02.TestStringIntern.java
 */
public class TestStringIntern {
	
	/*
	 * jdk 1.6 得到两个 false
	 * jdk 1.7 得到一个 true ，一个 false
	 */
	public static void main(String[] args) {
		/*
		 * String.intern() 是一个 Native 方法。
		 * 它的作用是：如果字符串常量池中已经包含一个等于该字符串对象的字符串，
		 * 		则返回常量池中这个字符串的 String 对象；
		 * 		否则，将该 String 对象代表的字符串添加到常量池中，
		 * 			并返回该 String 对象的引用
		 */
		
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
		
	}

}

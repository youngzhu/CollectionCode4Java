package org.young.snippet;

/**
 * 基于 String 的一些代码片段
 *
 * @author by Young.ZHU
 *      on 2015年1月10日
 *
 * Package&FileName: org.young.snippet.StringBased
 */
public class StringBased {

	/**
	 * 将字符串反转
	 * 
	 * 参考自JDK源码
	 * 	java.lang.AbstractStringBuilder.reverse()
	 * 
	 * @param str
	 * @return
	 */
	public static String reverse(String str) {
		char[] charArr = str.toCharArray();
		
		int maxIndex = charArr.length - 1;
		
		for (int j = (maxIndex - 1) >> 1; j >= 0; j--) {
			char ch01 = charArr[j];
			char ch02 = charArr[maxIndex - j];
			
			charArr[j] = ch02;
			charArr[maxIndex - j] = ch01;
		}
		
		return new String(charArr);
	}
}

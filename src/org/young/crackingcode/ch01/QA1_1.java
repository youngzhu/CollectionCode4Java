package org.young.crackingcode.ch01;

/**
 * 原文：1.1 Implement an algorithm to determine if a string has all unique characters. 
 * 				What if you can not use additional data structures?
 * 
 * 译文：实现一个算法来判断一个字符串中的字符是否唯一的（即没有重复的字符串）。
 * 			不能使用额外的数据结构（即只使用基本的数据结构）。 
 *
 * @author by Young.ZHU
 *      on 2014年5月16日
 *
 * Package&FileName: org.young.crackingcode.ch01.QA1_1
 */
public class QA1_1 {

	/**
	 * 首先，你可以问面试官，构成字符串的字符集有多大？
	 * 是ASCII字符，还是只是26个字母？ 还是有更大的字符集？对于不同的情况，我们可能会有不同的解决方案。
	 * 
	 * 如果我们假设字符集是ASCII字符，那么我们可以开一个大小为256的boolean数组来表征每个字 符的出现。
	 * 数组初始化为false，
	 * 遍历一遍字符串中的字符，当bool数组对应位置的值为真， 表明该字符在之前已经出现过，即可得出该字符串中有重复字符。
	 * 否则将该位置的bool数组 值置为true。
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars(String str) {
		boolean[] isUniqueArr = new boolean[256]; // 初始化时，默认都是 false
		
		for(int i = 0; i < str.length(); i++) {
			int charVal = str.charAt(i); // 得到对应char的ASCII值
			
			//当bool数组对应位置的值为真， 表明该字符在之前已经出现过，即可得出该字符串中有重复字符
			if(isUniqueArr[charVal]) {
				return false;
			} else {
				//否则将该位置的bool数组 值置为true
				isUniqueArr[charVal] = true;
			}
		}
		
		return true;
	}
	
	/**
	 * 如果只是26个字母（a-z 或者 A-Z），可以用一个整数进行位运算得出结果。
	 * 
	 * 这个方法里用到了移位运算（<<），与运算（&），或运算（|）
	 * 
	 * 关于位运算，简单说一下：
	 * 二进制数：000001011 ，十进制：11
	 * 左移1位，变成：00010110，十进制：22
	 * 相当于，11 * 2^1
	 * 
	 * 1、左移 <<
	 * 		在数字没有溢出的前提下，对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方。
	 * 2、带符号右移 >>
	 * 		按二进制形式把所有的数字向右移动对应位数，低位移出（舍弃），高位的空位补符号位，即正数补0，负数补1
	 * 3、无符号右移 >>>
	 * 		无论正负，都在高位插入0
	 * 		对于正数来说和带符号右移相同，对于负数来说不同。
	 * 
	 * 与运算（&）：
	 *   0001 1010
	 * & 0000 0100
	 * -----------------
	 *   0000 0000
	 *   
	 * 或运算（|）
	 *   0001 1010
	 * | 0000 0100
	 * -----------------
	 *   0001 1110
	 *   
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars2(String str) {
		int checker = 0;
		
		for (int i = 0; i < str.length(); i++) {
			int charVal = str.charAt(i);
			
			if ((checker & (1 << charVal)) > 0) {
				return false;
			} else {
				checker |= 1 << charVal;
			}
		}
		return true;
	}
}

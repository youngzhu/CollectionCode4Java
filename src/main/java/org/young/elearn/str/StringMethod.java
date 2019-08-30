package org.young.elearn.str;

public class StringMethod {

	/**
	 * 找出所有的指定字符
	 * 
	 * @param txt
	 * @param toFindStr
	 */
	public static void printAllPosition(String txt, String toFindStr) {
		int count = 0;
		while (true) {
			count = txt.indexOf(toFindStr, count);
			
			if (-1 == count) {
				break;
			}
			
			System.out.println(count++);
		}
	}
	
	/**
	 * 是否是回文
	 * 
	 * @param str
	 */
	public static void isPalindrome(String str) {
		char[] arr = str.toCharArray();
		char[] newArr = new char[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[arr.length - 1 -i];
		}
		
		if (str.equals(String.valueOf(newArr))) {
			
			System.out.println("The text \"" + str + "\" is palindrome");
		} else {
			
			System.out.println("The text \"" + str + "\" is not palindrome");
		}
	}
	
	/**
	 * 是否是回文
	 * 
	 * 借用 StringBuffer 的 reverse() 方法
	 * 
	 * @param str
	 */
	public static void isPalindrome2(String str) {
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		
		if (str.equals(sb.toString())) {
			
			System.out.println("The text \"" + str + "\" is palindrome");
		} else {
			
			System.out.println("The text \"" + str + "\" is not palindrome");
		}
	}
}

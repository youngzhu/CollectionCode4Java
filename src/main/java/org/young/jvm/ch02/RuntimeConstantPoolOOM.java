package org.young.jvm.ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * 
 * @author by Young.ZHU
 * 		on 2013年11月24日
 *
 * org.young.jvm.ch02.RuntimeConstantPoolOOM.java
 */
public class RuntimeConstantPoolOOM {
	
	public static void main(String[] args) {
		// 使用 List 保持常量池的引用，避免 Full GC 回收常量池行为
		List<String> list = new ArrayList<String>();
		
		// 10M 的 PermSize 在 Integer 范围内足够产生 OOM 了
		int i = 0;
		while (true) {
			/*
			 * String.intern() 是一个 Native 方法。
			 * 它的作用是：如果字符串常量池中已经包含一个等于该字符串对象的字符串，
			 * 		则返回常量池中这个字符串的 String 对象；
			 * 		否则，将该 String 对象代表的字符串添加到常量池中，
			 * 			并返回该 String 对象的引用
			 */
			list.add(String.valueOf(i ++).intern());
		}
	}

}

package org.young.elearn.str;

import org.junit.Test;

/**
 * String 与 StringBuffer 之间的比较
 * 
 * VM Args: -Xms20m -Xmx20m
 * 运行时需要初始化内存，否则第一个内存的计算可能是负数。
 * 因为最初分配的内存很小，后面不够用时才自动扩充
 * 所以会导致开始的剩余内存反而比后来的小
 *
 * @author by Young.ZHU
 *      on 2016年5月14日
 *
 * Package&FileName: org.young.elearn.StringVSStringBuffer
 */
public class StringVSStringBuffer {

	static final int COUNTER = 100000;
	
	@Test
	public void test() {
		String str = "init str";
		StringBuffer sb = new StringBuffer(str);
		
		long start = System.currentTimeMillis();
		Runtime r = Runtime.getRuntime();
		long startMemory = r.freeMemory();
		
		for (int i = 0; i < COUNTER; i ++) {
			str += " what";
		}
		
		long end = System.currentTimeMillis();
		long endMemory = r.freeMemory();
		
		long strTime = (end - start);
		long strMemory = (startMemory - endMemory);
		
//		System.out.println("总内存：" + r.totalMemory());
//		System.out.println("最大内存：" + r.maxMemory());
		System.out.println("String 耗时：" + strTime);
//		System.out.println(startMemory);
//		System.out.println(endMemory);
		System.out.println("String 耗费内存：" + strMemory);
		
		start =end;
		startMemory = endMemory;
		
		for (int i = 0; i < COUNTER; i ++) {
			sb.append(" what");
		}
		
		end = System.currentTimeMillis();
		endMemory = r.freeMemory();
		
		long sbTime = (end - start);
		long sbMemory = (startMemory - endMemory);
		
//		System.out.println("总内存：" + r.totalMemory());
//		System.out.println("最大内存：" + r.maxMemory());
		System.out.println("StringBuffer 耗时：" + sbTime);
//		System.out.println(startMemory);
//		System.out.println(endMemory);
		System.out.println("StringBuffer 耗费内存：" + sbMemory);
		
		System.out.println("最终两个字符串是否相等：" + str.equals(sb.toString()));
		System.out.println("String 耗时是StringBuffer的 ：" + strTime / sbTime + " 倍");
		System.out.println("String 耗费内存是StringBuffer的 ：" + strMemory / sbMemory + " 倍");
		
//		System.out.println("处理器个数：" + r.availableProcessors());
	}
	
}

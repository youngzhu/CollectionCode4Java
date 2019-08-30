package org.young.jvm.ch02;

import org.young.jvm.constant.Constants;

/**
 * 新生代 Minor GC
 * 
 * minor:未成年的，次要的，二流的
 * 
 * VM 参数：-verbose:gc -Xms20M -Xmn10m -XX:+PrintGCDetails
 * 			-XX:SurvivorRatio=8
 * 
 * verbose:冗长的，详细的
 * survivor:幸存者，生还者
 * 
 * 
 * @author by Young.ZHU
 * 		on 2013年11月30日
 *
 * org.young.jvm.ch02.MinorGC.java
 */
public class MinorGC {

	public static void main(String[] args) {
		byte[] allocation1, allocation2, allocation3, allocation4;
		
		allocation1 = new byte[2 * Constants._1MB];
		allocation2 = new byte[2 * Constants._1MB];
		allocation3 = new byte[2 * Constants._1MB];
		allocation4 = new byte[4 * Constants._1MB]; // 出现一次 Minor GC
	}
}

package org.young.jvm.ch12;

/**
 * 12-1 volatile 的运算
 * 
 * volatile 变量自增运算测试
 *
 * @author by Young.ZHU
 *      on 2014年8月17日
 *
 * Package&FileName: org.young.jvm.ch12.VolatileTest
 */
public class VolatileTest {

//	public static volatile int race = 0;
	public static  int race = 0;
	
	public static void increase() {
		race ++;
	}
	
	private static final int THREADS_COUNT = 20;
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[THREADS_COUNT];
		
		for (int i = 0; i < THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						increase();
					}
				}
			});
			
			threads[i].start();
		}
		
		// 等待所有线程结束
		while (Thread.activeCount() > 1 ) {
			Thread.yield();
		}
		
		System.out.println(race);
	}
}

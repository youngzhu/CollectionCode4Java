package org.young.jvm.ch13;

import java.util.Date;
import java.util.Vector;

/**
 * 13-2 Vector 线程安全的测试
 * 
 * java.util.Vector 是一个线程安全的容器。因为它的add()，get() 等方法都是被 synchronized 修饰的。
 * 
 * 但即使这样，也不意味着调用它的时候就不需要同步手段了。
 *
 * @author by Young.ZHU
 *      on 2014年8月17日
 *
 * Package&FileName: org.young.jvm.ch13.VectorTest
 */
public class VectorTest {

	private static Vector<Integer> vector = new Vector<Integer>();
	
	/**
	 * 未在调用的时候加同步
	 */
	public static void noSynchonizedCode() {
		while (true) {
			for (int i = 0; i < 10; i++) {
				vector.add(i);
			}
			
			Thread removeThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < vector.size(); i++) {
						try {
							vector.remove(i);
						} catch (Exception e) {
							e.printStackTrace();
							
							System.exit(0);
						}
						
					}
				}
			});
			
			Thread printThread = new Thread(new Runnable() {
				@Override
				public void run() {

					for (int i = 0; i < vector.size(); i ++) {
						try {
							System.out.println(new Date() + "===" + vector.get(i));
						} catch (Exception e) {
							e.printStackTrace();
							System.exit(0);
						}
					}
				}
			});
			
			removeThread.start();
			printThread.start();
			
			// 不要产生过多线程，否则会造成系统假死
			while (Thread.activeCount() > 10);
		}
	}
	
	/**
	 * 加同步
	 */
	public static void addSynchonizedCode() {
		while (true) {
			for (int i = 0; i < 10; i++) {
				vector.add(i);
			}
			
			Thread removeThread = new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized(vector) {
						for (int i = 0; i < vector.size(); i++) {
							try {
								vector.remove(i);
							} catch (Exception e) {
								e.printStackTrace();
								
								System.exit(0);
							}
							
						}
					}
					
				}
			});
			
			Thread printThread = new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized (vector) {
						for (int i = 0; i < vector.size(); i ++) {
							try {
								System.out.println(new Date() + "===" + vector.get(i));
							} catch (Exception e) {
								e.printStackTrace();
								System.exit(0);
							}
						}
					}
					
				}
			});
			
			removeThread.start();
			printThread.start();
			
			// 不要产生过多线程，否则会造成系统假死
			while (Thread.activeCount() > 10);
		}
	}
	
	public static void main(String[] args) {
		
		addSynchonizedCode();
		
//		noSynchonizedCode();
	}
}

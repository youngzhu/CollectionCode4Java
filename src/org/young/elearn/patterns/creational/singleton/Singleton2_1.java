package org.young.elearn.patterns.creational.singleton;

/**
 * 单例模式升级版，2.1
 * 
 * Double-Checked Locking
 *
 * @author by Young.ZHU
 *      on 2016年7月3日
 *
 * Package&FileName: org.young.elearn.patterns.creational.singleton.Singleton2_0
 */
public class Singleton2_1 {

	/*
	 * volatile 的作用直接访问“主内存”，
	 * 而不是各自线程的拷贝内存
	 */
	private volatile static Singleton2_1 singleton;
	
	/*
	 * 构造函数私有化
	 */
	private Singleton2_1() {
		
	}
	
	public static Singleton2_1 getInstance() {
		// check 1
		if (null == singleton) {
			synchronized (Singleton2_1.class) {
				// check 2
				if (null == singleton) {
					singleton = new Singleton2_1();
				}
			}
		}
		return singleton;
	}
}

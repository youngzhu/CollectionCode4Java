package org.young.elearn.patterns.creational.singleton;

/**
 * 单例模式升级版，2.0
 * 
 * 用 volatile 关键字修饰变量，
 * 进而可以省略 getter 的同步锁
 *
 * @author by Young.ZHU
 *      on 2016年7月3日
 *
 * Package&FileName: org.young.elearn.patterns.creational.singleton.Singleton2_0
 */
public class Singleton2_0 {

	/*
	 * volatile 的作用直接访问“主内存”，
	 * 而不是各自线程的拷贝内存
	 */
	private volatile static Singleton2_0 singleton = new Singleton2_0();
	
	/*
	 * 构造函数私有化
	 */
	private Singleton2_0() {
		
	}
	
	public static Singleton2_0 getInstance() {
		return singleton;
	}
}

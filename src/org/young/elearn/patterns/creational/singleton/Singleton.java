package org.young.elearn.patterns.creational.singleton;

/**
 * 单例模式
 *
 * @author by Young.ZHU
 *      on 2016年7月3日
 *
 * Package&FileName: org.young.elearn.patterns.creational.singleton.Singleton
 */
public class Singleton {

	private static Singleton singleton;
	
	/*
	 * 构造函数私有化
	 */
	private Singleton() {
		
	}
	
	public static synchronized Singleton getInstance() {
		if (null == singleton) {
			singleton = new Singleton();
		}
		
		return singleton;
	}
}

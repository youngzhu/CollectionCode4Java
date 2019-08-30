package org.young.elearn.patterns.creational.factory;

/**
 * 假设的一个应用
 *
 * @author by Young.ZHU
 *      on 2016年12月24日
 *
 * Package&FileName: org.young.elearn.patterns.creational.factory.App
 */
public class App {

	public static void main(String[] args) throws Exception {

		/*
		 * 以前要想得到这个数据库对象（database），可能是各种new
		 * 换个数据库，这块都得重写
		 * 
		 * 用了工厂类之后，这块都不用改
		 * 要改的就两个地方：
		 * 1. 配置文件
		 * 2. 新增一个 IDatabase 的实现类，例如MongoDB
		 */
		IDatabase database = DatabaseFactory.getDatabase();
	}

}

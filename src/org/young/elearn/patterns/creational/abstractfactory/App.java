package org.young.elearn.patterns.creational.abstractfactory;

import org.young.elearn.patterns.creational.factory.IDatabase;

public class App {

	public static void main(String[] args) {
		/*
		 * 如果要换数据库，就要改这一行
		 */
//		AbstractDatabaseFactory databaseFactory = new OracleDatabaseFactory();
		AbstractDatabaseFactory databaseFactory = new MySQLDatabaseFactory();
		
		IDatabase database = databaseFactory.getDatabase();
	}
}

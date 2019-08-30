package org.young.elearn.patterns.creational.factory;

public class DatabaseFactory {

	public static IDatabase getDatabase() throws Exception {
		String databaseClassName = readFromConfig("database-class-name");
		IDatabase database = (IDatabase) Class.forName(databaseClassName).newInstance();
		
		return database;
	}
	
	private static String readFromConfig(String key) {
		// the config file has key-value pairs
		// For example,
		// 		database-class-name=OracleDatabase
		// return the value corresponding to the key specified
		return "XXXDataBase";
	}
}

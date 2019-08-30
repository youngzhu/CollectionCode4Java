package org.young.elearn.patterns.creational.abstractfactory;

import org.young.elearn.patterns.creational.factory.IDatabase;
import org.young.elearn.patterns.creational.factory.MySQLDatabase;

public class MySQLDatabaseFactory extends AbstractDatabaseFactory {

	@Override
	IDatabase getDatabase() {
		return new MySQLDatabase();
	}

}

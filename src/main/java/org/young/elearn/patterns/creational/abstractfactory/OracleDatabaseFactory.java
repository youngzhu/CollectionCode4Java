package org.young.elearn.patterns.creational.abstractfactory;

import org.young.elearn.patterns.creational.factory.IDatabase;
import org.young.elearn.patterns.creational.factory.OracleDatabase;

public class OracleDatabaseFactory extends AbstractDatabaseFactory {

	@Override
	IDatabase getDatabase() {
		return new OracleDatabase();
	}

}

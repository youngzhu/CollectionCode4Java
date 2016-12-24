package org.young.elearn.patterns.creational.abstractfactory;

import org.young.elearn.patterns.creational.factory.IDatabase;

public abstract class AbstractDatabaseFactory {

	abstract IDatabase getDatabase();
}

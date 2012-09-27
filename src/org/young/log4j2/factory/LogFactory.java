package org.young.log4j2.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogFactory {
	private static final String CONSOLE_LOGGER = "consoleLogger";
	private static final String CN_LOGGER = "CNLogger";
	private static final String EN_LOGGER = "ENLogger";
	
	public static Logger getCNLogger() {

		return LogManager.getLogger(CN_LOGGER);
	}

	public static Logger getENLogger() {

		return LogManager.getLogger(EN_LOGGER);
	}
	
	public static Logger getConsoleLogger() {

		return LogManager.getLogger(CONSOLE_LOGGER);
	}

}

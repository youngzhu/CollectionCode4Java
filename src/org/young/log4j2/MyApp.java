package org.young.log4j2;

import org.young.log4j2.cn.CNLogger;
import org.young.log4j2.en.ENLogger;

public class MyApp {

	public void log() {
		CNLogger cnLogger = new CNLogger();
		ENLogger enLogger = new ENLogger();
		CNENLogger cnEnLogger = new CNENLogger();
		
		cnLogger.doSomething();
		cnEnLogger.saySomething();
		enLogger.doSomething();
		
	}
}

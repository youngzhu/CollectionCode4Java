package org.young.log4j2;

import org.junit.Test;

/**
 * Log4J2
 * 注意：版本是 2
 *
 * @author by Young.ZHU
 *		on 2012-9-27
 *
 * Package&FileName: org.young.log4j2.Log4J2Test
 */
public class Log4J2Test {

	@Test
	public void test() {
		MyApp app = new MyApp();
		
		app.log();
	}

}

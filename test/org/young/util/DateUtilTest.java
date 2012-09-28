package org.young.util;

import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testAddHour() {
		Date oldDate = DateUtil.getFormatDate(null, "2012-09-27 22:00:00");
		
		Date newDate = DateUtil.addHour(31, oldDate);
		
		System.out.println(newDate);
		
		// Add from Web
	}

}

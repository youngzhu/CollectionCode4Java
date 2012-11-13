package org.young.util;

import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testAddHour() {
		Date oldDate = DateUtil.getFormatDate(null, "2012-09-27 22:00:00");
		
		Date newDate = DateUtil.addHour(31, oldDate);
		
		System.out.println(newDate);
	}
	
	@Test
	public void testAddDay() {
		// Test Now
		Date date1 = new Date();
		Date date2 = DateUtil.addDay(1, date1);
		
		System.out.println(date2);
		
		// Test
		Date date3 = DateUtil.getFormatDate(null, "2012-11-12 22:00:00");
		Date date4 = DateUtil.addDay(99, date3);
		System.out.println(date4);
	}
}

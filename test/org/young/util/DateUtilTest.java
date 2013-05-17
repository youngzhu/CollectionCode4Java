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
		Date date3 = DateUtil.getFormatDate(null, "2012-11-21 22:00:00");
		Date date4 = DateUtil.addDay(99, date3);
		System.out.println(date4);
		
		Date date5 = DateUtil.getFormatDate(null, "2013-02-19 22:00:00");
		Date date6 = DateUtil.subtractDay(99, date5);
		System.out.println(date6);
	}
	
	@Test
	public void testGetHourAndGetMinuteBySeconds() {
		
		long seconds = 1 * 60 * 60;
		seconds = 2172;
		
		System.out.println(DateUtil.getMinutesBySeconds(seconds));
		
		System.out.println(DateUtil.getHoursBySeconds(seconds));
	}
	
	@Test 
	public void testGetWeekOfYearByDate() {
		Date date = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, "2012-12-09");
		
		System.out.println(DateUtil.getWeekOfYearByDate(date));
	}
}

package org.young.util;


import org.junit.Test;

import java.util.Date;

public class EDSUtilTest extends EDSUtil {
	
	@Test
	public void testLogToEDS() throws Exception {
		Date from = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, "2020-04-06");
		String dateStr;
		
		for (int i = 0; i < 5; i++) {
			dateStr = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, from);
			System.out.println(dateStr);
			logToEDS(dateStr);
			long interval = (long)(Math.random() * 4000L);
			System.out.println(interval);
			Thread.sleep(interval);
			from = DateUtil.addDay(1, from);
		}
	}
	
	@Test
	public void testWeekReportToEDS() throws Exception {
		Date from = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, "2018-07-16");
		Date to = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, "2019-01-11");
		
		String dateStr;
		do {
			dateStr = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, from);
			System.out.println(dateStr);
			weekReportToEDS(dateStr);
			long interval = (long)(Math.random() * 4000L);
			System.out.println(interval);
			Thread.sleep(interval);
			from = DateUtil.addDay(7, from);
		} while (from.before(to));
	}

}

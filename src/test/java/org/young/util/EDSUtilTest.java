package org.young.util;


import org.junit.Test;

import java.util.Date;

public class EDSUtilTest extends EDSUtil {

	final String date = "2020-04-27";
	
	@Test
	public void testLogToEDS() throws Exception {
		Date from = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, date);
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
		weekReportToEDS(date);
	}

}

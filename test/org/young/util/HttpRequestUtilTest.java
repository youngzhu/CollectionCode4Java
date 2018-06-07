package org.young.util;


import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class HttpRequestUtilTest extends HttpRequestUtil {
	
	String url = "http://www.51wtp.com/index.php/toupiao/h5/detail";
//	String url = "http://www.51wtp.com/index.php/toupiao/toupiao/h5/dotoupiao";
	String params = "id=65507&vid=6747&from=timeline&isappinstalled=0";
//	String params = "id=75507&vid=6747";
	
	// 结果
	String url2 = "http://www.51wtp.com/index.php/toupiao/public/newdump";
	String params2 = "id=7987122635658";

	@Test
	public void testGet() throws InterruptedException {
		String s = "";
//		Random random
		
		for (int i = 10; i < 20; i ++) {
//			System.out.println(new Date());
			//发送 GET 请求
//			params = "id=65507&vid=" + (6000 + i) + "&from=timeline&isappinstalled=0";
			params = "id=" + (65500 + i) + "&vid=6747&from=timeline&isappinstalled=0";
			System.out.println(params);
	        s=HttpRequestUtil.sendGet(url, params);
	        System.out.println(s);
	        
	        
//	        s=HttpRequestUtil.sendGet(url2, params2);
//	        System.out.println(s);
	        
	        Double d = Math.random() * 3000;
	        long sleepTime = d.longValue();
	        
	        Thread.sleep(sleepTime);
		}
		
	}
	
	@Test
	public void testPost() {
		
		//发送 POST 请求
		String sr=HttpRequestUtil.sendPost(url, params);
		System.out.println(sr);
		
//		sr=HttpRequestUtil.sendPost(url2, params2);
//		System.out.println(sr);
	}
	
	@Test
	public void testSendPost() throws Exception {
		
		//发送 POST 请求
		HttpRequestUtil.sendPost(url);
	}
	
	@Test
	public void testLogToEDS() throws Exception {
		Date from = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, "2018-06-12");
		String dateStr;
		
		for (int i = 0; i < 5; i++) {
			dateStr = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, from);
			System.out.println(dateStr);
			HttpRequestUtil.logToEDS(dateStr);
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
			HttpRequestUtil.weekReportToEDS(dateStr);
			long interval = (long)(Math.random() * 4000L);
			System.out.println(interval);
			Thread.sleep(interval);
			from = DateUtil.addDay(7, from);
		} while (from.before(to));
	}

}

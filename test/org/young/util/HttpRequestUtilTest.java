package org.young.util;


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
	public void testLogToEDS() {
		HttpRequestUtil.logToEDS();
	}

}

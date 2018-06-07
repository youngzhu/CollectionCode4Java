package org.young.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpRequestUtil {
	
//	private static final String USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Mobile/14E304 MicroMessenger/6.5.8";
	private static final String USER_AGENT = "Mozilla/5.0";

    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            
            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            
         // Host: www.51wtp.com
            conn.setRequestProperty("Host", "www.51wtp.com");
//            Accept: application/json, text/javascript, */*; q=0.01
            conn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
//            X-Requested-With: XMLHttpRequest
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
//            Accept-Language: en-us
//            conn.setRequestProperty("Accept-Language", "en-us");
//            Accept-Encoding: gzip, deflate
//            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
//            Content-Type: application/x-www-form-urlencoded; charset=UTF-8
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//            Origin: http://www.51wtp.com
//            User-Agent: Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Mobile/14E304 MicroMessenger/6.5.8 NetType/4G Language/en
            conn.setRequestProperty("User-Agent", USER_AGENT);
//            Connection: keep-alive
            conn.setRequestProperty("Connection", "keep-alive");
//            Referer: http://www.51wtp.com/index.php/toupiao/h5/detail?id=65507&vid=6747&from=timeline&isappinstalled=0
            conn.setRequestProperty("Referer", "http://www.51wtp.com/index.php/toupiao/h5/detail?id=65507&vid=6747&from=timeline&isappinstalled=0");
//            Content-Length: 33
            conn.setRequestProperty("Content-Length", "28");
            
            
            // 建立实际的连接
            conn.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(
//                    conn.getInputStream()));
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "响应:" + result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", USER_AGENT);
            
            // Host: www.51wtp.com
            conn.setRequestProperty("Host", "www.51wtp.com");
//          Accept: application/json, text/javascript, */*; q=0.01
          conn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
//          X-Requested-With: XMLHttpRequest
//          conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
//          Accept-Language: en-us
//          conn.setRequestProperty("Accept-Language", "en-us");
//          Accept-Encoding: gzip, deflate
//          conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
//          Content-Type: application/x-www-form-urlencoded; charset=UTF-8
          conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//          Origin: http://www.51wtp.com
//          User-Agent: Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Mobile/14E304 MicroMessenger/6.5.8 NetType/4G Language/en
          conn.setRequestProperty("User-Agent", USER_AGENT);
//          Connection: keep-alive
          conn.setRequestProperty("Connection", "keep-alive");
//          Referer: http://www.51wtp.com/index.php/toupiao/h5/detail?id=65507&vid=6747&from=timeline&isappinstalled=0
          conn.setRequestProperty("Referer", "http://www.51wtp.com/index.php/toupiao/h5/detail?id=65507&vid=6747&from=timeline&isappinstalled=0");
//          Content-Length: 33
          conn.setRequestProperty("Content-Length", "28");
          // Cookie: Hm_lpvt_401e537b758649381849685f79feb8bc=1495154996; Hm_lvt_401e537b758649381849685f79feb8bc=1494982169,1495061456,1495071162,1495154996; PHPSESSID=ab87gtu79otk98g5alqa0780a7; acw_tc=AQAAAHehORVcpggAK9Vo3/HAJDu0zRCh
//          conn.setRequestProperty("Cookie", "Hm_lpvt_401e537b758649381849685f79feb8bc=1495154996; Hm_lvt_401e537b758649381849685f79feb8bc=1494982169,1495061456,1495071162,1495154996; PHPSESSID=ab87gtu79otk98g5alqa0780a7; acw_tc=AQAAAHehORVcpggAK9Vo3/HAJDu0zRCh");
          
      
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            
         // 获取所有响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + ":::" + map.get(key));
            }
            
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return "POST响应：" + result;
    } 
    
    public static void sendPost(String url) throws Exception {

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        //添加请求头
        post.setHeader("accept", "*/*");
        post.setHeader("connection", "Keep-Alive");
        post.setHeader("User-Agent", USER_AGENT);
        post.setHeader("Referer", "http://www.51wtp.com/index.php/toupiao/h5/detail?id=65507&vid=6747&from=timeline&isappinstalled=0");

        // id=65507&vid=6747&from=timeline&isappinstalled=0
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("id", "65507"));
        urlParameters.add(new BasicNameValuePair("vid", "6747"));
        urlParameters.add(new BasicNameValuePair("from", "timeline"));
        urlParameters.add(new BasicNameValuePair("isappinstalled", "0"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters, "utf-8"));

        System.out.println("Post parameters : " + post.getEntity());
        
        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + response.getStatusLine().getReasonPhrase());
        System.out.println("Response Code : " +
                                    response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

    }
    
    /**
     * EDS Log
     * 
     */
    public static void logToEDS(String logDate) {
    	// 先通过get获取一些隐藏参数，用作后台校验
    	Map<String, String> map = get(logDate);
    	
    	post(logDate, "AM", map);
    	post(logDate, "PM", map);
    }
    
    private static Map<String, String> get(String logDate) {
    	Map<String, String> map = new HashMap<String, String>();
    	
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL("http://eds.newtouch.cn/eds3/worklog.aspx?LogDate=" + logDate);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            
            // 设置通用的请求属性
//            		Host: eds.newtouch.cn
            conn.setRequestProperty("Host", "eds.newtouch.cn");
//            		Upgrade-Insecure-Requests: 1
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
//            		User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
//            		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//            		Referer: http://eds.newtouch.cn/eds3/NewCalendar.aspx
            conn.setRequestProperty("Referer", "http://eds.newtouch.cn/eds3/NewCalendar.aspx");
//            		Accept-Encoding: gzip, deflate
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
//            		Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7");
//            		Cookie: ASP.NET_SessionId=e32ox145snsbgn45r3yfnmnl; ActionSelect=; PersonId=12234
            conn.setRequestProperty("Cookie", "ASP.NET_SessionId=e32ox145snsbgn45r3yfnmnl; ActionSelect=; PersonId=12234");


            // 建立实际的连接
            conn.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line, str;
            int idxFrom, idxTo;
            while ((line = in.readLine()) != null) {
//                result += line;
            	if (-1 != line.indexOf("__EVENTVALIDATION")) {
            		str = line.substring(line.indexOf("__EVENTVALIDATION"));
            		idxFrom = str.indexOf("value=\"");
            		str = str.substring(idxFrom);
            		System.out.println(str);
            		idxTo = str.lastIndexOf("\"");
            		
//            		System.out.println(str.substring(7, idxTo));
            		map.put("__EVENTVALIDATION", str.substring(7, idxTo));
            	}
            	
            	if (-1 != line.indexOf("__VIEWSTATE\"")) {
            		str = line.substring(line.indexOf("__VIEWSTATE"));
            		idxFrom = str.indexOf("value=\"");
            		str = str.substring(idxFrom);
            		System.out.println("str:" + line);
            		idxTo = str.lastIndexOf("\"");
            		
            		System.out.println(str.substring(7, idxTo));
            		map.put("__VIEWSTATE", str.substring(7, idxTo));
            	}
            }
            
            System.out.println(map);
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
//        return "响应:" + result;
        System.out.println(result);
        
        return map;
    }

	private static void post(String logDate, String timeFlag, Map<String, String> paramMap) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        
        String param = "__EVENTTARGET=&__EVENTARGUMENT=&__LASTFOCUS=&__VIEWSTATE=";
        param += URLEncoder.encode(paramMap.get("__VIEWSTATE"));
        param += "&__VIEWSTATEGENERATOR=3A8BE513&__EVENTVALIDATION=";
        param += URLEncoder.encode(paramMap.get("__EVENTVALIDATION"));
        param += "&txtDate=" + logDate;
        
        String startTime = "10:00", endTime = "12:00";
        if ("PM".equals(timeFlag)) {
        	startTime = "13:00";
        	endTime = "18:00";
        }
        
        startTime = URLEncoder.encode(startTime);
        endTime = URLEncoder.encode(endTime);
        
        param += "&txtStartTime=" + startTime;
        param += "&txtEndTime=" + endTime;
        param += "&ddlProjectList=8300&hplbWorkType=0106&TextBox1=&txtMemo=coding&btnSave=+%E7%A1%AE+%E5%AE%9A+&txtnodate=" + logDate;
        param += "&txtnoStartTime=" + startTime;
        param += "&txtnoEndTime=" + endTime;
        param += "&TextBox6=&txtnoMemo=&txtCRMDate=" + logDate;
        param += "&txtCRMStartTime=" + startTime;
        param += "&txtCRMEndTime=" + endTime;
        param += "&TextBox5=&txtCRMMemo=";
        
        try {
            URL realUrl = new URL("http://eds.newtouch.cn/eds3/worklog.aspx?LogDate=" + logDate);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
//            Host: eds.newtouch.cn
            conn.setRequestProperty("Host", "eds.newtouch.cn");
//            Content-Length: 7301
//            conn.setRequestProperty("Content-Length", "7301");
//            Cache-Control: max-age=0
            conn.setRequestProperty("Cache-Control", "max-age=0");
//            Origin: http://eds.newtouch.cn
            conn.setRequestProperty("Origin", "http://eds.newtouch.cn");
//            Upgrade-Insecure-Requests: 1
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
//            Content-Type: application/x-www-form-urlencoded
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
//            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//            Referer: http://eds.newtouch.cn/eds3/worklog.aspx?LogDate=2018-06-05
            conn.setRequestProperty("Referer", "http://eds.newtouch.cn/eds3/worklog.aspx?LogDate=" + logDate);
//            Accept-Encoding: gzip, deflate
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
//            Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7");
//            Cookie: ASP.NET_SessionId=e32ox145snsbgn45r3yfnmnl; ActionSelect=; PersonId=12234
            conn.setRequestProperty("Cookie", "ASP.NET_SessionId=e32ox145snsbgn45r3yfnmnl; ActionSelect=; PersonId=12234");
            
//            conn.setRequestProperty("connection", "Keep-Alive");
            
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            System.out.println( param);
            // flush输出流的缓冲
            out.flush();
            
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
//        return "POST响应：" + result;
        System.out.println(result);
    } 
	
	
	public static void weekReportToEDS(String logDate) {

        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        
        String param = "__EVENTTARGET=submitButton&__EVENTARGUMENT=&__VIEWSTATE=%2FwEPDwUKMjE0NTI1MTkwOA8WAh4MRGVwYXJ0bWVudElEBQIzN2RkOfRVTbw%2FrUknLeGOXU44DaBFoZU%3D&__VIEWSTATEGENERATOR=F286991A&__EVENTVALIDATION=%2FwEWDAL9wPaHDQLjqP%2F%2BDQLd8ZHcCQLhovT5BALDnO%2FYDAL7u6OWDQL45bFcArmMv4wMAuqi3IQOAvKI0Y0HAoL54voCAouPw9wIQ97BtMk7wNFID0s1jIASxAkOZ6Q%3D&WeekReportDate=";
        param += logDate;
        param += "&Textplan=PPAI-943++%E4%BA%BA%E6%84%8F%E9%99%A9%E8%A1%A8%E9%87%8D%E6%9E%84%E4%BC%98%E5%8C%96%EF%BC%9A%E7%AC%AC%E4%BA%8C%E6%89%B9%E6%94%B9%E9%80%A0%EF%BC%9A%E4%BB%8Etbl_plclink%E8%8E%B7%E5%8F%96%E4%BF%9D%E5%8D%95%E5%8F%B7%E7%9A%84%E6%94%B9%E9%80%A0%E4%B8%BA%E7%9B%B4%E6%8E%A5%E4%BB%8E%E4%B8%BB%E8%A1%A8tbl_plcinfo%E8%8E%B7%E5%8F%96%EF%BC%88REQPDS-909%EF%BC%89+&Textunfinish=done&Textproblem=%E7%9F%A5%E5%85%B6%E7%84%B6%EF%BC%8C%E4%B8%8D%E7%9F%A5%E5%85%B6%E6%89%80%E4%BB%A5%E7%84%B6&Textsolution=Just+have+a+try%21%21&Textdefect=%E6%96%87%E5%AD%97%E8%A1%A8%E8%BE%BE%0D%0A%0D%0A%E4%BB%A3%E7%A0%81%E8%80%83%E8%99%91%E4%B8%8D%E5%91%A8%E5%85%A8&Textnextweek=+PPAI-980++%E8%AF%B7%E5%B0%86%E4%BA%BA%E6%84%8F%E9%99%A9%E7%B3%BB%E7%BB%9F%E7%B3%BB%E7%BB%9F%E4%B8%AD%E7%BB%9F%E4%BF%9D%E4%B8%9A%E5%8A%A1%E4%BB%A3%E7%A0%81%E4%B8%BADL006%E7%9A%84%E4%B8%9A%E5%8A%A1%E6%9B%B4%E6%94%B9%E4%B8%BA%22%E8%A7%81%E8%B4%B9%E5%87%BA%E5%8D%95%22%E4%B8%9A%E5%8A%A1%E3%80%82%EF%BC%88RPDAL-145%EF%BC%89+%0D%0A+%0D%0A+%0D%0A++%0D%0A%0D%0A%0D%0A+%0D%0A+&Textsuggestion=%E6%97%A0";
        
        try {
            URL realUrl = new URL("http://eds.newtouch.cn/eds36web/files/report/weekreport_add.aspx?HasReturn=1" + logDate);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
//            Host: eds.newtouch.cn
            conn.setRequestProperty("Host", "eds.newtouch.cn");
//            Content-Length: 7301
//            conn.setRequestProperty("Content-Length", "7301");
//            Cache-Control: max-age=0
            conn.setRequestProperty("Cache-Control", "max-age=0");
//            Origin: http://eds.newtouch.cn
            conn.setRequestProperty("Origin", "http://eds.newtouch.cn");
//            Upgrade-Insecure-Requests: 1
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
//            Content-Type: application/x-www-form-urlencoded
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
//            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//            Referer: http://eds.newtouch.cn/eds3/worklog.aspx?LogDate=2018-06-05
            conn.setRequestProperty("Referer", "http://eds.newtouch.cn/eds36web/files/report/weekreport_add.aspx?HasReturn=1");
//            Accept-Encoding: gzip, deflate
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
//            Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7");
//            Cookie: ASP.NET_SessionId=e32ox145snsbgn45r3yfnmnl; ActionSelect=; PersonId=12234
            conn.setRequestProperty("Cookie", "ASP.NET_SessionId=e32ox145snsbgn45r3yfnmnl; ActionSelect=; PersonId=12234");
            
//            conn.setRequestProperty("connection", "Keep-Alive");
            
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            System.out.println( param);
            // flush输出流的缓冲
            out.flush();
            
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
//        return "POST响应：" + result;
        System.out.println(result);
    
	}
}
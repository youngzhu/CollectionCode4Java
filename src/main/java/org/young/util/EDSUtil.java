package org.young.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class EDSUtil extends HttpRequestUtil {

    public static final String HOST = "eds.newtouch.cn";
    public static final String USET_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36";
    public static final String COOKIE = "ASP.NET_SessionId=4khtnz55xiyhbmncrzmzyzzc; ActionSelect=010601; Hm_lvt_416c770ac83a9d996d7b3793f8c4994d=1569767826; Hm_lpvt_416c770ac83a9d996d7b3793f8c4994d=1569767826; PersonId=12234";

    public static final String ACCEPT_LANGUAGE = "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7";
    public static final String ACCEPT_ENCODING = "gzip, deflate";
    private static final Map<String, String> HTTP_REQUEST_PROPERTY_GET = new HashMap<String, String>(){{
        put("Upgrade-Insecure-Requests", "1");
        put("User-Agent", USET_AGENT);
        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        put("Accept-Encoding", ACCEPT_ENCODING);
        put("Accept-Language", ACCEPT_LANGUAGE);
        put("Cookie", COOKIE);
        put("Host", HOST);
    }
    };

    private static final Map<String, String> HTTP_REQUEST_PROPERTY_POST = new HashMap<String, String>(){{
        put("Host", HOST);
        put("Content-Length", "6955");
        put("Cache-Control", "max-age=0");
        put("Origin", "http://eds.newtouch.cn");
        put("Upgrade-Insecure-Requests", "1");
        put("Content-Type", "application/x-www-form-urlencoded");
        put("User-Agent", USET_AGENT);
        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        put("Accept-Encoding", ACCEPT_ENCODING);
        put("Accept-Language", ACCEPT_LANGUAGE);
        put("Cookie", COOKIE);
    }
    };


    /**
     * EDS Log
     * 
     */
    public static void logToEDS(String logDate) throws IOException {
        String url = "http://eds.newtouch.cn/eds3/worklog.aspx?tabid=0&LogDate=" + logDate;

    	// 先通过get获取一些隐藏参数，用作后台校验
    	Map<String, String> map = get(url);
    	
    	post(url, logDate, "AM", map);
    	post(url, logDate, "PM", map);
    }
    
    private static Map<String, String> get(String url) throws IOException {
    	Map<String, String> map = new HashMap<String, String>();

    	Map<String, String> propMap = HTTP_REQUEST_PROPERTY_GET;
    	// 部分需要特殊处理的属性值
        propMap.put("Referer", url);

        BufferedReader in = sendGet(url, propMap);
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

        return map;
    }

    public void closeStream(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

	private static void post(String url, String logDate, String timeFlag, Map<String, String> paramMap) {

        String param = "__EVENTTARGET=hplbWorkType&__EVENTARGUMENT=&__LASTFOCUS=&__VIEWSTATE=";
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
        param += "&ddlProjectList=9846&hplbWorkType=0106&hplbAction=010601&TextBox1=&txtMemo=coding-testing&btnSave=+%E7%A1%AE+%E5%AE%9A+&txtnodate=" + logDate;
        param += "&txtnoStartTime=" + startTime;
        param += "&txtnoEndTime=" + endTime;
        param += "&TextBox6=&txtnoMemo=&txtCRMDate=" + logDate;
        param += "&txtCRMStartTime=" + startTime;
        param += "&txtCRMEndTime=" + endTime;
        param += "&TextBox5=&txtCRMMemo=";

        Map<String, String> propMap = HTTP_REQUEST_PROPERTY_POST;
        // 部分需要特殊处理的属性值
        propMap.put("Referer", url);

        sendPost(url, propMap, param);
        
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
            conn.setRequestProperty("Host", HOST);
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
            conn.setRequestProperty("Accept-Encoding", ACCEPT_ENCODING);
//            Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7
            conn.setRequestProperty("Accept-Language", ACCEPT_LANGUAGE);
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

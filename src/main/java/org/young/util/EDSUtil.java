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
     * 登陆
     */
    public static void login(String userId, String password) {
        final String url = "http://eds.newtouch.cn/eds3/DefaultLogin.aspx?lan=zh-cn";

        Map<String, String> propMap = HTTP_REQUEST_PROPERTY_POST;
        // 部分需要特殊处理的属性值
        propMap.put("Referer", url);

        String param = "&UserId=" + userId + "&UserPsd=" + password;
        String result = sendPost(url, propMap, param);
//        System.out.println(result);
        if (result.indexOf(userId) != -1) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登陆失败！");
        }
    }


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
        param += "&ddlProjectList=10868&hplbWorkType=0106&hplbAction=010601&TextBox1=&txtMemo=coding-testing&btnSave=+%E7%A1%AE+%E5%AE%9A+&txtnodate=" + logDate;
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
        
        String param = "__VIEWSTATE=%2FwEPDwUJMzIwMzY2NTgyD2QWAgIBD2QWCAIjDxYCHgdWaXNpYmxlaGQCJQ8WAh8AaBYCZg9kFgJmD2QWAgIDDxBkZBYAZAInDxYCHwBoZAIpDxYCHwBoZGTPTMc1nYRqbEKCiICYhOSgnUGv%2Fg%3D%3D&__VIEWSTATEGENERATOR=9F626D6E&__EVENTVALIDATION=%2FwEWCgKI1pXCBgLenYyRDwK4mtSdBQLjqP%2F%2BDQKVzZi4AgLIuY3nBALs5I6BBgKyyYHDDgL8oMWmCQLCi9reA9s3WTxWqzkDTYIVWZG%2BfybX6nyl&hidCurrRole=&hidWeeklyState=&WeekReportDate=";
        param += logDate;
        param += "&txtWorkContent=code%2Btest&txtStudyContent=refactor&txtSummary=no+pain+no+gain&txtPlanWork=wechat+message&txtPlanStudy=algorithm+&btnSubmit=%E6%8F%90%E4%BA%A4";


        try {
            final String url = "http://eds.newtouch.cn/eds36web/WorkWeekly/WorkWeeklyInfo.aspx";
            URL realUrl = new URL(url);
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
//            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
//            Content-Type: application/x-www-form-urlencoded
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
//            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//            Referer: http://eds.newtouch.cn/eds3/worklog.aspx?LogDate=2018-06-05
            conn.setRequestProperty("Referer", url);
//            Accept-Encoding: gzip, deflate
            conn.setRequestProperty("Accept-Encoding", ACCEPT_ENCODING);
//            Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7
            conn.setRequestProperty("Accept-Language", ACCEPT_LANGUAGE);
//            Cookie: ASP.NET_SessionId=e32ox145snsbgn45r3yfnmnl; ActionSelect=; PersonId=12234
            conn.setRequestProperty("Cookie", "ASP.NET_SessionId=4khtnz55xiyhbmncrzmzyzzc; ActionSelect=010601; Hm_lvt_416c770ac83a9d996d7b3793f8c4994d=1569767826; Hm_lpvt_416c770ac83a9d996d7b3793f8c4994d=1569767826; Hm_lvt_41b5c597ee994508516d3536526ea9d3=1580656307; Hm_lpvt_41b5c597ee994508516d3536526ea9d3=1580656307; PersonId=12234");
            
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

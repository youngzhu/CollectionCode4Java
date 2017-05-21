package org.young.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
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

}

package org.young.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/**
 * Java程序，使用代理连接外网
 *
 * @author by Young.ZHU
 *		on 2013-7-3
 *
 * Package&FileName: org.young.util.ProxyedURL
 */
public class ProxyedURL {
	
	private static final String PROXY_HOST = "PROXY_HOST";
	private static final String PROXY_PORT = "PROXY_PORT";
	private static final String PROXY_USERNAME = "PROXY_USERNAME";
	private static final String PROXY_PASSWORD = "PROXY_PASSWORD";
	
	private static final int PROXY_PORT_INT = 8002;

	/**
	 * System.Property 方式
	 * 
	 * url.openStream();
	 * 
	 * @param urlStr
	 */
	public void readStream(String urlStr) {
		setProxy(true);
		
		InputStream is = null;
		BufferedReader br = null;
		String line = null;
		try {
			URL url = new URL(urlStr);
			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is, "utf8"));
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Proxy类方式
	 * 
	 * 1、url.openConnection(proxy);
	 * 2、conn.getInputStream();
	 * 
	 * @param urlStr
	 */
	public void readStream2(String urlStr) {
		
		Authenticator.setDefault(new BasicAuthenticator(PROXY_USERNAME, PROXY_PASSWORD));
	    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_HOST, PROXY_PORT_INT));  
	      
		InputStream is = null;
		BufferedReader br = null;
		String line = null;
		try {
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection(proxy);
			is = conn.getInputStream();
			br = new BufferedReader(new InputStreamReader(is, "utf8"));
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * 
	 * @param isNeedAuthenticated - 是否需要用户名/密码
	 */
	private void setProxy(boolean isNeedAuthenticated) {
		System.setProperty("proxyHost", PROXY_HOST);
		System.setProperty("proxyPort", PROXY_PORT);
		
		/*
		 * FTP 协议代理（未验证）
		 */
//		System.setProperty("ftpProxyHost",PROXY_HOST);
//		System.setProperty("ftpksProxyPort",PROXY_PORT);
		
		/*
		 * Socks4代理服务器的方法：（未验证）
		 * Usually the proxy Port for Socks4 is port 1080
		 */
//		System.setProperty("socksProxyHost",PROXY_HOST);
//		System.setProperty("socksProxyPort",PROXY_PORT);

		/*
		 * 需要用户名/密码时，下面的方法是没有用的
		 * System.setProperty("proxyUser", PROXY_USERNAME);
         * System.setProperty("proxyPassword", PROXY_PASSWORD);
		 */
		
		if (isNeedAuthenticated) {
			Authenticator.setDefault(new BasicAuthenticator(PROXY_USERNAME, PROXY_PASSWORD));
		}
	}
	
	class BasicAuthenticator extends Authenticator {  
	    private String userName;  
	    private String password;  
	  
	    public BasicAuthenticator(String userName, String password) {  
	        this.userName = userName;  
	        this.password = password;  
	    }  
	  
	    /** 
	     * Called when password authorization is needed.  Subclasses should 
	     * override the default implementation, which returns null. 
	     * 
	     * @return The PasswordAuthentication collected from the 
	     *         user, or null if none is provided. 
	     */  
	    @Override  
	    protected PasswordAuthentication getPasswordAuthentication() {  
	        return new PasswordAuthentication(userName, password.toCharArray());  
	    }  
	} 

}

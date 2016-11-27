package org.young.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 进化的 DateUtil —— ThreadLocal 的另一种实现
 *
 * @author by youngz
 *      on 2016年11月27日
 *
 * Package&FileName: org.young.thread.ThreadLocalDateUtil2
 */
public class ThreadLocalDateUtil2 {

	public final static String PATTERN_YMD = "yyyy-MM-dd";
	
	private static ThreadLocal<DateFormat> formatter = new ThreadLocal<DateFormat>();
	
	public static DateFormat getDateFormat() {
		DateFormat df = formatter.get();
		
		if (null == df) {
			df = new SimpleDateFormat(PATTERN_YMD);
			formatter.set(df);
		}
		
		return df;
	}
	
	public static String getFormattedDate(Date date) {
		return getDateFormat().format(date);
	}
}

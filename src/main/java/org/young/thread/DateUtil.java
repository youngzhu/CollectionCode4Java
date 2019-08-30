package org.young.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author by youngz
 *      on 2016年11月27日
 *
 * Package&FileName: org.young.thread.DateUtil
 */
public class DateUtil {

	public final static String PATTERN_YMD = "yyyy-MM-dd";
	
	private static SimpleDateFormat formatter = new SimpleDateFormat();
	
	public static String getFormattedDate(Date date) {
		formatter.applyPattern(PATTERN_YMD);
		return formatter.format(date);
	}
}

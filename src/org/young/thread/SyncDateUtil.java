package org.young.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 进化的 DateUtil
 * 使用同步块，synchronized
 *
 * @author by youngz
 *      on 2016年11月27日
 *
 * Package&FileName: org.young.thread.SyncDateUtil
 */
public class SyncDateUtil {

	public final static String PATTERN_YMD = "yyyy-MM-dd";
	
	private static SimpleDateFormat formatter = new SimpleDateFormat();
	
	public static String getFormattedDate(Date date) {
		synchronized(formatter) {
			
			formatter.applyPattern(PATTERN_YMD);
			return formatter.format(date);
		}
	}
}

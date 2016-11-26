package org.young.thread;
import java.text.SimpleDateFormat;
import java.util.Date;


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

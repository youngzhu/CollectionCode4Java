package org.young.thread;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {

	public final static String PATTERN_YMD = "yyyy-MM-dd";
	
	private static SimpleDateFormat formatter = new SimpleDateFormat();
	
	public static String getFormattedDate(Date date) {
		formatter.applyPattern(PATTERN_YMD);
		return formatter.format(date);
	}
}

package org.young.thread;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ThreadLocalDateUtil {

	public final static String PATTERN_YMD = "yyyy-MM-dd";
	
	private static ThreadLocal<DateFormat> formatter = new ThreadLocal<DateFormat>() {
		protected DateFormat initialValue() {
			return new SimpleDateFormat(PATTERN_YMD);
		}
	};
	
	public static String getFormattedDate(Date date) {
		return formatter.get().format(date);
	}
}

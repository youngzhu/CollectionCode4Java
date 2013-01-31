package org.young.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public abstract class DateUtil {

    /** DEFAULT_PATTERN */
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    
    public static final long SECONDS_PER_MINUTE = 60L;
    
    public static final long MINUTES_PER_HOUR = 60L;

    /** DATE_MAP */
    private static final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    static {
        map.put(new Integer(1), new Integer(31));
        map.put(new Integer(2), new Integer(28));
        map.put(new Integer(3), new Integer(31));
        map.put(new Integer(4), new Integer(30));
        map.put(new Integer(5), new Integer(31));
        map.put(new Integer(6), new Integer(30));
        map.put(new Integer(7), new Integer(31));
        map.put(new Integer(8), new Integer(31));
        map.put(new Integer(9), new Integer(30));
        map.put(new Integer(10), new Integer(31));
        map.put(new Integer(11), new Integer(30));
        map.put(new Integer(12), new Integer(31));
    }

    /**
     * Simple Date
     *
     * @param date
     *
     * @return date
     */
    public static Date getSimpleDate(Date date) {
        Calendar calendar = getCalendar(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * DOCUMENT ME!
     *
     * @param timestamp DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static Date String2date(String timestamp) {
        if ((timestamp == null) || "".equals(timestamp)) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        timestamp = timestamp.substring(0, timestamp.indexOf("+"));

        Date date = null;

        try {
            date = sdf.parse(timestamp);
        } catch (ParseException e) {
        	e.printStackTrace();
        }

        return date;
    }

    /**
     * Format Date
     *
     * @param pattern
     * @param date
     *
     * @return date
     */
    public static Date getFormatDate(String pattern, String date) {
        SimpleDateFormat format = getFormat(pattern);

        if ((date == null) || "".equals(date)) {
            return null;
        }

        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    /**
     * Format Date
     *
     * @param pattern
     * @param date
     *
     * @return date
     */
    public static String getFormatDate(String pattern, Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = getFormat(pattern);

        return format.format(date);
    }

    /**
     * Format Date
     *
     * @param pattern
     * @param date
     *
     * @return date
     */
    public static Date getFormatDateToDate(String pattern, Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = getFormat(pattern);

        return getFormatDate(pattern, format.format(date));
    }

    /**
     * Format Date
     *
     * @param source pattern
     * @param target pattern
     * @param string date
     *
     * @return date
     */
    public static String getFormatDate(String source, String target,
        String string) {
        return getFormatDate(target, getFormatDate(source, string));
    }

    /**
     * Year
     *
     * @param date
     *
     * @return year
     */
    public static int getYear(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.YEAR);
    }

    /**
     * Month
     *
     * @param date
     *
     * @return month
     */
    public static int getMonth(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * Day
     *
     * @param date
     *
     * @return day
     */
    public static int getDay(Date date) {
        return getDayOfMonth(date);
    }

    /**
     * Day of Year
     *
     * @param date
     *
     * @return day
     */
    public static int getDayOfYear(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Day of Month
     *
     * @param date
     *
     * @return day
     */
    public static int getDayOfMonth(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Day of Week
     *
     * @param date
     *
     * @return day
     */
    public static int getDayOfWeek(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * Day of Week in Month
     *
     * @param date
     *
     * @return day
     */
    public static int getDayOfWeekInMonth(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    }

    /**
     * Hour
     *
     * @param date
     *
     * @return hour
     */
    public static int getHour(Date date) {
        return getHourOfDay(date);
    }

    /**
     * Hour of Half Day
     *
     * @param date
     *
     * @return hour
     */
    public static int getHourOfHalfDay(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.HOUR);
    }

    /**
     * Hour of Day
     *
     * @param date
     *
     * @return hour
     */
    public static int getHourOfDay(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Minute
     *
     * @param date
     *
     * @return minute
     */
    public static int getMinute(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.MINUTE);
    }

    /**
     * Second
     *
     * @param date
     *
     * @return second
     */
    public static int getSecond(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.SECOND);
    }

    /**
     * Millisecond
     *
     * @param date
     *
     * @return millisecond
     */
    public static int getMillisecond(Date date) {
        Calendar calendar = getCalendar(date);

        return calendar.get(Calendar.MILLISECOND);
    }

    /**
     * Difference Year ����1�꣬����һ�갴1����
     *
     * @param date1
     * @param date2
     *
     * @return year
     */
    public static long getDifferenceYear(Date date1, Date date2) {
        Date data1 = date1;
        Date data2 = date2;

        if (date1.getTime() < date2.getTime()) {
            data1 = new Date(date2.getTime());
            data2 = new Date(date1.getTime());
        }

        return (long) ((double) getAbsolutionDifferenceMonthShort(data1, data2) / 12);
    }

    /**
     * Difference Year ����1�꣬����1�쾫ȷС��
     *
     * @param date1
     * @param date2
     *
     * @return year
     */
    public static double getDifferenceYearOne(Date date1, Date date2) {
        Date data1 = date1;
        Date data2 = date2;

        if (date1.getTime() < date2.getTime()) {
            data1 = new Date(date2.getTime());
            data2 = new Date(date1.getTime());
        }

        return (double) getAbsolutionDifferenceMonth(data1, data2) / 12;
    }

    /**
     * �������������·ݣ����������������ڻ����ǰһ����������һ����
     *
     * @param date1
     * @param date2
     *
     * @return
     */
    public static long getDifferenceMonthOrDay(Date date1, Date date2) {
        // 	long month = getAbsolutionDifferenceMonth(date1, date2);//������date2���������date1������ʱ���·ּ�1
        String[] date1array = DateUtil.getFormatDate("yyyy-MM-dd", date1)
                                      .split("-");
        String[] date2array = DateUtil.getFormatDate("yyyy-MM-dd", date2)
                                      .split("-");

        Integer year1 = Integer.valueOf(date1array[0]);
        Integer year2 = Integer.valueOf(date2array[0]);
        Integer month1 = Integer.valueOf(date1array[1]);
        Integer month2 = Integer.valueOf(date2array[1]);
        Integer i_date1 = Integer.valueOf(date1array[2]);
        Integer i_date2 = Integer.valueOf(date2array[2]);
        Integer month = ((year2 - year1) * 12) + (month2 - month1);

        if (i_date2 >= i_date1) {
            month++;
        }

        if (month < 0) {
            return 0;
        }

        return month;
    }

    /**
     * ����һ�²��� Absolution Difference Month
     *
     * @param date1
     * @param date2
     *
     * @return month
     */
    public static long getAbsolutionDifferenceMonthShort(Date date1, Date date2) {
        Date data1 = date1;
        Date data2 = date2;

        if (date1.getTime() < date2.getTime()) {
            data1 = new Date(date2.getTime());
            data2 = new Date(date1.getTime());
        }

        long year = getDifferenceDate(data2, data1);
        long month = 0;

        long swap1 = getMonth(data1);
        long swap2 = getMonth(data2);
        long day1 = getDay(data1);
        long day2 = getDay(data2);
        month = ((year * 12) + swap1) - swap2;

        if (day1 < day2) {
            month--; //����һ�²���
        }

        return month;
    }

    /**
     * ����һ�°�һ�¼� Absolution Difference Month
     *
     * @param date1
     * @param date2
     *
     * @return month
     */
    public static long getAbsolutionDifferenceMonth(Date date1, Date date2) {
        Date data1 = date1;
        Date data2 = date2;

        if (date1.getTime() < date2.getTime()) {
            data1 = new Date(date2.getTime());
            data2 = new Date(date1.getTime());
        }

        long year = getDifferenceDate(data2, data1);
        long month = 0;

        long swap1 = getMonth(data1);
        long swap2 = getMonth(data2);
        long day1 = getDay(data1);
        long day2 = getDay(data2);
        month = ((year * 12) + swap1) - swap2;

        if (day1 > day2) {
            month++; //����һ�°�һ�¼�
        }

        return month;
    }

    /**
     * Relation Difference Month
     *
     * @param date1
     * @param date2
     *
     * @return month
     */
    public static long getRelationDifferenceMonth(Date date1, Date date2) {
        long year = getDifferenceDate(date2, date1);
        long month = getAbsolutionDifferenceMonth(date1, date2);

        return month - (year * 12);
    }

    /**
     * Absolution Difference Day
     *
     * @param date1
     * @param date2
     *
     * @return day
     */
    public static long getAbsolutionDifferenceDay(Date date1, Date date2) {
        return (long) ((double) getAbsolutionDifferenceHour(date1, date2) / 24);
    }

    /**
     * Relation Difference Day
     *
     * @param date1
     * @param date2
     *
     * @return day
     */
    public static long getRelationDifferenceDay(Date date1, Date date2) {
        Date data1 = date1;
        Date data2 = date2;

        if (date1.getTime() < date2.getTime()) {
            data1 = new Date(date2.getTime());
            data2 = new Date(date1.getTime());
        }

        long result = 0;

        long year = getDifferenceDate(data2, data1);
        @SuppressWarnings("unused")
		long month = 0;
        long day = getAbsolutionDifferenceDay(data1, data2);

        int swap1 = getYear(data1);
        int swap2 = getMonth(data2) + 1;

loop: 
        do {
            while (swap2 < 13) {
                Integer swap = map.get(new Integer(swap2));

                day -= swap.intValue();

                if ((((swap1 - year) % 4) == 0) && (swap2 == 2)) {
                    day--;
                }

                if (day < 0) {
                    break loop;
                }

                result = day;

                swap2++;

                month++;
            }

            swap2 = 1;

            year--;
        } while (year >= 0);

        return result;
    }

    /**
     * Absolution Difference Hour
     *
     * @param date1
     * @param date2
     *
     * @return hour
     */
    public static long getAbsolutionDifferenceHour(Date date1, Date date2) {
        return (long) ((double) getAbsolutionDifferenceMinute(date1, date2) / 60);
    }

    /**
     * Relation Difference Hour
     *
     * @param date1
     * @param date2
     *
     * @return hour
     */
    public static long getRelationDifferenceHour(Date date1, Date date2) {
        long day = getAbsolutionDifferenceDay(date1, date2);
        long hour = getAbsolutionDifferenceHour(date1, date2);

        return Math.abs(hour) - (Math.abs(day) * 24);
    }

    /**
     * Absolution Difference Minute
     *
     * @param date1
     * @param date2
     *
     * @return minute
     */
    public static long getAbsolutionDifferenceMinute(Date date1, Date date2) {
        return (long) ((double) getAbsolutionDifferenceSecond(date1, date2) / 60);
    }

    /**
     * Relation Difference Minute
     *
     * @param date1
     * @param date2
     *
     * @return minute
     */
    public static long getRelationDifferenceMinute(Date date1, Date date2) {
        long hour = getAbsolutionDifferenceHour(date1, date2);
        long minute = getAbsolutionDifferenceMinute(date1, date2);

        return minute - (hour * 60);
    }

    /**
     * Absolution Difference Second
     *
     * @param date1
     * @param date2
     *
     * @return second
     */
    public static long getAbsolutionDifferenceSecond(Date date1, Date date2) {
        return (long) ((double) getAbsolutionDifferenceMillisecond(date1, date2) / 1000);
    }

    /**
     * Relation Difference Second
     *
     * @param date1
     * @param date2
     *
     * @return second
     */
    public static long getRelationDifferenceSecond(Date date1, Date date2) {
        long minute = getAbsolutionDifferenceMinute(date1, date2);
        long second = getAbsolutionDifferenceSecond(date1, date2);

        return second - (minute * 60);
    }

    /**
     * Absolution Difference Millisecond
     *
     * @param date1
     * @param date2
     *
     * @return millisecond
     */
    public static long getAbsolutionDifferenceMillisecond(Date date1, Date date2) {
        return date1.getTime() - date2.getTime();
    }

    /**
     * Relation Difference Millisecond
     *
     * @param date1
     * @param date2
     *
     * @return millisecond
     */
    public static long getRelationDifferenceMillisecond(Date date1, Date date2) {
        long second = getAbsolutionDifferenceSecond(date1, date2);
        long millisecond = getAbsolutionDifferenceMillisecond(date1, date2);

        return millisecond - (second * 1000);
    }

    /**
     * Add Year
     *
     * @param year
     * @param date
     *
     * @return date
     */
    public static Date addYear(int year, Date date) {
        if (year > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.YEAR, year);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Add Month
     *
     * @param month
     * @param date
     *
     * @return date
     */
    public static Date addMonth(int month, Date date) {
        if (month > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.MONTH, month);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Add Day
     *
     * @param day
     * @param date
     *
     * @return date
     */
    public static Date addDay(int day, Date date) {
        if (day > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.DAY_OF_MONTH, day);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Add Hour
     *
     * @param hour
     * @param date
     *
     * @return date
     */
    public static Date addHour(int hour, Date date) {
        if (hour > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.HOUR_OF_DAY, hour);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Add Minute
     *
     * @param minute
     * @param date
     *
     * @return date
     */
    public static Date addMinute(int minute, Date date) {
        if (minute > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.MINUTE, minute);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Add Second
     *
     * @param second
     * @param date
     *
     * @return date
     */
    public static Date addSecond(int second, Date date) {
        if (second > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.SECOND, second);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Add Millisecond
     *
     * @param millisecond
     * @param date
     *
     * @return date
     */
    public static Date addMillisecond(int millisecond, Date date) {
        if (millisecond > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.MILLISECOND, millisecond);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Subtract Year
     *
     * @param year
     * @param date
     *
     * @return date
     */
    public static Date subtractYear(int year, Date date) {
        if (year > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.YEAR, -year);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Subtract Month
     *
     * @param month
     * @param date
     *
     * @return date
     */
    public static Date subtractMonth(int month, Date date) {
        if (month > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.MONTH, -month);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Subtract Day
     *
     * @param day
     * @param date
     *
     * @return date
     */
    public static Date subtractDay(int day, Date date) {
        if (day > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.DAY_OF_MONTH, -day);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Subtract Hour
     *
     * @param hour
     * @param date
     *
     * @return date
     */
    public static Date subtractHour(int hour, Date date) {
        if (hour > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.HOUR_OF_DAY, -hour);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Subtract Minute
     *
     * @param minute
     * @param date
     *
     * @return date
     */
    public static Date subtractMinute(int minute, Date date) {
        if (minute > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.MINUTE, -minute);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Subtract Second
     *
     * @param second
     * @param date
     *
     * @return date
     */
    public static Date subtractSecond(int second, Date date) {
        if (second > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.SECOND, -second);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Subtract Millisecond
     *
     * @param millisecond
     * @param date
     *
     * @return date
     */
    public static Date subtractMillisecond(int millisecond, Date date) {
        if (millisecond > 0) {
            Calendar calendar = getCalendar(date);

            calendar.add(Calendar.MILLISECOND, -millisecond);

            return calendar.getTime();
        }

        return null;
    }

    /**
     * Calendar
     *
     * @param date
     *
     * @return calendar
     */
    public static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();

        if (date == null) {
            calendar.setTime(new Date());
        } else {
            calendar.setTime(date);
        }

        return calendar;
    }

    /**
     * Calendar
     *
     * @param date
     *
     * @return calendar
     */
    public static Date getDate(Calendar date) {
        if (date != null) {
            return date.getTime();
        }

        return null;
    }

    /**
     * Format
     *
     * @param pattern
     *
     * @return format
     */
    private static SimpleDateFormat getFormat(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat();

        if ((pattern != null) && (pattern.trim().length() > 0)) {
            format.applyPattern(pattern);
        } else {
            format.applyPattern(DEFAULT_PATTERN);
        }

        return format;
    }

    /**
     * Difference Date
     *
     * @param date1
     * @param date2
     *
     * @return date
     */
    private static long getDifferenceDate(Date date1, Date date2) {
        long result = 0;

        int swap1 = getYear(date1);
        int swap2 = getYear(date2);

        while (swap1 < swap2) {
            swap1++;

            result++;
        }

        return result;
    }

    /**
     * 校验日期格式是否正确
     *
     * @param sourceDate
     *
     * @return
     */
    public static boolean checkDate(String sourceDate) {
        if (sourceDate == null) {
            return false;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(sourceDate);

            return true;
        } catch (Exception e) {
        }

        return false;
    }

    /**
     * 日期比较date1是否大于date2
     *
     * @param str1
     * @param str2
     *
     * @return
     */
    public static boolean checkDateEndUp(String str1, String str2) {
        Date date1 = DateUtil.getFormatDate("yyyy-MM-dd", str1);
        Date date2 = DateUtil.getFormatDate("yyyy-MM-dd", str2);

        if (date1.getTime() > date2.getTime()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 日期比较 date1和date2之间的间隔是否大于等于1年，满足条件返回true
     *
     * @param str1
     * @param str2
     *
     * @return
     */
    public static boolean checkYearFromTo(Date date1, Date date2) {
        if (date1.getTime() > date2.getTime()) {
            date1 = new Date(date2.getTime());
            date2 = new Date(date1.getTime());
        }

        date1 = DateUtil.addYear(1, date1);

        if (date1.getTime() > date2.getTime()) {
            return false;
        }

        return true;
    }

    /**日期删除天
     * @return
     */
    public static Date delDay(int day, Date date) {
        Calendar calendar = getCalendar(date);

        calendar.add(Calendar.DAY_OF_MONTH, day);

        return calendar.getTime();
    }
    
    public static double getMinutesBySeconds(long seconds) {
    	
    	return seconds * 1.0 / SECONDS_PER_MINUTE;
    }
    
    public static double getHoursBySeconds(long seconds) {
    	
    	return getMinutesBySeconds(seconds) / MINUTES_PER_HOUR;
    }
}

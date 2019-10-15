package cn.lianhy.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间转换类
 * @author wuzf
 */
public class DateUtil {

    private DateUtil() {
    }

    public static final String PATTERN_YMDHMS="yyyy-MM-dd HH:mm:ss";
    
    public static final String PATTERN_YMDHM="yyyy-MM-dd HH:mm";
    
    public static final String PATTERN_YMDHM2="yyyy/MM/dd HH:mm";
    
    public static final String PATTERN_yyyyMMddHHmmss="yyyyMMddHHmmss";

    public static final String PATTERN_MDYHNS="MM/dd/yyyy HH:mm:ss";

    public static final String PATTERN_YMD="yyyy-MM-dd";
    public static final String PATTERN_YM="yyyy-MM";
    
    public static final String PATTERN_YMD2="yyyy/MM/dd";

    public static final String PATTERN_YMDLINE="yyyyMMdd";
    
    public static final String PATTERN_YMDLINE2="yyMMdd";

    public static final String PATTERN_MD="MM-dd";
    
    public static final String PATTERN_MD2="MM/dd";
    
    public static final String PATTERN_MD3="MMdd";

    public static final String PATTERN_MDY="MM/dd/yyyy";

    public static final String PATTERN_HMS="HH:mm:ss";

    public static final String PATTERN_HM="HH:mm";

    public static final int INTERVAL_YEAR=0;

    public static final int INTERVAL_MONTH=1;

    public static final int INTERVAL_WEEK=2;

    public static final int INTERVAL_DATE=3;

    public static final int INTERVAL_HOUR=4;

    public static final int INTERVAL_MINUTE=5;

    public static final int INTERVAL_SECOND=6;

    public static final int INTERVAL_MILLISECOND=7;

    private static final String EX_UNKNOWN_INTERVAL_FORMAT="unknown interval format.";

    public static DateUtil getInstance() {
        return SingletonHolder.INSTANT;
    }

    public String getString() {
        return getString(new Date(), PATTERN_YMDHMS);
    }

    public String getString(String format) {
        return getString(new Date(), format);
    }

    public String getString(Date dt) {
        return getString(dt, PATTERN_YMDHMS);
    }
    
    public String getYMDHMSString(String date) {
        return getString(getDateObj(date));
    }

    public String getString(Date dt, String format) {
        try {
            if(format == null || format.length() < 1) {
                format=PATTERN_YMDHMS;
            }
            return new SimpleDateFormat(format).format(dt);
        } catch(Exception e) {
            return null;
        }
    }
    
    public String PATTERN_MD2(String date) throws ParseException {
        return PATTERN_MD2(getDateObj(date));
    }
    
    public String PATTERN_MD2(Date date) throws ParseException {
        return getString(date, PATTERN_MD2);
    }
    public String PATTERN_YM(String date) throws ParseException {
        return PATTERN_MD2(getDateObj(date));
    }
    
    public String PATTERN_YM(Date date) throws ParseException {
        return getString(date, PATTERN_YM);
    }
    /**
     * format a date String by the pattern of PATTERN_YMD.
     * @param date the date String to be formatted.
     * @return date String.
     * @throws ParseException failed to parse.
     */
    public String getYMD(String date) throws ParseException {
        return getYMD(getDateObj(date));
    }

    public String getYMD(Date date) throws ParseException {
        return getString(date, PATTERN_YMD);
    }

    /**
     * format a date String by the pattern of PATTERN_YMDLINE.
     * @param date the date String to be formatted.
     * @return date String.
     * @throws ParseException failed to parse.
     */
    public String getYMDLINE(String date) throws ParseException {
        return getYMDLINE(getDateObj(date));
    }

    public String getYMDLINE(Date date) throws ParseException {
        return getString(date, PATTERN_YMDLINE);
    }

    /**
     * format a time String by the pattern of PATTERN_HNS.
     * @param date the date String to be formatted.
     * @return time String.
     * @throws ParseException failed to parse.
     */
    public String getHMS(String date) throws ParseException {
        return getHMS(getDateObj(date));
    }

    public String getHMS(Date date) throws ParseException {
        return getString(date, PATTERN_HMS);
    }
    
    public String getYMDHMS(String date) throws ParseException {
        return getYMDHMS(getDateObj(date));
    }

    public String getYMDHMS(Date date) throws ParseException {
        return getString(date, PATTERN_yyyyMMddHHmmss);
    }

    /**
     * get current date String under the default pattern(PATTERN_YMDHNS).
     * @return now.
     */
    public String getNow() {
        return getString(new Date());
    }
    
    public long getNowTime() {
        return new Date().getTime();
    }

    /**
       * 
       */
    /**
     * add up two date objects.
     * @param dt1 date to add.
     * @param dt2 date to be added on.
     * @return a new Date object.
     */
    public Date addDate(Date dt1, Date dt2) {
        long dt1ms=dt1.getTime();
        long dt2ms=dt2.getTime();
        return new Date(dt1ms + dt2ms);
    }

    /**
     * add a duration to an existing Date object.
     * @param dt the Date object.
     * @param year years to be added on.
     * @param month months to be added on.
     * @return a new Date object.
     */
    public Date addDuration(Date dt, int year, int month) {
        Date result=dt;
        result=addMonth(result, month);
        result=addYear(result, year);
        return result;
    }

    /**
     * add a duration to an existing Date object.
     * @param dt the Date object.
     * @param year years to be added on.
     * @param month months to be added on.
     * @param day days to be added on.
     * @return a new Date object.
     */
    public Date addDuration(Date dt, int year, int month, int day) {
        dt=addDay(dt, day);
        dt=addMonth(dt, month);
        dt=addYear(dt, year);
        return dt;
    }

    /**
     * add a duration to an existing Date object.
     * @param dt the Date object.
     * @param year years to be added on.
     * @param month months to be added on.
     * @param day days to be added on.
     * @param hour hours to be added on.
     * @return a new Date object.
     */
    public Date addDuration(Date dt, int year, int month, int day, int hour) {
        dt=addHour(dt, hour);
        dt=addDay(dt, day);
        dt=addMonth(dt, month);
        dt=addYear(dt, year);
        return dt;
    }

    /**
     * add a duration to an existing Date object.
     * @param dt the Date object.
     * @param year years to be added on.
     * @param month months to be added on.
     * @param day days to be added on.
     * @param hour hours to be added on.
     * @param minute minutes to be added on.
     * @return a new Date object.
     */
    public Date addDuration(Date dt, int year, int month, int day, int hour, int minute) {
        dt=addMinute(dt, minute);
        dt=addHour(dt, hour);
        dt=addDay(dt, day);
        dt=addMonth(dt, month);
        dt=addYear(dt, year);
        return dt;
    }

    /**
     * add a duration to an existing Date object.
     * @param dt the Date object.
     * @param year years to be added on.
     * @param month months to be added on.
     * @param day days to be added on.
     * @param hour hours to be added on.
     * @param minute minutes to be added on.
     * @param second seconds to be added on.
     * @return a new Date object.
     */
    public Date addDuration(Date dt, int year, int month, int day, int hour, int minute, int second) {
        dt=addSecond(dt, second);
        dt=addMinute(dt, minute);
        dt=addHour(dt, hour);
        dt=addDay(dt, day);
        dt=addMonth(dt, month);
        dt=addYear(dt, year);
        return dt;
    }

    /**
     * add seconds to an existing Date object.
     * @param dt the Date object.
     * @param seconds seconds to be added on.
     * @return a new Date object.
     */
    public Date addSecond(Date dt, long seconds) {
        long dtms=dt.getTime();
        long secms=seconds * 1000L;
        long newdtms=dtms + secms;
        return new Date(newdtms);
    }

    /**
     * add minutes to an existing Date object.
     * @param dt the Date object.
     * @param minutes minutes to be added on.
     * @return a new Date object.
     */
    public Date addMinute(Date dt, long minutes) {
        long dtms=dt.getTime();
        long minms=minutes * 60L * 1000L;
        long newdtms=dtms + minms;
        return new Date(newdtms);
    }

    /**
     * add hours to an existing Date object.
     * @param dt the Date object.
     * @param hours hours to be added on.
     * @return a new Date object.
     */
    public Date addHour(Date dt, long hours) {
        long dtms=dt.getTime();
        long hrms=hours * 60L * 60L * 1000L;
        long newdtms=dtms + hrms;
        return new Date(newdtms);
    }

    /**
     * add days to an exsiting Date object.
     * @param dt the Date object.
     * @param days days to be added on.
     * @return a new Date object.
     */
    public Date addDay(Date dt, int days) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(dt);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * add months to an existing Date object.
     * @param dt the Date object.
     * @param months months to be added on.
     * @return a new Date object.
     */
    public Date addMonth(Date dt, int months) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(dt);
        int month=cal.get(Calendar.MONTH);
        month+=months;
        int year=month / 12;
        month%=12;
        cal.set(Calendar.MONTH, month);
        if(year != 0) {
            int oldYear=cal.get(Calendar.YEAR);
            cal.set(Calendar.YEAR, year + oldYear);
        }
        return cal.getTime();
    }

    /**
     * add years to an existing Date object.
     * @param dt the Date object.
     * @param years years to be added on.
     * @return a new Date object.
     */
    public Date addYear(Date dt, int years) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(dt);
        int oldyear=cal.get(Calendar.YEAR);
        cal.set(Calendar.YEAR, years + oldyear);
        return cal.getTime();
    }

    public Date getDayOffset(Date d, int dayOffset) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(d);
        int td=cal.get(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, td + dayOffset);
        Date dateOffset=cal.getTime();
        // System.out.println(dateTimeToString(tmd,null)+" "+dateTimeToString(ysd,null));
        return dateOffset;
    }

    /**
     * 获取时间差(天-毫秒)
     * @param date
     * @param offset
     * @param interval_format
     * @return
     */
    public long getDateBetween(Date date1, Date date2, int interval_format) {
        try {
            long between=(date1.getTime()-date2.getTime());//除以1000是为了转换成秒   
            if(interval_format == INTERVAL_DATE)
                return between/(24*3600)/1000; 
            else if(interval_format == INTERVAL_HOUR)
                return between%(24*3600)/3600/1000;
            else if(interval_format == INTERVAL_MINUTE)
                return between%3600/60/1000;
            else if(interval_format == INTERVAL_SECOND)
                return between%60/60/1000;
            if(interval_format == INTERVAL_MILLISECOND)
                return between;
            else return -1;
        } catch(Exception e) {
            return -1;
        }
    }

    /**
     * @param date
     * @param offset
     * @param interval_format
     * @return
     */
    public Date getDateOffset(Date date, int offset, int interval_format) {
        try {
            int adjustInt=Calendar.DAY_OF_YEAR;
            if(interval_format == INTERVAL_YEAR)
                adjustInt=Calendar.YEAR;
            else if(interval_format == INTERVAL_MONTH)
                adjustInt=Calendar.MONTH;
            else if(interval_format == INTERVAL_WEEK)
                adjustInt=Calendar.WEEK_OF_YEAR;
            else if(interval_format == INTERVAL_DATE)
                adjustInt=Calendar.DAY_OF_YEAR;
            else if(interval_format == INTERVAL_HOUR)
                adjustInt=Calendar.HOUR_OF_DAY;
            else if(interval_format == INTERVAL_MINUTE)
                adjustInt=Calendar.MINUTE;
            else if(interval_format == INTERVAL_SECOND)
                adjustInt=Calendar.SECOND;
            if(interval_format == INTERVAL_MILLISECOND)
                adjustInt=Calendar.MILLISECOND;
            Calendar cal=Calendar.getInstance();
            if(date != null)
                cal.setTime(date);
            cal.add(adjustInt, offset);
            return cal.getTime();
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * @param date
     * @param format
     * @param offset
     * @param interval_format
     * @return
     */
    public String getDateStringOffset(Date date, String format, int offset, int interval_format) {
        try {
            Date dt=getDateOffset(date, offset, interval_format);
            if(dt == null) {
                return null;
            }
            return getString(dt, format);
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * @return Date
     */
    public Date stringToDate(String str, String formatStr) {
        try {
            if(formatStr == null || formatStr.length() < 1)
                formatStr="yyyy-MM-dd";
            SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
            Date date=sdf.parse(str);
            return date;
        } catch(Exception e) {
            return null;
        }
    }

    public int getYear(Date dt) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(dt);
        int yr=cal.get(Calendar.YEAR);
        int era=cal.get(Calendar.ERA);
        if(era == GregorianCalendar.BC) {
            return -1 * yr;
        } else {
            return yr;
        }
    }

    /**
     * get the month of a Date object. e.g., when we take '2003-7-5 18:23:15' as input parameter, we will get '7' as result.
     * @param dt the Date object.
     * @return the month.
     */
    public int getMonth(Date dt) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(dt);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * get the weekday of a Date object.
     * @param dt the Date object.
     * @return the weekday.
     */
    public int getWeekDay(Date dt) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(dt);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * get the date of a Date object. for example, when we take '2003-7-5 18:23:15' as input parameter, we will get '5' as result.
     * @param dt the Date object.
     * @return the date.
     */
    public int getDay(Date dt) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(dt);
        return cal.get(Calendar.DATE);
    }

    /**
     * get the hour of a Date object. for example, when we take '2003-7-5 18:23:15' as input parameter, we will get '18' as result.
     * @param dt the Date object.
     * @return the hour.
     */
    public int getHour(Date dt) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(dt);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * get the minute of a Date object. for example, when we take '2003-7-5 18:23:15' as input parameter, we will get '23' as result.
     * @param dt the Date object.
     * @return the minute.
     */
    public int getMinute(Date dt) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(dt);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * get the second of a Date object. for example, when we take '2003-7-5 18:23:15' as input parameter, we will get '15' as result.
     * @param dt the Date object.
     * @return the second.
     */
    public int getSecond(Date dt) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(dt);
        return cal.get(Calendar.SECOND);
    }

    /**
     * get the year of a date String.
     * @param date the date String.
     * @return the year.
     * @throws ParseException failed to parse.
     */
    public int getYear(String date) throws ParseException {
        return getYear(getDateObj(date));
    }

    /**
     * get the month of a date String.
     * @param date the date String.
     * @return the month.
     * @throws ParseException failed to parse.
     */
    public int getMonth(String date) throws ParseException {
        return getMonth(getDateObj(date));
    }

    /**
     * get the date of a date String.
     * @param date the date String.
     * @return the date.
     * @throws ParseException failed to parse.
     */
    public int getDay(String date) throws ParseException {
        return getDay(getDateObj(date));
    }

    /**
     * get the weekday of a date String.
     * @param date the date String.
     * @return the weekday.
     * @throws ParseException failed to parse.
     */
    public int getWeekDay(String date) throws ParseException {
        return getWeekDay(getDateObj(date));
    }

    /**
     * get the hour of a date String.
     * @param date the date String.
     * @return the hour.
     * @throws ParseException failed to parse.
     */
    public int getHour(String date) throws ParseException {
        return getHour(getDateObj(date));
    }

    /**
     * get the minute of a date String.
     * @param date the date String.
     * @return the minute.
     * @throws ParseException failed to parse.
     */
    public int getMinute(String date) throws ParseException {
        return getMinute(getDateObj(date));
    }

    /**
     * get the second of a date String.
     * @param date the date String.
     * @return the second.
     * @throws ParseException failed to parse.
     */
    public int getSecond(String date) throws ParseException {
        return getSecond(getDateObj(date));
    }

    /**
     * parsing a String into a Date object under default pattern(PATTERN_MDYHNS or PATTERN_YMDHNS, depends on the string).
     * @param s the String. could be the format of 'yyyy-MM-dd HH-mm-ss' or 'MM/dd/yyyy HH-mm-ss'.
     * @return a Date object.
     * @throws ParseException failed to parse.
     */
    public Date getDateObj(String s) {
        try {
            return getDateObj(s, PATTERN_YMDHMS);
        } catch(ParseException ex) {
            try {
                return getDateObj(s, PATTERN_MDYHNS);
            } catch(ParseException ex1) {
                try {
                    return getDateObj(s, PATTERN_YMD);
                } catch(ParseException ex2) {
                    try {
                        return getDateObj(s, PATTERN_MDY);
                    } catch(ParseException ex3) {
                        try {
                            return getDateObj(s, PATTERN_yyyyMMddHHmmss);
                        } catch(ParseException ex4) {
                            return null;
                        }
                    }
                }
            }
        }
    }

    /**
     * parsing a String into a Date object under the pattern specified by user.
     * @param s the String.
     * @param pattern the pattern.
     * @return a Date object.
     * @throws ParseException failed to parse.
     */
    public Date getDateObj(String s, String pattern) throws ParseException {
        SimpleDateFormat formatter=new SimpleDateFormat(pattern);
        Date theDate=formatter.parse(s);
        return theDate;
    }

    /**
     * indicate whether or not a year is a leapyear.
     * @param year the year.
     * @return yes or no.
     */
    public boolean isLeapyear(int year) {
        boolean div4=year % 4 == 0;
        boolean div100=year % 100 == 0;
        boolean div400=year % 400 == 0;
        return div4 && (!div100 || div400);
    }

    /**
     * subtract two Date objects with specified interval.
     * @param interval the interval. could be year, month, week, day, hour, minute, second and millisecond.
     * @param dt1 the Date object to be subtracted from.
     * @param dt2 the Date object to be subtracted.
     * @return the difference.
     */
    public long diffDate(int interval, Date dt1, Date dt2) {
        long time1, time2;
        Calendar cal=Calendar.getInstance();
        int offset=cal.getTimeZone().getRawOffset();
        time1=dt1.getTime() + offset;
        time2=dt2.getTime() + offset;
        switch(interval) {
            case INTERVAL_YEAR:
                return getYear(dt1) - getYear(dt2);
            case INTERVAL_MONTH:
                return (getYear(dt1) - getYear(dt2)) * 12 + (getMonth(dt1) - getMonth(dt2));
            case INTERVAL_WEEK:
                int weekDay1=getWeekDay(dt1);
                int weekDay2=getWeekDay(dt2);
                Date week1Start=addDay(dt1, -1 * weekDay1);
                Date week2Start=addDay(dt2, -1 * weekDay2);
                return diffDate(INTERVAL_DATE, week1Start, week2Start) / 7;
            case INTERVAL_DATE:
                return time1 / (1000 * 60 * 60 * 24) - time2 / (1000 * 60 * 60 * 24);
            case INTERVAL_HOUR:
                return time1 / (1000 * 60 * 60) - time2 / (1000 * 60 * 60);
            case INTERVAL_MINUTE:
                return time1 / (1000 * 60) - time2 / (1000 * 60);
            case INTERVAL_SECOND:
                return time1 / (1000) - time2 / (1000);
            case INTERVAL_MILLISECOND:
                return dt1.getTime() - dt2.getTime();
            default:
                throw new IllegalArgumentException(new StringBuffer("cn.xb.portal.comm.utils.diffDate(): ").append(EX_UNKNOWN_INTERVAL_FORMAT).toString());
        }
    }

    private static class SingletonHolder {

        private final static DateUtil INSTANT=new DateUtil();
    }
    //字符串转化为时间戳
    public static String getTime(String user_time) {  
    	String re_time = null;  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
    	Date d;  
    	try { 
    	  
    	d = sdf.parse(user_time);  
    	long l = d.getTime();  
    	String str = String.valueOf(l);  
    	re_time = str.substring(0, 10);  
    	} catch (ParseException e) {  
    	// TODO Auto-generated catch block  
    	e.printStackTrace();  
    	}  
    	return re_time;  
    	}  
    //时间戳转换成时间字符串
    public static String getStrTime(String cc_time) {  
    	String re_StrTime = null; 
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
    	// 例如：cc_time=1291778220  
    	long lcc_time = Long.valueOf(cc_time);  
    	re_StrTime = sdf.format(new Date(lcc_time * 1000L)); 
    	return re_StrTime; 
    	}  
    //比较时间大小
    public int compareDate(Date d1,Date d2){
        if (d1.getTime() > d2.getTime()) {
//            System.out.println("dt1在dt2前");
            return 1;
        } else if (d1.getTime() < d2.getTime()) {
//            System.out.println("dt1在dt2后");
            return -1;
        } else {//相等
            return 0;
        }
     }

    public static String getTime(String user_time,String type) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d;
        try {
            d = sdf.parse(user_time);
            long l = d.getTime();
            String str = String.valueOf(l);
            if("1".equals(type)){
                re_time = str.substring(0, 10);
            }else{
                re_time=str;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return re_time;
    }

    //时间戳转换成时间字符串
    public static String getStrTime(String cc_time,String formatStr) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    public String getCronExpression(String date){
        String CronExpression = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN_YMDHM);
        try {
            Date dates = simpleDateFormat.parse(date);
            SimpleDateFormat year = new SimpleDateFormat("yyyy");
            String years = year.format(dates);
            SimpleDateFormat M = new SimpleDateFormat("MM");
            String moth = M.format(dates);
            SimpleDateFormat day = new SimpleDateFormat("dd");
            String days = day.format(dates);
            SimpleDateFormat hour = new SimpleDateFormat("HH");
            String hors = hour.format(dates);
            SimpleDateFormat mi = new SimpleDateFormat("mm");
            String mis = mi.format(dates);
            CronExpression = "0 " + mis + " " + hors + " " + days + " " + moth + " ? " + years;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return CronExpression;
    }
}

package com.spdb.common;

import java.sql.Date;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 * 
 */
public class strToDate {






    /**
     * 字符串转日期，字符串格式：yyyy-mm-dd  hh:mm:ss
     * 
     * @param strDate
     * @return
     * @throws Exception
     */
    public static java.sql.Date strToDate(String strDate) {
	String str = strDate;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date d = null;
	try {
	    d = format.parse(str);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	java.sql.Date date = new java.sql.Date(d.getTime());
	return date;
    }
    
    
    
    /**
     * 返回util日期格式的
     * @param strDate
     * @return
     */
    public static java.util.Date strToUtilDate(String strDate) {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     ParsePosition pos = new ParsePosition(0);
	     java.util.Date    strtodate = formatter.parse(strDate, pos);
	     return strtodate;
    }


    /**
    * @Descript: 返回util时间 自定义时间格式
    * @Author: junwei
    * @Date:11:15 2019/4/26
    */
	public static java.util.Date strToUtilDate(String strDate,String format) {
		if (format == null) {
			format="yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		ParsePosition pos = new ParsePosition(0);
		java.util.Date    strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
    
    
    /**
     * 字符串转日期，字符串格式：yyyy-mm-dd
     * 
     * @param strDate
     * @return
     * @throws Exception
     */
    public static java.sql.Date strToDate_Day(String strDate) {
	String str = strDate;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date d = null;
	try {
	    d = format.parse(str);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	java.sql.Date date = new java.sql.Date(d.getTime());
	return date;
    }
    

    /**
     * 字符串转日期，字符串格式：yyyy-mm-dd hh:mm:ss
     * 
     * @param strDate
     *            --Timestamp
     * @return Timestamp
     * 2018-07-21 12:00:00---2018-07-21 00:00:00.0
     * @throws Exception
     */
    public static java.sql.Timestamp strToDate2(String strDate) {
	String str = strDate;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date d = null;
	try {
	    d = format.parse(str);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	java.sql.Timestamp date = new java.sql.Timestamp(d.getTime());
	return date;
    }

    /**
     * 日期转字符串，字符串格式：yyyy-mm-dd
     * 
     * @param pojo
     * @return
     * @throws Exception
     */
    public static String dateToStr(Object date) {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String timeStr = df.format(date);
	return timeStr;
    }

    /**
     * 字符串转日期，字符串格式：yyyyMMdd
     * 
     * @param pojo
     * @return
     * @throws Exception
     */
    public static String dateToStr2(Object date) {
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	String timeStr = df.format(date);
	return timeStr;
    }

    /**
     * 日期转字符串，字符串格式：yyyyMMdd
     * 
     * @param pojo
     * @return
     * @throws Exception
     */
    public static String dateToStr3(Date date) {
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	String timeStr = df.format(date);
	return timeStr;
    }

    /**
     * 时间字符串转 时间戳 'yyyy-mm-dd'
     * 
     */
    public static String dateToStamp(String s) throws ParseException {
	String res;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date date = simpleDateFormat.parse(s);
	long ts = date.getTime();
	res = String.valueOf(ts);
	return res;
    }

    /**
     * 时间字符串转 时间戳 "yyyy-MM-dd HH:mm:ss"
     * 
     * @param s
     * @return
     * @throws ParseException
     */
    public static String dateToStamp2(String s) throws ParseException {
	String res;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date date = simpleDateFormat.parse(s);
	long ts = date.getTime();
	res = String.valueOf(ts);
	return res;
    }
    /*
     * 格式化日期  yyyy-MM-dd HH:mm:ss
     * */
    public static String dateToLongStr(Date date) throws ParseException {   	
   	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   	String s= simpleDateFormat.format(date);   	
   	return s;
       }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
	String res;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	long lt = new Long(s);
	Date date = new Date(lt);
	res = simpleDateFormat.format(date);
	return res;
    }

    
	/**
	 * 获取前几天
	 * @param now2   时间
	 * @param day 天数
	 * @return
	 */
	public static String getDateBefore(java.util.Date now2,int day){
		   Calendar now =Calendar.getInstance();
		   now.setTime(now2);
		   now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
		   return strToDate.dateToStr(now.getTime());
	}

    
    
    
    
    
    /*
     * 获取天粒度、周粒度，月粒度日期,解决跨年，跨月的周的计算错误问题，廖，勿动
     * granularity：day、week、month
     * 返回参数Map含四个值
     * 示例周粒度，传入参数 granularity=week,currentDate=2018-07-20
     * thisDateStart：2018-07-16 00:00:00
     * thisDateEnd： 2018-07-22 23:59:59
     * upDateStart： 2018-07-09 00:00:00
     * upDateEnd：   2018-07-15 23:59:59
     * */
    public static Map<String, Object> getDateTime(String granularity, java.util.Date currentDate) {
	String thisDateStart = "";
	String thisDateEnd = "";
	String upDateStart = "";
	String upDateEnd = "";
	String curentDateString = strToDate.dateToStr(currentDate);
	String upDateString = "";
	if (granularity.equals("day")) {// 粒度：日
	    Calendar c = Calendar.getInstance();
	    c.setTime(currentDate);
	    c.add(Calendar.DATE, -1);// 今天+1天
	    upDateString = strToDate.dateToStr(c.getTime());
	    curentDateString = strToDate.dateToStr(currentDate);
	    thisDateStart = curentDateString + " 00:00:00";
	    thisDateEnd = curentDateString + " 23:59:59";
	    upDateStart = upDateString + " 00:00:00";
	    upDateEnd = upDateString + " 23:59:59";

	} else if (granularity.equals("week")) {// 粒度：周
	    Calendar c = Calendar.getInstance();
	    java.util.Date thisWeekMondayDate = getThisWeekMonday(currentDate);
	    thisDateStart = strToDate.dateToStr(thisWeekMondayDate) + " 00:00:00";
	    c.setTime(thisWeekMondayDate);
	    c.add(Calendar.DAY_OF_YEAR, 6);// 周一加七天
	    thisDateEnd = strToDate.dateToStr(c.getTime()) + " 23:59:59";

	    c.setTime(currentDate);
	    c.add(Calendar.WEEK_OF_YEAR, -1);// 今天+1天
	    java.util.Date upWeekMondayDate = getThisWeekMonday(c.getTime());
	    upDateStart = strToDate.dateToStr(upWeekMondayDate) + " 00:00:00";
	    c.setTime(upWeekMondayDate);
	    c.add(Calendar.DAY_OF_YEAR, 6);// 周一加七天
	    upDateEnd = strToDate.dateToStr(c.getTime()) + " 23:59:59";
	} else if (granularity.equals("month")) {// 粒度：月
	    Calendar c = Calendar.getInstance();
	    c.setTime(currentDate);
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
	    thisDateStart = strToDate.dateToStr(c.getTime()) + " 00:00:00";
	    c.add(Calendar.MONTH, 1);
	    c.set(Calendar.DAY_OF_MONTH, 0);
	    thisDateEnd = strToDate.dateToStr(c.getTime()) + " 23:59:59";
	    c.add(Calendar.MONTH, -1);// 今天+1天
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
	    upDateStart = strToDate.dateToStr(c.getTime()) + " 00:00:00";
	    c.add(Calendar.MONTH, 1);
	    c.set(Calendar.DAY_OF_MONTH, 0);
	    upDateEnd = strToDate.dateToStr(c.getTime()) + " 23:59:59";
	}

	Map<String, Object> map = new LinkedHashMap<String, Object>();
	map.put("thisDateStart", thisDateStart);
	map.put("thisDateEnd", thisDateEnd);
	map.put("upDateStart", upDateStart);
	map.put("upDateEnd", upDateEnd);
	return map;
    }

    /*
     * 获取本周星期一
     */
    public static java.util.Date getThisWeekMonday(java.util.Date date) {
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	// 获得当前日期是一个星期的第几天
	int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
	if (1 == dayWeek) {
	    cal.add(Calendar.DAY_OF_MONTH, -1);
	}
	// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
	cal.setFirstDayOfWeek(Calendar.MONDAY);
	// 获得当前日期是一个星期的第几天
	int day = cal.get(Calendar.DAY_OF_WEEK);
	// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
	cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
	return cal.getTime();
    }

    /*
     * 获取上周星期一
     */
    public static java.util.Date geThisWeekSunday(java.util.Date date) {
	Calendar cal = Calendar.getInstance();
	cal.setTime(getThisWeekMonday(date));
	cal.add(Calendar.DATE, -7);
	return cal.getTime();
    }

    /*
     * 获取上周星期一
     */
    public static java.util.Date geLastWeekMonday(java.util.Date date) {
	Calendar cal = Calendar.getInstance();
	cal.setTime(getThisWeekMonday(date));
	cal.add(Calendar.DATE, -7);
	return cal.getTime();
    }





}

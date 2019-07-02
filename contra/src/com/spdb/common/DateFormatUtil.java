package com.spdb.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class DateFormatUtil {

	/**
	 * 
	 *  根据当前日期计算当前的周数。  根据年份和周数计算周的起始日期。  根据当前日期计算当前的月数(26号0晨0点)。 
	 * 根据年份和月数计算月的起始日期(26)。  根据当前日期计算展示月的范围。（10,26）  根据当前日期计算当前的季度。（26） 
	 * 根据年份和季度计算起始日期。（26）  根据年份和季度数计算包含月份。（26）  根据当前日期计算当前年（26）。 
	 * 根据年份计算年份的起始日期。（26）  根据输入的日期计算同比日期。（26；10,26）  根据输入的日期计算环比日期。（26；10,26）
	 * */
	//  返回昨日日期的方法
	public static SimpleDateFormat sdfmonth = new SimpleDateFormat("yyyy-MM");
	public static SimpleDateFormat sdfmonth2 = new SimpleDateFormat("yyyyMM");

	public static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat daysdf = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat hoursdf = new SimpleDateFormat(
			"yyyy-MM-dd HH");

	public static SimpleDateFormat sdfmill = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss SSS");

	public static void main(String[] args) {

		System.out.println(getMilliSecond("2010-07-01 00:00:00 232324"));

		/*
		 * String[] da = new String[2]; da[0] = "2010-07-01 00:00:00"; da[1] =
		 * "2010-11-01 01:00:00"; //getShowDateUnit(da); Calendar cal =
		 * Calendar.getInstance(); cal.add(cal.YEAR, -1);
		 * System.out.println("=="+cal.getActualMaximum(cal.DAY_OF_MONTH));
		 */
		// getWeekRange(2011, 1);
		// String[] da = new String[2];
		// da[0] = "2011-12-27 00:00:00";
		// da[1] = "2010-11-21 01:00:00";
		// String[] t = getTbRange(da);
		// String[] h = getHbRange(da);
		// System.out.println("t:" + t[0] + "--" + t[1]);
		// System.out.println("h:" + h[0] + "--" + h[1]);
		//
		// Calendar cal = Calendar.getInstance();
		// try {
		// cal.setTime(daysdf.parse("2011-12-31"));
		// cal.add(cal.DAY_OF_YEAR, 1);
		// System.out.println("==" + cal.get(cal.YEAR) + "-"
		// + (cal.get(cal.MONTH) + 1) + "-"
		// + cal.get(cal.DAY_OF_MONTH));
		// } catch (Exception e) {
		//
		// }

		int[] w = calcyearweek("2012-06-04");
		System.out.println(w[0] + "-" + w[1]);
		// int[] m = calcyearmonth("2011-12-26");
		// int[] y = yearequal("2010-12-26", "2011-11-11");
		// System.out.println("t:" + w[0] + "--" + w[1]);
		// System.out.println("t:" + m[0] + "--" + m[1]);
		// System.out.println("t:" + y[0] + "--" + y[1]);

		// 获取今年上一周[0,-1]，去年上一周[-1,-1],今年前一周[0,-2]
		// getYearQuarterNum(0, -1);
		// getYearQuarterNum(-1, -1);
		// getYearQuarterNum(0, -2);
		// for (int i = 1990; i < 2030; i++) {
		// calcyearweek(i + "-12-26");
		// }
		// for (int i = 1; i <= 12; i++) {
		// // calcyearweek("2011-"+i+"-26");
		// }

		// getNextMonday(7);
	}

	// 返回yyyy-MM-dd HH:mm:ss SSS
	public static String getMilliSecond(String date) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdfmill.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String date2 = sdfmill.format(cal.getTime());
		return date2;
	}

	// 获取当前的时间
	public static String getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		return sdf.format(date);
	}

	// 获取当前的时间
	public static String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		return daysdf.format(date);
	}

	public static Date getSendMonth(String date) {
		Calendar cal = Calendar.getInstance();
		try {
			return sdfmonth.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getSendTime(String date) {
		Calendar cal = Calendar.getInstance();
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 获取昨天的的日期
	public static String[] getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.add(cal.YEAR, 0);
		cal.add(cal.MONTH, 0);
		cal.add(cal.DATE, -1);
		cal.set(cal.HOUR_OF_DAY, 00);
		cal.set(cal.MINUTE, 00);
		cal.set(cal.SECOND, 00);
		Date first = cal.getTime();
		String[] date = new String[2];
		date[0] = sdf.format(first);
		cal.set(cal.HOUR_OF_DAY, 23);
		cal.set(cal.MINUTE, 59);
		cal.set(cal.SECOND, 59);
		Date second = cal.getTime();
		date[1] = sdf.format(second);
		return date;
	}

	// 计算传入的日期1，加上N天后，是否等于日期2(匹配日)
	public static boolean getMacthDay(String date1, Integer num, String date2) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(daysdf.parse(date1));
			cal.add(cal.DATE, num);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String _date1 = daysdf.format(cal.getTime());
		Calendar cal2 = Calendar.getInstance();
		try {
			cal2.setTime(daysdf.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String _date2 = daysdf.format(cal2.getTime());
		return _date1.equals(_date2);
	}

	// 计算传入的日期1，加上N天后，是否等于日期2 (匹配月)
	public static boolean getMacthMonth(String date1, Integer num, String date2) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdfmonth.parse(date1));
			cal.add(cal.MONTH, num);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String _date1 = sdfmonth.format(cal.getTime());
		Calendar cal2 = Calendar.getInstance();
		try {
			cal2.setTime(sdfmonth.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String _date2 = sdfmonth.format(cal2.getTime());
		return _date1.equals(_date2);
	}

	// 获取昨天的的日期
	public static int[] getYesterdayLastHour() {
		Calendar cal = Calendar.getInstance();
		cal.add(cal.YEAR, 0);
		cal.add(cal.MONTH, 0);
		cal.add(cal.DATE, -1);
		cal.set(cal.HOUR_OF_DAY, 23);
		cal.set(cal.MINUTE, 00);
		cal.set(cal.SECOND, 00);
		return new int[] { cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY) };
	}

	// 获取昨天的的日期
	public static String getZdyYesterday(String date) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(daysdf.parse(date));
			cal.add(cal.DAY_OF_MONTH, -1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String date2 = daysdf.format(cal.getTime());
		return date2;
	}
	
	public static String getAddMonth2(String date1, Integer num) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdfmonth2.parse(date1));
			cal.add(cal.MONTH, num);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String _date1 = sdfmonth2.format(cal.getTime());

		return _date1;
	}
	
	//yyyymm  --- yyyy-mm
	public static String getAddMonth3(String date1, Integer num) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdfmonth2.parse(date1));
			cal.add(cal.MONTH, num);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String _date1 = sdfmonth.format(cal.getTime());

		return _date1;
	}
	
	//月份 +mun
	public static String getAddMonth(String date1, Integer num) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdfmonth.parse(date1));
			cal.add(cal.MONTH, num);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String _date1 = sdfmonth.format(cal.getTime());

		return _date1;
	}
	
	// 相差月份
	public static int getMonthSpace(String date2, String date1) {
		int result = 0;
		try {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(sdfmonth2.parse(date1));
			c2.setTime(sdfmonth2.parse(date2));
			if (c1.getTimeInMillis() < c2.getTimeInMillis())
				return 0;
			int year1 = c1.get(Calendar.YEAR);
			int year2 = c2.get(Calendar.YEAR);
			int month1 = c1.get(Calendar.MONTH);
			int month2 = c2.get(Calendar.MONTH);
			int day1 = c1.get(Calendar.DAY_OF_MONTH);
			int day2 = c2.get(Calendar.DAY_OF_MONTH);
			// 获取年的差值 假设 d1 = 2015-8-16 d2 = 2011-9-30
			int yearInterval = year1 - year2;
			// 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
			if (month1 < month2 || month1 == month2 && day1 < day2)
				yearInterval--;
			// 获取月数差值
			int monthInterval = (month1 + 12) - month2;
			if (day1 < day2)
				monthInterval--;
			monthInterval %= 12;
			return yearInterval * 12 + monthInterval;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;

	}
	
	//月份范围 +num  格式yyyy-mm - yyyy-mm
	public static String getAddMonths(String date1, Integer num) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		String[] strings = date1.split(" - ");
		String startDay = strings[0];
		String endDay = strings[1];
		try {
			cal1.setTime(sdfmonth.parse(startDay));
			cal1.add(cal1.MONTH, num);
			
			cal2.setTime(sdfmonth.parse(endDay));
			cal2.add(cal2.MONTH, num);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String _date1 = sdfmonth.format(cal1.getTime())+" - "+sdfmonth.format(cal2.getTime());

		return _date1;
	}
	
	// 获取昨天、去年昨天或今年前天的的日期(昨天[0,-1]、去年昨天[-1,-1]、今年前天[0,-2])
	public static String getBdayYesterday(int i, int j) {
		Calendar cal = Calendar.getInstance();
		cal.add(cal.YEAR, i);
		cal.add(cal.MONTH, 0);
		cal.add(cal.DAY_OF_YEAR, j);
		Date first = cal.getTime();
		return daysdf.format(first);
	}
	//获取某一个的前一天
	public static String getYesterday(String date1, int daynumber) {
	    Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(daysdf.parse(date1));
			cal.add(cal.DAY_OF_YEAR, daynumber);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date first = cal.getTime();
		return daysdf.format(first);
	}

	// 获取今年上一周[0,-1]，去年上一周[-1,-1],今年前一周[0,-2]
	public static int[] getYearWeekNum(int yn, int wn) {
		int[] week = getWeekNum();
		int[] ret;
		if (week[1] == 1) {// 2012-1 2011-52,2010-52,2011-51
			int newweek = 0;
			if ((week[1] + wn) == 0) {
				newweek = 52;
			} else if ((week[1] + wn) == -1) {
				newweek = 51;
			}
			ret = new int[] { week[0] + yn - 1, newweek };
		} else if (week[1] == 2) {
			int newweek = 0;
			if ((week[1] + wn) == 1) {
				newweek = 1;
			} else if ((week[1] + wn) == 0) {
				newweek = 52;
				yn += -1;
			}
			ret = new int[] { week[0] + yn, newweek };
		} else {
			ret = new int[] { week[0] + yn, week[1] + wn };
		}
		return ret;
	}

	// 获取今年上一月[0,-1]，去年上一月[-1,-1],今年前一月[0,-2]
	public static int[] getYearMonthNum(int yn, int wn) {
		int[] month = getMonthNum();
		int[] ret;
		if (month[1] == 1) {
			int newmonth = 0;
			if ((month[1] + wn) == 0) {
				newmonth = 12;
			} else if ((month[1] + wn) == -1) {
				newmonth = 11;
			}
			ret = new int[] { month[0] + yn - 1, newmonth };
		} else if (month[1] == 2) {
			int newmonth = 0;
			if ((month[1] + wn) == 1) {
				newmonth = 1;
			} else if ((month[1] + wn) == 0) {
				newmonth = 12;
				yn += -1;
			}
			ret = new int[] { month[0] + yn, newmonth };
		} else {
			ret = new int[] { month[0] + yn, month[1] + wn };
		}
		// System.out.println("=="+ret[0]+"===="+ret[1]+"======");
		return ret;
	}

	// 获取今年上一季度[0,-1]，去年上一季度[-1,-1],今年前一季度[0,-2]
	public static int[] getYearQuarterNum(int yn, int wn) {
		int[] qu = getQuarterNum();

		int[] ret;
		if (qu[1] == 1) {
			int newqu = 0;
			if ((qu[1] + wn) == 0) {
				newqu = 4;
			} else if ((qu[1] + wn) == -1) {
				newqu = 3;
			}
			ret = new int[] { qu[0] + yn - 1, newqu };
		} else if (qu[1] == 2) {
			int newqu = 0;
			if ((qu[1] + wn) == 1) {
				newqu = 1;
			} else if ((qu[1] + wn) == 0) {
				newqu = 4;
				yn += -1;
			}
			ret = new int[] { qu[0] + yn, newqu };
		} else {
			ret = new int[] { qu[0] + yn, qu[1] + wn };
		}
		if (ret[1] == 1) {
			return new int[] { ret[0], 1, 2, 3 };
		} else if (ret[1] == 2) {
			return new int[] { ret[0], 4, 5, 6 };
		} else if (ret[1] == 3) {
			return new int[] { ret[0], 7, 8, 9 };
		} else {
			return new int[] { ret[0], 10, 11, 12 };
		}
		// System.out.println("=="+ret[0]+"===="+ret[1]+"======");
		// return ret;
	}

	// 计算当前日期的周数(去年的最后一周算起)
	public static int[] getWeekNum() {
		Calendar cal = Calendar.getInstance();
		return new int[] { cal.get(Calendar.YEAR),
				cal.get(Calendar.WEEK_OF_YEAR) };
	}

	// 计算当前日期的小时数(去年的最后一周算起)
	public static int[] getHourNum() {
		Calendar cal = Calendar.getInstance();
		return new int[] { cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
				cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY) };
	}

	// 计算当前日期的月数
	public static int[] getMonthNum() {
		Calendar cal = Calendar.getInstance();
		int i = 0;
		int j = 0;
		if (cal.get(cal.DAY_OF_MONTH) >= 26) {
			if (cal.get(cal.MONTH) == 11) {
				i = 1;
			}
			j = 1;
		}
		return new int[] { cal.get(cal.YEAR) + i, cal.get(cal.MONTH) + 1 + j };
	}

	// 计算当前日期的季度
	public static int[] getQuarterNum() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(cal.MONTH);
		int day = cal.get(cal.DAY_OF_MONTH);
		int year = cal.get(cal.YEAR);
		int quarter = 0;
		if (month >= 0 && month <= 2) {

			if (month == 2 && day >= 26) {
				quarter = 2;
			} else {
				quarter = 1;
			}
		}
		if (month >= 3 && month <= 5) {

			if (month == 5 && day >= 26) {
				quarter = 3;
			} else {
				quarter = 2;
			}
		}
		if (month >= 6 && month <= 8) {
			if (month == 8 && day >= 26) {
				quarter = 4;
			} else {
				quarter = 3;
			}
		}
		if (month >= 9 && month <= 11) {
			if (month == 11 && day >= 26) {
				quarter = 1;
				year = year + 1;
			} else {
				quarter = 4;
			}
		}
		System.out.println(year + "==" + quarter);
		return new int[] { year, quarter };
	}

	// 计算周的起始结束日期
	public static String[] getWeekRange(Integer year, Integer week) {
		String[] weekdate = new String[2];
		Calendar cal = Calendar.getInstance();

		cal.set(cal.YEAR, year);
		cal.set(cal.WEEK_OF_YEAR, week);
		Date date = cal.getTime();

		// System.out.println(sdf.format(date));
		int dw = cal.get(cal.DAY_OF_WEEK);
		// System.out.println(dw);

		cal.add(cal.DAY_OF_MONTH, -dw + 2);

		// System.out.println(dw);

		cal.set(cal.HOUR_OF_DAY, 00);
		cal.set(cal.MINUTE, 00);
		cal.set(cal.SECOND, 00);

		Date weekfirst = cal.getTime();
		// System.out.println(sdf.format(weekfirst));
		weekdate[0] = sdf.format(weekfirst);

		cal.add(cal.DAY_OF_MONTH, 6);

		// cal.add(cal.DAY_OF_YEAR, dw + 1);
		cal.set(cal.HOUR_OF_DAY, 23);
		cal.set(cal.MINUTE, 59);
		cal.set(cal.SECOND, 59);
		Date weeksecond = cal.getTime();
		// System.out.println(sdf.format(weeksecond));
		weekdate[1] = sdf.format(weeksecond);
		return weekdate;
	}

	// 计算周的起始结束日期(綂计到零点零分)
	public static String[] getWeekRangeJq(Integer year, Integer week) {

		/*
		 * 要修改的内容 Calendar cal = Calendar.getInstance(); try {
		 * cal.setTime(daysdf.parse(date)); cal.add(cal.DAY_OF_MONTH, -1); }
		 * catch (ParseException e) { e.printStackTrace(); }
		 */

		String[] weekdate = new String[2];
		Calendar cal = Calendar.getInstance();

		cal.set(cal.YEAR, year);
		cal.set(cal.WEEK_OF_YEAR, week);
		Date date = cal.getTime();

		// System.out.println(sdf.format(date));
		int dw = cal.get(cal.DAY_OF_WEEK);
		// System.out.println(dw);

		cal.add(cal.DAY_OF_MONTH, -dw + 2);

		// System.out.println(dw);

		cal.set(cal.HOUR_OF_DAY, 00);
		cal.set(cal.MINUTE, 00);
		cal.set(cal.SECOND, 00);

		Date weekfirst = cal.getTime();
		// System.out.println(sdf.format(weekfirst));
		weekdate[0] = sdf.format(weekfirst);

		cal.add(cal.DAY_OF_MONTH, 7);

		// cal.add(cal.DAY_OF_YEAR, dw + 1);
		cal.set(cal.HOUR_OF_DAY, 00);
		cal.set(cal.MINUTE, 00);
		cal.set(cal.SECOND, 00);
		Date weeksecond = cal.getTime();
		// System.out.println(sdf.format(weeksecond));
		weekdate[1] = sdf.format(weeksecond);
		return weekdate;
	}

	// 计算月的起始结束日期
	public static String[] getMonthRange(int year, int month) {
		int monthnum = month - 1;
		Calendar cal = Calendar.getInstance();
		String[] monthday = new String[2];
		cal.set(cal.YEAR, year);
		cal.set(cal.MONTH, monthnum);
		cal.set(cal.DATE, 25);
		cal.set(cal.HOUR_OF_DAY, 23);
		cal.set(cal.MINUTE, 59);
		cal.set(cal.SECOND, 59);
		Date monthsecond = cal.getTime();
		monthday[1] = sdf.format(monthsecond);

		if (monthnum == 0) {

			cal.add(cal.MONTH, -1);
			cal.set(cal.DATE, 26);
			cal.set(cal.HOUR_OF_DAY, 00);
			cal.set(cal.MINUTE, 00);
			cal.set(cal.SECOND, 00);
			Date firstsecond = cal.getTime();
			monthday[0] = sdf.format(firstsecond);
			// System.out.println(cal.get(cal.YEAR)+"##"+monthday[0]+"-1-"+monthday[1]);
		} else {
			cal.set(cal.YEAR, year);
			cal.set(cal.MONTH, monthnum - 1);
			cal.set(cal.DATE, 26);
			cal.set(cal.HOUR_OF_DAY, 00);
			cal.set(cal.MINUTE, 00);
			cal.set(cal.SECOND, 00);
			Date firstsecond = cal.getTime();
			monthday[0] = sdf.format(firstsecond);
			// System.out.println(monthday[0]+"-2-"+monthday[1]);
		}
		// System.out.println(monthday[0]+"--"+monthday[1]);
		return monthday;
	}

	// 计算月的起始结束日期(綂计到零点零分)
	public static String[] getMonthRangeJq(int year, int month) {
		int monthnum = month - 1;
		Calendar cal = Calendar.getInstance();
		String[] monthday = new String[2];
		cal.set(cal.YEAR, year);
		cal.set(cal.MONTH, monthnum);
		cal.set(cal.DATE, 26);
		cal.set(cal.HOUR_OF_DAY, 00);
		cal.set(cal.MINUTE, 00);
		cal.set(cal.SECOND, 00);
		Date monthsecond = cal.getTime();
		monthday[1] = sdf.format(monthsecond);

		if (monthnum == 0) {

			cal.add(cal.MONTH, -1);
			cal.set(cal.DATE, 26);
			cal.set(cal.HOUR_OF_DAY, 00);
			cal.set(cal.MINUTE, 00);
			cal.set(cal.SECOND, 00);
			Date firstsecond = cal.getTime();
			monthday[0] = sdf.format(firstsecond);
			// System.out.println(cal.get(cal.YEAR)+"##"+monthday[0]+"-1-"+monthday[1]);
		} else {
			cal.set(cal.YEAR, year);
			cal.set(cal.MONTH, monthnum - 1);
			cal.set(cal.DATE, 26);
			cal.set(cal.HOUR_OF_DAY, 00);
			cal.set(cal.MINUTE, 00);
			cal.set(cal.SECOND, 00);
			Date firstsecond = cal.getTime();
			monthday[0] = sdf.format(firstsecond);
			// System.out.println(monthday[0]+"-2-"+monthday[1]);
		}
		// System.out.println(monthday[0]+"--"+monthday[1]);
		return monthday;
	}

	// 计算月的展示范围（10,26）
	public static String[] getMonthShowRange() {
		Calendar cal = Calendar.getInstance();
		String[] monthday = new String[2];

		int month = cal.get(cal.MONTH);
		int day = cal.get(cal.DAY_OF_MONTH);
		// System.out.println(cal.get(cal.MONTH));
		// System.out.println(cal.get(cal.DAY_OF_MONTH));
		if (day < 26) {
			if (day > 10) {
				// 上月26本月26
				cal.set(cal.DAY_OF_MONTH, 25);
				cal.set(cal.HOUR_OF_DAY, 23);
				cal.set(cal.MINUTE, 59);
				cal.set(cal.SECOND, 59);
				monthday[1] = sdf.format(cal.getTime());
				cal.add(cal.MONTH, -1);
				cal.set(cal.DAY_OF_MONTH, 26);
				cal.set(cal.HOUR_OF_DAY, 00);
				cal.set(cal.MINUTE, 00);
				cal.set(cal.SECOND, 00);
				monthday[0] = sdf.format(cal.getTime());
			} else {
				// 上月11本月10
				cal.set(cal.DAY_OF_MONTH, 10);
				cal.set(cal.HOUR_OF_DAY, 23);
				cal.set(cal.MINUTE, 59);
				cal.set(cal.SECOND, 59);
				monthday[1] = sdf.format(cal.getTime());
				cal.add(cal.MONTH, -1);
				cal.set(cal.DAY_OF_MONTH, 11);
				cal.set(cal.HOUR_OF_DAY, 00);
				cal.set(cal.MINUTE, 00);
				cal.set(cal.SECOND, 00);
				monthday[0] = sdf.format(cal.getTime());
			}

		} else {
			// 本月10号到下月10号
			cal.set(cal.DAY_OF_MONTH, 11);
			cal.set(cal.HOUR_OF_DAY, 00);
			cal.set(cal.MINUTE, 00);
			cal.set(cal.SECOND, 00);
			monthday[0] = sdf.format(cal.getTime());
			cal.add(cal.MONTH, 1);
			cal.set(cal.DAY_OF_MONTH, 10);
			cal.set(cal.HOUR_OF_DAY, 23);
			cal.set(cal.MINUTE, 59);
			cal.set(cal.SECOND, 59);
			monthday[1] = sdf.format(cal.getTime());
		}
		// System.out.println(monthday[0]+"####"+monthday[1]);
		return monthday;
	}

	// 计算季度的开始结束日期
	public static String[] getQuarterRanger(int year, int quarter) {
		int startmonth = 0;
		int endmonth = 0;
		String[] quarterday = new String[2];
		Calendar cal = Calendar.getInstance();
		Calendar calsec = Calendar.getInstance();
		cal.set(cal.HOUR_OF_DAY, 00);
		cal.set(cal.MINUTE, 00);
		cal.set(cal.SECOND, 00);
		cal.set(cal.DAY_OF_MONTH, 26);

		calsec.set(calsec.HOUR_OF_DAY, 23);
		calsec.set(calsec.MINUTE, 59);
		calsec.set(calsec.SECOND, 59);
		calsec.set(calsec.YEAR, 26);
		switch (quarter) {
		case 1:
			startmonth = 12;
			endmonth = 2;
			cal.set(cal.YEAR, year);
			cal.set(cal.MONTH, 0);
			cal.add(cal.MONTH, -1);
			Date done1 = cal.getTime();
			quarterday[0] = sdf.format(done1);
			calsec.set(calsec.YEAR, year);
			calsec.set(calsec.MONTH, endmonth);
			Date dsecond1 = calsec.getTime();
			quarterday[1] = sdf.format(dsecond1);
			break;
		case 2:
			startmonth = 3;
			endmonth = 5;
			cal.set(cal.YEAR, year);
			cal.set(cal.MONTH, startmonth - 1);
			Date done2 = cal.getTime();
			quarterday[0] = sdf.format(done2);
			calsec.set(calsec.YEAR, year);
			calsec.set(calsec.MONTH, endmonth);
			Date dsecond2 = calsec.getTime();
			quarterday[1] = sdf.format(dsecond2);

			break;
		case 3:
			startmonth = 6;
			endmonth = 8;
			cal.set(cal.YEAR, year);
			cal.set(cal.MONTH, startmonth - 1);
			Date done3 = cal.getTime();
			quarterday[0] = sdf.format(done3);
			calsec.set(calsec.YEAR, year);
			calsec.set(calsec.MONTH, endmonth);
			Date dsecond3 = calsec.getTime();
			quarterday[1] = sdf.format(dsecond3);
			break;
		case 4:
			startmonth = 9;
			endmonth = 11;
			cal.set(cal.YEAR, year);
			cal.set(cal.MONTH, startmonth - 1);
			Date done4 = cal.getTime();
			quarterday[0] = sdf.format(done4);
			calsec.set(calsec.YEAR, year);
			calsec.set(calsec.MONTH, endmonth);
			Date dsecond4 = calsec.getTime();
			quarterday[1] = sdf.format(dsecond4);
			break;
		}
		// System.out.println(quarterday[0]+"--"+quarterday[1]);
		return quarterday;
	}

	// 计算季度包含的月份
	public static int[] getQuarterMonths(int quarter) {
		int[] monthnum = new int[3];
		switch (quarter) {
		case 1:
			monthnum[0] = 1;
			monthnum[1] = 2;
			monthnum[2] = 3;
			break;
		case 2:
			monthnum[0] = 4;
			monthnum[1] = 5;
			monthnum[2] = 6;
			break;
		case 3:
			monthnum[0] = 7;
			monthnum[1] = 8;
			monthnum[2] = 9;
			break;
		case 4:
			monthnum[0] = 10;
			monthnum[1] = 11;
			monthnum[2] = 12;
			break;
		}
		return monthnum;
	}

	// 根据当前日期计算当前年份
	public static int getYearNum() {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(cal.DAY_OF_MONTH);
		int month = cal.get(cal.MONTH);
		if (month == 11) {
			if (day >= 26) {
				return (cal.get(cal.YEAR) + 1);
			} else {
				return cal.get(cal.YEAR);
			}
		} else {
			return cal.get(cal.YEAR);
		}
	}

	// 计算是否有效日期包括(周、月(10,26号)、年)

	public static boolean isrightDate(String[] range) {
		if (isrightMonth(range)) {
			return true;
		}
		if (isrightMonths(range)) {
			return true;
		}
		if (isrightWeek(range)) {
			return true;
		}
		return false;
	}

	// 计算年的范围
	public static String[] getYearRange(int year) {
		String[] years = new String[2];
		years[0] = (year - 1) + "-" + 12 + "-" + 26 + " 00:00:00";
		years[1] = (year) + "-" + 12 + "-" + 25 + " 23:59:59";
		// System.out.println(years[0]+"###"+years[1]);
		return years;
	}

	// 判断是否输入有效年范围
	public static boolean isrightYear(String[] range) {
		// System.out.println(range[0].substring(4));
		if (!range[0].substring(4).equals("-12-26 00:00:00")) {
			return false;
		}
		if (!range[1].substring(4).equals("-12-25 23:59:59")) {
			return false;
		}
		return true;
	}

	// 判断是否输入有效月26范围
	// 判断是否输入有效月范围
	public static boolean isrightMonth(String[] range) {
		if (!range[0].substring(7).equals("-26 00:00:00")) {
			return false;
		} else {
			if (!range[1].substring(7).equals("-25 23:59:59")) {
				return false;
			} else {
				return true;
			}
		}
	}

	// 判断是否输入有效月10范围
	public static boolean isrightMonths(String[] range) {
		if (!range[0].substring(7).equals("-11 00:00:00")) {
			return false;
		} else {
			if (!range[1].substring(7).equals("-10 23:59:59")) {
				return false;
			} else {
				return true;
			}
		}
	}

	// 判断是否输入有效周范围
	// 判断是否输入有效周范围
	public static boolean isrightWeek(String[] range) {

		if (isrightDay(range)) {// 先判断是否有效日范围

			try {
				Date rangOne = sdf.parse(range[0]);
				Date rangTwo = sdf.parse(range[1]);
				Calendar cal = Calendar.getInstance();
				Calendar cals = Calendar.getInstance();
				cal.setTime(rangOne);
				cals.setTime(rangTwo);
				int weekOne = cal.get(cal.DAY_OF_WEEK);
				int weekTwo = cals.get(cals.DAY_OF_WEEK);
				// System.out.println(weekOne + "===year===" + weekOne);
				if (weekOne == 2) {
					if (weekTwo == 1) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}

			} catch (ParseException e) {
				return false;
			}

		} else {

			return false;
		}

	}

	// 判断是否输入有效日范围
	// 判断是否输入有效日范围
	public static boolean isrightDay(String[] range) {
		if (!range[0].substring(11).equals("00:00:00")) {
			return false;
		}
		if (!range[1].substring(11).equals("23:59:59")) {
			return false;
		}
		return true;
	}

	// 计算同比日期范围(必须是业务日期)
	public static String[] getTongbiRange(String[] range, String flag) {
		String[] str = new String[2];
		if (flag.equals("day")) {
			if (isrightDay(range)) {
				try {
					Calendar cal = Calendar.getInstance();
					Calendar cals = Calendar.getInstance();
					cal.setTime(sdf.parse(range[0]));
					cals.setTime(sdf.parse(range[1]));
					cal.add(cal.YEAR, -1);
					cals.add(cals.YEAR, -1);
					str[0] = sdf.format(cal.getTime());
					str[1] = sdf.format(cals.getTime());
				} catch (ParseException e) {
					str[0] = "error";
					return str;
				}
			} else {
				str[0] = "error";
			}

		} else if (flag.equals("week")) {
			if (isrightWeek(range)) {
				try {
					Calendar cal = Calendar.getInstance();
					Calendar cals = Calendar.getInstance();
					cal.setTime(sdf.parse(range[0]));
					cals.setTime(sdf.parse(range[1]));
					cal.add(cal.YEAR, -1);
					cals.add(cals.YEAR, -1);
					str[0] = sdf.format(cal.getTime());
					str[1] = sdf.format(cals.getTime());

				} catch (ParseException e) {
					str[0] = "error";
					return str;
				}
			} else {
				str[0] = "error";
			}

		} else if (flag.equals("month")) {
			if (isrightMonth(range) || isrightMonths(range)) {
				try {
					Calendar cal = Calendar.getInstance();
					Calendar cals = Calendar.getInstance();
					cal.setTime(sdf.parse(range[0]));
					cals.setTime(sdf.parse(range[1]));
					cal.add(cal.YEAR, -1);
					cals.add(cals.YEAR, -1);
					str[0] = sdf.format(cal.getTime());
					str[1] = sdf.format(cals.getTime());
				} catch (ParseException e) {
					str[0] = "error";
					return str;
				}
			} else {
				str[0] = "error";
			}

		} else if (flag.equals("year")) {
			boolean fag = isrightYear(range);
			if (fag) {
				try {
					Calendar cal = Calendar.getInstance();
					Calendar cals = Calendar.getInstance();
					cal.setTime(sdf.parse(range[0]));
					cals.setTime(sdf.parse(range[1]));
					cal.add(cal.YEAR, -1);
					cals.add(cals.YEAR, -1);
					str[0] = sdf.format(cal.getTime());
					str[1] = sdf.format(cals.getTime());
				} catch (ParseException e) {
					str[0] = "error";
					return str;
				}
			} else {
				str[0] = "error";
			}
		}
		// System.out.println(str[0] + "==" + str[1]);
		return str;
	}

	// 计算环比日期范围(必须是业务日期)
	public static String[] getHuanbiRange(String[] range, String flag) {
		String[] str = new String[2];
		if (flag.equals("day")) {
			if (isrightDay(range)) {
				try {
					Calendar cal = Calendar.getInstance();
					Calendar cals = Calendar.getInstance();
					cal.setTime(sdf.parse(range[0]));
					cals.setTime(sdf.parse(range[1]));
					cal.add(cal.DAY_OF_MONTH, -1);
					cals.add(cals.DAY_OF_MONTH, -1);
					str[0] = sdf.format(cal.getTime());
					str[1] = sdf.format(cals.getTime());
				} catch (ParseException e) {
					str[0] = "error";
					return str;
				}
			} else {
				str[0] = "error";
			}

		} else if (flag.equals("week")) {
			if (isrightWeek(range)) {
				try {
					Calendar cal = Calendar.getInstance();
					Calendar cals = Calendar.getInstance();
					cal.setTime(sdf.parse(range[0]));
					cals.setTime(sdf.parse(range[1]));
					cal.add(cal.DAY_OF_MONTH, -7);
					cals.add(cals.DAY_OF_MONTH, -7);
					str[0] = sdf.format(cal.getTime());
					str[1] = sdf.format(cals.getTime());

				} catch (ParseException e) {
					str[0] = "error";
					return str;
				}
			} else {
				str[0] = "error";
			}

		} else if (flag.equals("month")) {
			if (isrightMonth(range) || isrightMonths(range)) {
				try {
					Calendar cal = Calendar.getInstance();
					Calendar cals = Calendar.getInstance();
					cal.setTime(sdf.parse(range[0]));
					cals.setTime(sdf.parse(range[1]));
					cal.add(cal.MONTH, 1);
					cals.add(cals.MONTH, 1);
					str[0] = sdf.format(cal.getTime());
					str[1] = sdf.format(cals.getTime());
				} catch (ParseException e) {
					str[0] = "error";
					return str;
				}
			} else {
				str[0] = "error";
			}

		} else if (flag.equals("year")) {
			boolean fag = isrightYear(range);
			if (fag) {
				str[0] = (Integer.parseInt(range[0].substring(0, 4)) - 1)
						+ range[0].substring(4);
				str[1] = (Integer.parseInt(range[1].substring(0, 4)) - 1)
						+ range[1].substring(4);
			} else {
				str[0] = "error";
			}
		}
		// System.out.println(str[0] + "==" + str[1]);
		return str;
	}

	// 计算统计结果的显示时间单位
	public static int getShowDateUnit(String[] range) {
		Calendar cal = Calendar.getInstance();
		Calendar cals = Calendar.getInstance();
		try {
			long oneday = 24 * 60 * 60 * 1000;
			// int nDay = (int) ((sdf.parse(range[1]).getTime() -
			// sdf.parse(range[0]).getTime()) / (24 * 60 * 60 * 1000));
			long startday = (sdf.parse(range[1]).getTime());
			long endday = sdf.parse(range[0]).getTime();
			long nDay = (startday - endday);

			if (nDay >= oneday) {
				if (nDay <= 31 * oneday) {
					// System.out.println("nDay <= 31 * oneday=" +
					// oneday+"##"+31 * oneday);
					// System.out.println("2");
					return 2;// 日
				} else {
					if (nDay <= 90 * oneday) {
						// System.out.println("nDay <= 90 * oneday=" + 31 *
						// oneday+"##"+90 * oneday);
						// System.out.println("3");
						return 3;// 周
					} else {
						// System.out.println("90以上=" + 90 * oneday);
						// System.out.println("4");
						return 4;// 年
					}
				}
			} else {
				if (nDay > 0 && nDay < oneday) {
					// System.out.println("nDay > 0 && nDay < oneday=" +
					// oneday);
					// System.out.println("1");
					return 1;// 小时

				} else {
					// System.out.println("0");
					return 0;// 无效(结束时间小区开始时间)
				}

			}
		} catch (ParseException e) {
			// System.out.println("0=");
			return 0;
		}

	}

	// 获取天数
	public static int daynum(String start, String end) {
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = daysdf.parse(start);
			endDate = daysdf.parse(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long day = (endDate.getTime() - beginDate.getTime())
				/ (24 * 60 * 60 * 1000);
		return Integer.parseInt(day + "");
	}

	// 判断天数落在范围，并确定按天、周、月的方式统计
	public static int gettype(String[] range) {
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = sdf.parse(range[0]);
			endDate = sdf.parse(range[1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long day = (endDate.getTime() - beginDate.getTime())
				/ (24 * 60 * 60 * 1000);

		if (day <= 30) {
			return 1;
		} else if (day <= 90) {
			return 2;
		} else if (day <= 180) {
			return 3;
		} else {
			return -1;
		}
	}

	// 获取日期统计类型
	public static int daytype(String[] range) {
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = daysdf.parse(range[0]);
			endDate = daysdf.parse(range[1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long day = (endDate.getTime() - beginDate.getTime())
				/ (24 * 60 * 60 * 1000);

		if (day > 730) {
			return 4;// 只能以年方式展示
		} else if (day > 365) {
			return 3;// 只能以年、月方式展示
		} else if (day > 30) {
			return 2;// 只能以年、月、周方式展示
		} else {
			return 1;// 只能以年、月、周、日的方式展示
		}
	}

	// 计算输入日期所在年份及该年份的第几周
	public static int[] calcyearweek(String daystr) {
		int[] yearweek = new int[2];
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(daysdf.parse(daystr));
			if (cal.get(cal.DAY_OF_WEEK) == 1) {
				if (cal.get(cal.MONTH) == 11 && cal.get(cal.DAY_OF_MONTH) == 26) {
					yearweek[1] = getMaxWeekNumOfYear(cal.get(cal.YEAR));
				} else {
					yearweek[1] = cal.get(cal.WEEK_OF_YEAR);
				}
				yearweek[0] = cal.get(cal.YEAR);

			} else {
				if (cal.get(cal.MONTH) == 11 && cal.get(cal.DAY_OF_MONTH) == 26
						&& cal.get(cal.DAY_OF_WEEK) == 2) {
					yearweek[0] = cal.get(cal.YEAR) + 1;
					yearweek[1] = 1;
				} else if (cal.get(cal.MONTH) == 11
						&& cal.get(cal.DAY_OF_MONTH) == 26
						&& cal.get(cal.DAY_OF_WEEK) > 2) {
					yearweek[0] = cal.get(cal.YEAR);
					yearweek[1] = getMaxWeekNumOfYear(cal.get(cal.YEAR));
				} else {
					yearweek[0] = cal.get(cal.YEAR);
					if (cal.get(cal.DAY_OF_WEEK) >= 2) {
						yearweek[1] = cal.get(cal.WEEK_OF_YEAR) + 1;
					} else {
						yearweek[1] = cal.get(cal.WEEK_OF_YEAR);
					}
				}
			}
		} catch (ParseException e) {
			yearweek[0] = 0;
			return yearweek;
		}
		System.out.println(yearweek[0] + "-" + yearweek[1]);
		return yearweek;
	}

	// 获取一年多少周
	public static int getWeekOfYear(Date daystr) {
		Calendar cal = new GregorianCalendar();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(7);
		cal.setTime(daystr);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		return week;
	}

	// 获取某年中的最大周数
	public static int getMaxWeekNumOfYear(int year) {
		Calendar cal = new GregorianCalendar();
		cal.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
		return getWeekOfYear(cal.getTime());
	}

	// 获得下周星期一的日期
	public static String getNextMonday(int count) {
		Calendar strDate = Calendar.getInstance();
		strDate.add(strDate.DATE, count);
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.set(strDate.get(Calendar.YEAR),
				strDate.get(Calendar.MONTH), strDate.get(Calendar.DATE));
		Date monday = currentDate.getTime();
		String preMonday = daysdf.format(monday);
		return preMonday;
	}

	// 计算输入日期所在年份及该年份的第几月
	public static int[] calcyearmonth(String daystr) {
		int[] yearmonth = new int[2];
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(daysdf.parse(daystr));
			if (cal.get(cal.MONTH) == 11 && cal.get(cal.DAY_OF_MONTH) >= 26) {
				yearmonth[0] = cal.get(cal.YEAR) + 1;
				yearmonth[1] = 1;
			} else {
				yearmonth[0] = cal.get(cal.YEAR);
				yearmonth[1] = cal.get(cal.MONTH) + 1;
			}

		} catch (ParseException e) {
			yearmonth[0] = 0;
			return yearmonth;
		}
		return yearmonth;
	}

	public static int getyearnum() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int day = cal.get(cal.DAY_OF_MONTH);
		if (day >= 26) {
			year = year + 1;
		}
		return year;
	}

	// 返回年份
	public static int[] yearequal(String kssj, String jssj) {
		int[] year = new int[2];
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(daysdf.parse(kssj));
			Calendar cals = Calendar.getInstance();
			cals.setTime(daysdf.parse(jssj));
			if (cal.get(cal.MONTH) == 11 && cal.get(cal.DAY_OF_MONTH) >= 26) {
				year[0] = cal.get(cal.YEAR) + 1;
			} else {
				year[0] = cal.get(cal.YEAR);
			}
			if (cals.get(cals.MONTH) == 11 && cals.get(cals.DAY_OF_MONTH) >= 26) {
				year[1] = cals.get(cals.YEAR) + 1;
			} else {
				year[1] = cals.get(cals.YEAR);
			}

		} catch (ParseException e) {
			year[0] = 0;
			return year;
		}
		return year;
	}

	// 无业务规则的同比日期范围
	public static String[] getTbRange(String[] range) {
		String[] str = new String[2];
		try {
			Calendar cal = Calendar.getInstance();
			Calendar cals = Calendar.getInstance();
			cal.setTime(daysdf.parse(range[0]));
			cals.setTime(daysdf.parse(range[1]));
			// int ynum = Integer.parseInt(range[1].toString().substring(0,
			// 4))-Integer.parseInt(range[0].toString().substring(0, 4));
			cal.add(cal.YEAR, -1);
			cals.add(cals.YEAR, -1);
			str[0] = daysdf.format(cal.getTime());
			str[1] = daysdf.format(cals.getTime());
		} catch (ParseException e) {
			str[0] = "error";
			return str;
		}
		return str;
	}

	// 无业务规则的环比日期范围
	public static String[] getHbRange(String[] range) {
		String[] str = new String[2];
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = daysdf.parse(range[0]);
			endDate = daysdf.parse(range[1]);
			Calendar cal = Calendar.getInstance();
			cal.setTime(beginDate);
			long day = (endDate.getTime() - beginDate.getTime())
					/ (24 * 60 * 60 * 1000);
			int num = Integer.parseInt(day + "") + 1;
			cal.add(cal.DAY_OF_YEAR, -num);
			str[0] = daysdf.format(cal.getTime());
			cal.setTime(beginDate);
			int ynum = Integer.parseInt(range[1].toString().substring(0, 4))
					- Integer.parseInt(range[0].toString().substring(0, 4));
			cal.add(cal.DAY_OF_YEAR, -ynum);
			str[1] = daysdf.format(cal.getTime());
		} catch (ParseException e) {
			str[0] = "error";
			return str;
		}
		return str;
	}
	
	//获取两个日期的所有月份
	public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
	    ArrayList<String> result = new ArrayList<String>();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");//格式化为年月

	    Calendar min = Calendar.getInstance();
	    Calendar max = Calendar.getInstance();

	    min.setTime(sdf.parse(minDate));
	    min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

	    max.setTime(sdf.parse(maxDate));
	    max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

	    Calendar curr = min;
	    while (curr.before(max)) {
	     result.add(sdf.format(curr.getTime()));
	     curr.add(Calendar.MONTH, 1);
	    }

	    return result;
	  }
}

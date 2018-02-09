package com.mutopia.sys.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * <p>Title: EmailExistException</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
public class DateUtil {

	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String format(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		return new java.text.SimpleDateFormat(pattern).format(date);
	}

	public static Date format(String date) {
		return format(date, null);
	}

	public static Date format(String date, String pattern) {
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		if (date == null || date.equals("") || date.equals("null")) {
			return new Date();
		}
		Date d = null;
		try {
			d = new java.text.SimpleDateFormat(pattern).parse(date);
		} catch (ParseException pe) {
		}
		return d;
	}

	public DateUtil() {
	}

	/**
	 * 获取当前时间
	 */
	public static Date nowDate() {
		Date str = new Date();
		return str;
	}

	/**
	 * Date转字符串 返回指定格式的时间，未指定格式则默认yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime(Date date, String pattern) {
		if (pattern == null)
			pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 字符串转Date 返回指定格式的时间，未指定格式则默认yyyy-MM-dd HH:mm:ss
	 */
	public static Date StrToDateTime(String str, String pattern) {
		Date returnDate = null;
		if (pattern == null) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			returnDate = sdf.parse(str);
		} catch (Exception e) {
			return returnDate;
		}
		return returnDate;
	}

	/**
	 * 返回年/月/日/小时/分钟/秒/周
	 * type:年(1)、月(2)、日(3)、时(4)、分(5)、秒(6)、星期几(7)、本月第几周(8)、本年第几周(9)
	 * 
	 */
	public static String getTimeParam(int type) {
		int param = 0;
		String returnValue = "";
		Calendar ca = Calendar.getInstance();
		switch (type) {
		case 1:
			param = ca.get(Calendar.YEAR);// 获取年份
			break;
		case 2:
			param = ca.get(Calendar.MONTH);// 获取月份
			break;
		case 3:
			param = ca.get(Calendar.DATE);// 获取日
			break;
		case 4:
			param = ca.get(Calendar.HOUR);// 小时
			break;
		case 5:
			param = ca.get(Calendar.MINUTE);// 分
			break;
		case 6:
			param = ca.get(Calendar.SECOND);// 秒
			break;
		case 7:
			param = ca.get(Calendar.DAY_OF_WEEK) - 1;// 星期几，从周日开始算1
			param = param == 0 ? 7 : param;
			break;
		case 8:
			param = ca.get(Calendar.WEEK_OF_MONTH);// 本月第几周
			break;
		case 9:
			param = ca.get(Calendar.WEEK_OF_YEAR);// 本年第几周
			break;
		default:
			param = -1;
		}
		returnValue = param == -1 ? "" : String.valueOf(param);
		return returnValue;
	}

	/**
	 * 
	 * 计算两个时间相差天数计算两个时间相差天数
	 * 
	 */
	public static long daysBetween(String start, String end) {
		long days = 0;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = format.parse(start);
			Date d2 = format.parse(end);
			long day1 = d1.getTime();
			long day2 = d2.getTime();
			days = (day2 - day1) / (24 * 3600 * 1000);
			if (days < 0) {
				return -1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}

	/**
	 * 返回输入月最后一天的日期
	 */
	public static String getLastDayOfMonth(Date date, String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		// Calendar calendar = convert(date);
		calendar.set(Calendar.DATE, calendar.getMaximum(Calendar.DATE));
		return format.format(calendar.getTime());
	}

	/**
	 * 返回年龄
	 */
	public static int getAge(String birthday) {
		Date now = new Date();
		String sNow = getDateTime(now, "yyyy");
		String sBir = birthday.substring(0, 4);
		int sAge = Integer.parseInt(sNow) - Integer.parseInt(sBir);
		return sAge;
	}
	
	/**
	 * 增减日期，求几天前或几天后的日期
	 * 
	 * @param srcDate
	 * @param inter 隔的天数
	 * @return
	 */
	public static Date addDate(Date srcDate, int inter) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(srcDate);
		cal.add(Calendar.DAY_OF_YEAR, inter);
		return cal.getTime();
	}
	
	/**
	 * 增减日期，求几天前或几天后的日期
	 * 
	 * @param srcDate
	 * @param inter 隔的天数
	 * @return
	 */
	public static Date addMinute(Date srcDate, int inter) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(srcDate);
		cal.add(Calendar.MINUTE, inter);
		return cal.getTime();
	}
	
	//以下这些方法为自有的周算法begin
	//note: 周一处于哪一年份就标识该周是属于哪一年份的，以自然周计
	/**
	 * 查询某个年份有多少周
	 * 
	 * @param year
	 * @return
	 */
	public static int weekCnt(int year) {
		Date startDate = getMondayOfWeek(year, 1);//取第一个周一
		Date endDate = getLastSundayOfYear(year);//取最后一个周日
		return (int)(((endDate.getTime() - startDate.getTime())/(24 * 3600 * 1000) + 1)/7.0);
	}
	
	/**
	 * 查询某个日期是哪一周的
	 * 
	 * @param date
	 * @return
	 */
	public static int whichWeek(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		Date startDateOfYear = getMondayOfWeek(ca.get(Calendar.YEAR), 1);
		double distance = ((ca.getTime().getTime() - startDateOfYear.getTime())/(24 * 3600 * 1000) + 1)/7.0;
		//System.out.println("====" + distance);
		if(distance < 0) {//若是时间在第一个周一以前，则取去年最后一周
			return weekCnt(ca.get(Calendar.YEAR) - 1);
		}
		return (int)Math.ceil(distance);
	}
	
	/**
	 * 某一日期在周历中被划为哪一年
	 * 
	 * @param date
	 * @return
	 */
	public static int whichYear(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		Date startDateOfYear = getMondayOfWeek(ca.get(Calendar.YEAR), 1);
		double distance = ((ca.getTime().getTime() - startDateOfYear.getTime())/(24 * 3600 * 1000) + 1)/7.0;
		//System.out.println("====" + distance);
		if(distance < 0) {
			return ca.get(Calendar.YEAR) - 1;
		}
		return ca.get(Calendar.YEAR);
	}
	
	/**
	 * 查询某一周的星期一的日期
	 * 
	 * @param year
	 * @param weekId
	 * @return
	 */
	public static Date getMondayOfWeek(int year, int weekId) {
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.YEAR, year);
		ca.set(Calendar.WEEK_OF_YEAR, weekId);
		ca.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		if(ca.get(Calendar.YEAR) < year) {//如果获取到的不是今年的日期，则取下个周一
			ca.set(Calendar.YEAR, year);
			ca.set(Calendar.WEEK_OF_YEAR, weekId + 1);
		}
		//System.out.println(ca.getTime());
		return ca.getTime();
	}
	
	/**
	 * 获取某年的最后一个周日
	 * 
	 * @param year
	 * @return
	 */
	public static Date getLastSundayOfYear(int year) {
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.YEAR, year);
		ca.set(Calendar.MONTH, 11);
		ca.set(Calendar.DAY_OF_MONTH, 31);
		if(ca.get(Calendar.DAY_OF_WEEK) > 1) {//12月31日非周日
			ca.add(Calendar.DAY_OF_MONTH, 8 - ca.get(Calendar.DAY_OF_WEEK));			
		}
		ca.set(Calendar.HOUR_OF_DAY, 0);
		//System.out.println(ca.getTime());
		return ca.getTime();
	}	
	//以上这些方法为自有的周算法end
	/**
	* 得到指定月的天数
	* */
	public static int getMonthLastDay(int year, int month)
	{
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);//把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}


	/*public static void main(String[] args) {
		System.out.println(DateUtil.addMinute(DateUtil.StrToDateTime("2018-02-07 22:50:00", null), 15));
	}*/

}

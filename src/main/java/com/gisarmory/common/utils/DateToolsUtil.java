package com.gisarmory.common.utils;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @ClassName: DateToolsUtil
 * @Description: 常用日历操作辅助类  
 * @author guxuebei
 * @date 2017年1月11日
 */
public class DateToolsUtil {

	private int weeks = 0;// 用来全局控制 上一周，本周，下一周的周数变化   
	private int MaxDate; // 一月最大天数   
	private int MaxYear; // 一年最大天数   
	/**
	 * 日期格式 yyyy-MM-dd
	 */
	public static final String DATEFORMAT_YMD = "yyyy-MM-dd";
	/**
	 * 日期格式MM-dd
	 */
	public static final String DATEFORMAT_MD = "MM-dd";
	/**
	 * 日期格式 yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATEFORMAT_YMD_HMS = "yyyy-MM-dd HH:mm:ss";

	/**  
	 * 测试  
	 *   
	 * @param args  
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		DateToolsUtil tt = new DateToolsUtil();
		System.out.println("当前时间:" + DateToolsUtil.dateToStr(new Date(), DateToolsUtil.DATEFORMAT_MD));
		System.out.println("日期:" + DateToolsUtil.dateToStr(new Date(), DateToolsUtil.DATEFORMAT_MD));
		
		System.out.println("获取昨天天日期:"
				+ DateToolsUtil.getEverToDay(tt.getNowTime(DATEFORMAT_YMD), -1));
		System.out.println("获取当天日期:" + tt.getNowTime(DATEFORMAT_YMD));
		System.out.println("获取本周一日期:" + tt.getMondayOFWeek());
		System.out.println("获取本周日的日期~:" + tt.getCurrentWeekday());
		System.out.println("获取上周一日期:" + tt.getPreviousWeekday());
		System.out.println("获取上周日日期:" + tt.getPreviousWeekSunday());
		System.out.println("获取下周一日期:" + tt.getNextMonday());
		System.out.println("获取下周日日期:" + tt.getNextSunday());
		System.out.println("获得相应周的周六的日期:" + tt.getNowTime(DATEFORMAT_YMD));
		System.out.println("获取本月第一天日期:" + tt.getFirstDayOfMonth());
		System.out.println("获取本月最后一天日期:" + tt.getDefaultDay());
		System.out.println("获取上月第一天日期:" + tt.getPreviousMonthFirst());
		System.out.println("获取上月最后一天的日期:" + tt.getPreviousMonthEnd());
		System.out.println("获取下月第一天日期:" + tt.getNextMonthFirst());
		System.out.println("获取下月最后一天日期:" + tt.getNextMonthEnd());
		System.out.println("获取本年的第一天日期:" + tt.getCurrentYearFirst());
		System.out.println("获取本年最后一天日期:" + tt.getCurrentYearEnd());
		System.out.println("获取去年的第一天日期:" + tt.getPreviousYearFirst());
		System.out.println("获取去年的最后一天日期:" + tt.getPreviousYearEnd());
		System.out.println("获取明年第一天日期:" + tt.getNextYearFirst());
		System.out.println("获取明年最后一天日期:" + tt.getNextYearEnd());
		System.out.println("获取本季度第一天:" + tt.getThisSeasonFirstTime(11));
		System.out.println("获取本季度最后一天:" + tt.getThisSeasonFinallyTime(11));
		System.out.println("获取两个日期之间间隔天数2008-12-1~2008-9.29:"
				+ DateToolsUtil.getTwoDay("2008-12-1", "2008-9-29"));
		System.out.println("获取当前月的第几周：" + DateToolsUtil.getWeekOfMonth());
		System.out.println("获取当前年份：" + DateToolsUtil.getYear());
		System.out.println("获取当前月份：" + DateToolsUtil.getMonth());
		System.out.println("获取今天在本年的第几天：" + DateToolsUtil.getDayOfYear());
		System.out.println("获得今天在本月的第几天(获得当前日)：" + DateToolsUtil.getDayOfMonth());
		System.out.println("获得今天在本周的第几天：" + DateToolsUtil.getDayOfWeek());
		System.out.println("获得半年后的日期："
				+ DateToolsUtil.convertDateToString(DateToolsUtil.getTimeYearNext()));

	}

	/**
	 * 获取任意字符串(everDate)时间的to天前后的日期
	 * @param everDate	任意字符串时间 格式yyyy-mm-dd
	 * @param to		天数 正为此日期后 负为此日期前
	 * @return
	 */
	public static String getEverToDay(String everDate, int to) {
		Date d = DateToolsUtil.strToDate(everDate);
		SimpleDateFormat df = new SimpleDateFormat(DATEFORMAT_YMD);
		return df.format(new Date(d.getTime() + to * 24 * 60 * 60 * 1000));
	}
	/**
	 * 获取任意字符串(everDate)时间的to天前后的日期
	 * @param everDate	任意字符串时间 格式yyyy-mm-dd
	 * @param to		天数 正为此日期后 负为此日期前
	 * @return
	 */
	public static Date getEverToDay(Date everDate, int to) {
				return new Date(everDate.getTime() + to * 24 * 60 * 60 * 1000);
	}
	/**时         分        秒        毫秒
	 * 24 * 60 * 60 * 1000
	 * @param everDate
	 * @param to
	 * @return
	 */
	public static String getEverToTime(String everDate, int to) {
		Date d = DateToolsUtil.strToDate(everDate);
		SimpleDateFormat df = new SimpleDateFormat(DATEFORMAT_YMD);
		return df.format(new Date(d.getTime() + to));
	}
	/**  
	 * 获得当前年份  
	 *   
	 * @return  
	 */
	public static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**  
	 * 获得当前月份  
	 *   
	 * @return  
	 */
	public static int getMonth() {
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}
	
	/**  
	 * 获得当前小时  
	 *   
	 * @return  
	 */
	public static int getHour() {
		return Calendar.getInstance().get(Calendar.HOUR) + 1;
	}

	/**  
	 * 获得今天在本年的第几天  
	 *   
	 * @return  
	 */
	public static int getDayOfYear() {
		return Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
	}

	/**  
	 * 获得今天在本月的第几天(获得当前日)  
	 *   
	 * @return  
	 */
	public static int getDayOfMonth() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	/**  
	 * 获得今天在本周的第几天  
	 *   
	 * @return  
	 */
	public static int getDayOfWeek() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}

	/**  
	 * 获得今天是这个月的第几周  
	 *   
	 * @return  
	 */
	public static int getWeekOfMonth() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK_IN_MONTH);
	}

	/**  
	 * 获得半年后的日期  
	 *   
	 * @return  
	 */
	public static Date getTimeYearNext() {
		Calendar.getInstance().add(Calendar.DAY_OF_YEAR, 183);
		return Calendar.getInstance().getTime();
	}

	/**  
	 * 将日期转换成字符串  
	 *   
	 * @param dateTime  
	 * @return  
	 */
	public static String convertDateToString(Date dateTime) {
		SimpleDateFormat df = new SimpleDateFormat(DATEFORMAT_YMD);
		return df.format(dateTime);
	}

	/**  
	 * 得到二个日期间的间隔天数  
	 *   
	 * @param sj1  
	 * @param sj2  
	 * @return  
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat(DATEFORMAT_YMD);
		long day = 0;
		try {
			java.util.Date date = myFormatter.parse(sj1);
			java.util.Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**  
	 * 根据一个日期，返回是星期几的字符串  
	 *   
	 * @param sdate  
	 * @return  
	 */
	public static String getWeek(String sdate) {
		// 再转换为时间   
		Date date = DateToolsUtil.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);   
		// hour中存的就是星期几了，其范围 1~7   
		// 1=星期日 7=星期六，其他类推   
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	/**  
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd  
	 *   
	 * @param strDate  
	 * @return  
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATEFORMAT_YMD);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
	
	/**  
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 *   
	 * @param strDate  
	 * @return  
	 */
	public static Date str2Date(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATEFORMAT_YMD_HMS);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
	/**
	 * 将日期转换成格式化字符串
	 * @param date			日期转换成格式化字符串
	 * @param dateFormat	日期格式化形式
	 * @return				格式化后日期的字符串
	 */
	public static String getNowDate() {

		String str = null;

		try {

			SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT_YMD_HMS);
			str = sdf.format(new Date());

		} catch (Exception e) {

			e.printStackTrace();

		}

		return str;

	}
	
	/**
	 * 将日期转换成格式化字符串
	 * @param date			日期转换成格式化字符串
	 * @param dateFormat	日期格式化形式
	 * @return				格式化后日期的字符串
	 */
	public static String dateToStr(Date date, String dateFormat) {

		String str = null;

		try {

			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			str = sdf.format(date);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return str;

	}

	/**  
	 * 两个时间之间的天数  
	 *   
	 * @param date1  
	 * @param date2  
	 * @return  
	 */
	public static long getDays(String date1, String date2) {
		if (date1 == null || "".equals(date1))
			return 0;
		if (date2 == null || "".equals(date2))
			return 0;
		// 转换为标准时间   
		SimpleDateFormat myFormatter = new SimpleDateFormat(DATEFORMAT_YMD);
		java.util.Date date = null;
		java.util.Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	/**  
	 * 计算当月最后一天,返回字符串  
	 *   
	 * @return  
	 */
	public static String getDefaultDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT_YMD);

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号   
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号   
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天   

		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**  
	 * 上月第一天  
	 *   
	 * @return  
	 */
	public String getPreviousMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT_YMD);

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号   
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号   
		// lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天   

		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**  
	 * 获取当月第一天  
	 *   
	 * @return  
	 */
	public String getFirstDayOfMonth() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT_YMD);

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号   
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**  
	 * 获得本周星期日的日期  
	 *   
	 * @return  
	 */
	public String getCurrentWeekday() {
		weeks = 0;
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	/**  
	 * 获取当天时间  
	 *   
	 * @param dateformat  
	 * @return  
	 */
	public String getNowTime(String dateformat) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式   
		String hehe = dateFormat.format(now);
		return hehe;
	}

	/**  
	 * 获得当前日期与本周日相差的天数  
	 *   
	 * @return  
	 */
	private int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......   
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1   
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}

	/**  
	 * 获得本周一的日期  
	 *   
	 * @return  
	 */
	public String getMondayOFWeek() {
		weeks = 0;
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	/**  
	 * 获得相应周的周六的日期  
	 *   
	 * @return  
	 */
	public String getSaturday() {
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	/**  
	 * 获得上周星期日的日期  
	 *   
	 * @return  
	 */
	public String getPreviousWeekSunday() {
		weeks = 0;
		weeks--;
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + weeks);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	/**  
	 * 获得上周星期一的日期  
	 *   
	 * @return  
	 */
	public String getPreviousWeekday() {
		weeks--;
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	/**  
	 * 获得下周星期一的日期  
	 */
	public String getNextMonday() {
		weeks++;
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	/**  
	 * 获得下周星期日的日期  
	 */
	public String getNextSunday() {

		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	@SuppressWarnings("unused")
	private int getMonthPlus() {
		Calendar cd = Calendar.getInstance();
		int monthOfNumber = cd.get(Calendar.DAY_OF_MONTH);
		cd.set(Calendar.DATE, 1);// 把日期设置为当月第一天   
		cd.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天   
		MaxDate = cd.get(Calendar.DATE);
		if (monthOfNumber == 1) {
			return -MaxDate;
		} else {
			return 1 - monthOfNumber;
		}
	}

	/**  
	 * 获得上月最后一天的日期  
	 *   
	 * @return  
	 */
	public String getPreviousMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT_YMD);

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月   
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天   
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天   
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**  
	 * 获得下个月第一天的日期  
	 *   
	 * @return  
	 */
	public String getNextMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT_YMD);

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// 减一个月   
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天   
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**  
	 * 获得下个月最后一天的日期  
	 *   
	 * @return  
	 */
	public String getNextMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT_YMD);

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// 加一个月   
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天   
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天   
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**  
	 * 获得明年最后一天的日期  
	 *   
	 * @return  
	 */
	public String getNextYearEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT_YMD);

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// 加一个年   
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		lastDate.roll(Calendar.DAY_OF_YEAR, -1);
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**  
	 * 获得明年第一天的日期  
	 *   
	 * @return  
	 */
	public String getNextYearFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT_YMD);

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// 加一个年   
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		str = sdf.format(lastDate.getTime());
		return str;

	}

	/**  
	 * 获得本年有多少天  
	 *   
	 * @return  
	 */
	@SuppressWarnings("unused")
	private int getMaxYear() {
		Calendar cd = Calendar.getInstance();
		cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天   
		cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。   
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		return MaxYear;
	}

	private int getYearPlus() {
		Calendar cd = Calendar.getInstance();
		int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);// 获得当天是一年中的第几天   
		cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天   
		cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。   
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		if (yearOfNumber == 1) {
			return -MaxYear;
		} else {
			return 1 - yearOfNumber;
		}
	}

	/**  
	 * 获得本年第一天的日期  
	 *   
	 * @return  
	 */
	public String getCurrentYearFirst() {
		int yearPlus = this.getYearPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, yearPlus);
		Date yearDay = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preYearDay = df.format(yearDay);
		return preYearDay;
	}

	// 获得本年最后一天的日期 *   
	public String getCurrentYearEnd() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式   
		String years = dateFormat.format(date);
		return years + "-12-31";
	}

	// 获得上年第一天的日期 *   
	public String getPreviousYearFirst() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式   
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);
		years_value--;
		return years_value + "-1-1";
	}

	// 获得上年最后一天的日期   
	public String getPreviousYearEnd() {
		weeks--;
		int yearPlus = this.getYearPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, yearPlus + MaxYear * weeks
				+ (MaxYear - 1));
		Date yearDay = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preYearDay = df.format(yearDay);
		return preYearDay;
	}

	/**  
	 * 获得本季度第一天  
	 *   
	 * @param month  
	 * @return  
	 */
	public String getThisSeasonFirstTime(int month) {
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3) {
			season = 1;
		}
		if (month >= 4 && month <= 6) {
			season = 2;
		}
		if (month >= 7 && month <= 9) {
			season = 3;
		}
		if (month >= 10 && month <= 12) {
			season = 4;
		}
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式   
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);

		int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);   
		@SuppressWarnings("unused")
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + start_month + "-" + start_days;
		return seasonDate;

	}

	/**  
	 * 获得本季度最后一天  
	 *   
	 * @param month  
	 * @return  
	 */
	public String getThisSeasonFinallyTime(int month) {
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3) {
			season = 1;
		}
		if (month >= 4 && month <= 6) {
			season = 2;
		}
		if (month >= 7 && month <= 9) {
			season = 3;
		}
		if (month >= 10 && month <= 12) {
			season = 4;
		}
		@SuppressWarnings("unused")
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式   
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);

		@SuppressWarnings("unused")
		int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);   
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + end_month + "-" + end_days;
		return seasonDate;

	}

	/**  
	 * 获取某年某月的最后一天  
	 *   
	 * @param year  
	 *            年  
	 * @param month  
	 *            月  
	 * @return 最后一天  
	 */
	private int getLastDayOfMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			return 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		if (month == 2) {
			if (isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		}
		return 0;
	}

	/**  
	 * 是否闰年  
	 *   
	 * @param year  
	 *            年  
	 * @return  
	 */
	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	/**  
	 * 是否闰年  
	 *   
	 * @param year  
	 * @return  
	 */
	public boolean isLeapYear2(int year) {
		return new GregorianCalendar().isLeapYear(year);
	}
	
	/**
	 * 对比时间
	 * @param dt1
	 * @param dt2
	 * @return 【-1 小于】dt1 在dt2前       【0】相等      【1 大于】dt1在dt2后
	 */
	public static int compareTime(Date dt1, Date dt2){
	
		if (dt1.getTime() > dt2.getTime()) {
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            return -1;
        } else {
            return 0;
        }

	}
	
    /** 
     * 根据日期获得星期 
     * @param date 
     * @return 
     */ 
	public static String getWeekOfDate(Date date) { 
//	  String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" }; 
	  String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" }; 
	  Calendar calendar = Calendar.getInstance(); 
	  calendar.setTime(date); 
	  int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
	  return weekDaysCode[intWeek]; 
	} 
	
	/**
	* 获取日期星期一日期
	* 
	* @param 指定日期
	* @return date
	*/
	public static Date getFirstDayOfWeek(Date date) {
	    if (date == null) {
	       return null;
	     }
	    Calendar gregorianCalendar= new GregorianCalendar();
		gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek()); // Monday
		return gregorianCalendar.getTime();
	}
	
	/**
	 * @Title: getDayOfNextOrBefore   
	 * @Description: 根据日期获取上x个月或者下x个月的日期
	 * @param: @param date 当前日期
	 * @param: @param x 加减月数 正为此日期后x月 负为此日期前x月
	 * @param: @return
	 * @author: weizl
	 * @return: Date
	 * @date: 2017年5月21日 下午1:22:57      
	 * @throws
	 * @version: V1.0
	 */
	public static Date getDayOfNextOrBefore(Date date, int x) {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + x);
        date = calendar.getTime();
        return date;
	}
	
}
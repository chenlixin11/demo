package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @create 2007-7-9
 */
public class SystemUtil {
	/**
	 * 产生随机字符串(长度为32位)
	 * 
	 * @return
	 */
	public static String getUNID() {
		return getUNID(0, 32);
	}

	public static String getUNID(long lngSeed) {
		return getUNID(lngSeed, 32);
	}

	public static String getUNID(int iLength) {
		return getUNID(0, iLength);
	}

	// woodliang添加

	public static String getNowTime() {
		TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
		TimeZone.setDefault(tz);
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		String sysDate = time.format(nowTime);
		return sysDate;
	}

	public static String getNowTime2() {
		TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
		TimeZone.setDefault(tz);
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sysDate = time.format(nowTime);
		return sysDate;
	}

	public static String getNowTime3() {
		TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
		TimeZone.setDefault(tz);
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
		String sysDate = time.format(nowTime);
		return sysDate;
	}

	/**
	 * 得到日期字符串
	 * 
	 * @return String
	 */

	public static String getNowDate() {
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = time.format(nowTime);
		return sysDate;
	}

	/**
	 * 得到昨天日期字符串
	 * 
	 * @return String
	 */
	public static String getYesDate() {
		Date nowTime = new Date();
		Date yesTime = new Date(nowTime.getTime() - 24 * 60 * 60 * 1000);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = time.format(yesTime);
		return sysDate;
	}

	/**
	 * 得到明天日期字符串
	 * 
	 * @return
	 */
	public static String getTomDate() {
		Date nowTime = new Date();
		Date tomTime = new Date(nowTime.getTime() + 24 * 60 * 60 * 1000);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = time.format(tomTime);
		return sysDate;
	}

	/**
	 * 根据带时间的字符串返回不带时间的字符串
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getDateStr(String dateStr) {
		long t1 = Date.parse(dateStr.replace("-", "/"));
		// Date nowTime = new Date();
		Date tomTime = new Date(t1);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = time.format(tomTime);
		return sysDate;
	}

	/**
	 * 根据带时间的字符串返回不带时间的加一天的字符串
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getTomDateStr(String dateStr) {
		long t1 = Date.parse(dateStr.replace("-", "/"));
		// Date nowTime = new Date();
		Date tomTime = new Date(t1 + 24 * 60 * 60 * 1000);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = time.format(tomTime);
		return sysDate;
	}

	/**
	 * 根据带时间的字符串返回不带时间的减一天的字符串
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getYesDateStr(String dateStr) {
		long t1 = Date.parse(dateStr.replace("-", "/"));
		// Date nowTime = new Date();
		Date tomTime = new Date(t1 - 24 * 60 * 60 * 1000);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = time.format(tomTime);
		return sysDate;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(String date) {
		String cyDate = date;
		if (date.length() <= 10) {
			String[] dates = cyDate.split("-");
			String dateStr = "";
			for (String dat : dates) {
				if (dat.length() == 1) {
					dateStr = dateStr + "0" + dat + "-";
				} else {
					dateStr = dateStr + dat + "-";
				}
			}
			if (dateStr.endsWith("-")) {
				dateStr = dateStr.substring(0, dateStr.lastIndexOf("-"));
			}
			return dateStr;
		} else {
			String[] dateS = cyDate.split(":");
			String dateStr = "";
			for (String dat : dateS) {
				String[] dates = dat.split("-");
				for (String dat1 : dates) {
					if (dat1.length() == 1) {
						dateStr = dateStr + "0" + dat1 + "-";
					} else {
						dateStr = dateStr + dat1 + "-";
					}
				}
				if (dateStr.endsWith("-")) {
					dateStr = dateStr.substring(0, dateStr.lastIndexOf("-"));
				}
				dateStr = dateStr + ":";
			}
			if (dateStr.endsWith(":")) {
				dateStr = dateStr.substring(0, dateStr.lastIndexOf(":"));
			}
			return dateStr;
		}
	}

	/**
	 * 判断两个日期字符串的大小,若dateStr1大于等于dateStr2 返回 true；
	 * 
	 * @param dateStr1
	 *            日期
	 * @param dateStr2
	 *            日期
	 * @param flag
	 *            操作标识：0 代表：>= ,1 代表：> 2 代表：==
	 * @return
	 */
	public static boolean getDateBig(String dateStr1, String dateStr2, int flag) {
		boolean temp = false;
		long date1 = Date.parse(dateStr1.replace("-", "/"));
		long date2 = Date.parse(dateStr2.replace("-", "/"));
		if (flag == 0) {
			if (date1 >= date2) {
				temp = true;
			}
		}
		if (flag == 1) {
			if (date1 > date2) {
				temp = true;
			}
		}
		if (flag == 2) {
			if (date1 == date2) {
				temp = true;
			}
		}
		return temp;
	}

	public static boolean checkNull(Object obj) {
		boolean isIt = true;
		if (obj == null)
			isIt = false;
		else if (obj.toString().trim().equals(""))
			isIt = false;
		return isIt;
	}

	public static String getUNID(long lngSeed, int iLength) {
		String strCHARLIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int iCHARLISTLEN = strCHARLIST.length();
		String strID = "";
		int iPos;
		Random random;
		if (lngSeed == 0) {
			random = new Random();
		} else {
			random = new Random(lngSeed);
		}
		if (iLength < 1)
			iLength = 1;
		for (int i = 0; i < iLength; i++) {
			iPos = random.nextInt(iCHARLISTLEN);
			strID += strCHARLIST.charAt(iPos);
		}
		return strID;
	}

	public static void main(String[] args) throws ParseException {

		System.out.println("日期差： "
				+ SystemUtil.getDays("2009-09-10", "2009-12-10"));
		System.out.println("日期差： "
				+ SystemUtil.getDays("2010-05-01", "2010-06-17"));
		System.out.println(getUNID(0,3));
	}

	public static String numtochinese(String input) {
		String s1 = "零壹贰叁肆伍陆柒捌玖";
		String s4 = "分角整元拾佰仟万拾佰仟亿拾佰仟";
		String temp = "";
		String result = "";
		if (input == null)
			return "输入字串不是数字串只能包括以下字符（'0'～'9'，'.')，输入字串最大只能精确到仟亿，小数点只能两位！";
		temp = input.trim();
		float f;
		try {
			f = Float.parseFloat(temp);
		} catch (Exception e) {
			return "输入字串不是数字串只能包括以下字符（'0'～'9'，'.')，输入字串最大只能精确到仟亿，小数点只能两位！";
		}
		int len = 0;
		if (temp.indexOf(".") == -1)
			len = temp.length();
		else
			len = temp.indexOf(".");
		if (len > s4.length() - 3)
			return ("输入字串最大只能精确到仟亿，小数点只能两位！");
		int n1, n2 = 0;
		String num = "";
		String unit = "";

		for (int i = 0; i < temp.length(); i++) {
			if (i > len + 2) {
				break;
			}
			if (i == len) {
				continue;
			}
			n1 = Integer.parseInt(String.valueOf(temp.charAt(i)));
			num = s1.substring(n1, n1 + 1);
			n1 = len - i + 2;
			unit = s4.substring(n1, n1 + 1);
			if (num.equalsIgnoreCase("零")) {
				result = result.concat(num);
			} else {
				result = result.concat(num).concat(unit);
			}
		}
		if ((len == temp.length()) || (len == temp.length() - 1))
			result = result.concat("整");
		if (len == temp.length() - 2)
			result = result.concat("零分");
		return result;
	}

	public static String getSQLDate(Object start, Object end, String poFd) {
		String sql = " AND 2=2";
		if (checkNull(start))
			sql = sql + " AND " + poFd + ">='" + start.toString().trim() + "'";
		if (checkNull(end))
			sql = sql + " AND " + poFd + "<='" + end.toString().trim() + "'";
		return sql;
	}

	public static Integer getAge(String birthday) {
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		Integer d1 = Integer.parseInt(birthday.substring(0, 4));
		Integer age = Integer.parseInt(time.format(nowTime).substring(0, 4))
				- d1;
		try {
			Date birthdate = time.parse(birthday);
			birthdate.setYear(birthdate.getYear() + age);
			if (birthdate.after(nowTime))
				age = age - 1;

		} catch (Exception ex) {

		}
		return age;
	}

	/**
	 * 得到两个日期相差天数
	 * 
	 * @param date1
	 *            结束日期
	 * @param date2
	 *            开始日期
	 * @return
	 * @throws ParseException
	 */
	public static String getDays(String date1, String date2)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_start = sdf.parse(date1);
		Date date_end = sdf.parse(date2);
		Calendar cal_start = Calendar.getInstance();
		Calendar cal_end = Calendar.getInstance();
		cal_start.setTime(date_start);
		cal_end.setTime(date_end);
		String days = getDaysBetween(cal_start, cal_end);
		return days;
	}

	public static String getDaysBetween(Calendar d1,
			Calendar d2) throws ParseException {
		if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR)
				- d1.get(Calendar.DAY_OF_YEAR);
		return String.valueOf(days);
	}

	/**
	 * 取得指定日期以后某月的日期。如果要得到以前月份的日期，参数用负数。 注意，可能不是同一日子，例如2003-1-31加上一个月

是2003-2-28
	 *
	 * @param date
	 *            基准日期
	 * @param months
	 *            增加的月份数
	 * @return 增加以后的日期
	 */
	public static String addMonths(Date date, int months) {
		return add(date, months, Calendar.MONTH);
	}

	/**
	 * 内部方法。为指定日期增加相应的天数或月数
	 *
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增加的数量
	 * @param field
	 *            增加的单位，年，月或者日
	 * @return 增加以后的日期
	 */
	private static String add(Date date, int amount, int field) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = time.format(calendar.getTime());
		return sysDate;
	}

	public static Date getDate(String date) {
		Date date2 = new Date();
		try {
			java.text.DateFormat df2 = new SimpleDateFormat(
					"yyyy-MM-dd");
			date2 = df2.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date2;
	}
	/**
	 * 根据年份和月份字符串获取当前月的最后一天日期
	 * @param strdate
	 * @return
	 */
	public static String getMonthEnd(String year,String month)
    {
		String date=year+"-"+month+"-01";
		Date date1 = getDate(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date1);		
		c.roll(Calendar.DATE, -1); //日期回滚一天，也就是最后一天		
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String end=sdf.format(c.getTime());
        return end;
    }

	/**
	 * 根据年份和月份字符串获取当前月的总天数
	 * @param strdate
	 * @return
	 */
	public static int getMonthDays(String year,String month)
    {
		String date=year+"-"+month+"-01";
		Date date1 = getDate(date);
		Calendar calendar = new GregorianCalendar();
	    calendar.setTime(date1);
		int dayEnd=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return dayEnd;
    }
	/**
	 * 根据年份和月份字符串获取当前月的上一个月的最后一天日期
	 * @param strdate
	 * @return
	 */
	public static String getLastMonthEnd(String year,String month)
    {		
		int monthn=Integer.parseInt(month);
		int yearn=Integer.parseInt(year);
		if(monthn>1)
			monthn--;
		else{
			yearn--;
			monthn=12;
		}
		String years=String.valueOf(yearn);
		String months=String.valueOf(monthn);
        int dayn=getMonthDays(years,months);
        return years+"-"+months+"-"+dayn;
    }
	
	
	/**
	 * 根据字符串的日期获取当前对应的星期几
	 * 
	 * @param date
	 * @return 返回范围为1-7
	 */
	public static int getWeekDay(String date) {
		Date date1 = getDate(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date1);
		return c.get(Calendar.DAY_OF_WEEK);
	}
	/**
	 * 根据年份和月份获取该月份第一天对应的星期数
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getStartWeekDay(String year,String month){
		String date=year+"-"+month+"-01";
		return getWeekDay(date);
	}
	/**
	 * 根据年份和月份获取该月份最后一天对应的星期数
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getEndWeekDay(String year,String month){
		String date=year+"-"+month+"-01";
		Date date1 = getDate(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date1);		
		c.roll(Calendar.DATE, -1); //日期回滚一天，也就是最后一天
		return c.get(Calendar.DAY_OF_WEEK);
	}
	
	
}

package org.trustel.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.trustel.common.DefaultListItem;
import org.trustel.common.IListItem;
import org.trustel.common.Utils;


/**
 * 
 * @author ��־��<br>
 *         ��ĸ ���ڻ�ʱ��Ԫ�� ��ʾ ʾ�� <br>
 *         G Era ��־�� Text AD <br>
 *         y �� Year 1996; 96 M ���е��·� Month July; Jul; 07 <br>
 *         w ���е����� Number 27 <br>
 *         W �·��е����� Number 2 <br>
 *         D ���е����� Number 189 <br>
 *         d �·��е����� Number 10 <br>
 *         F �·��е����� Number 2 E �����е����� Text Tuesday; Tue <br>
 *         a Am/pm ��� Text PM <br>
 *         H һ���е�Сʱ����0-23�� Number 0 <br>
 *         k һ���е�Сʱ����1-24�� Number 24 <br>
 *         K am/pm �е�Сʱ����0-11�� Number 0 <br>
 *         h am/pm �е�Сʱ����1-12�� Number 12 <br>
 *         m Сʱ�еķ����� Number 30 <br>
 *         s �����е����� Number 55 <br>
 *         S ������ Number 978 <br>
 *         z ʱ�� General time zone Pacific Standard Time; PST; GMT-08:00 <br>
 *         Z ʱ�� RFC 822 time zone -0800 <br>
 * 
 * 
 */
public class DateUtils {
	
	private static Log logger = LogFactory.getLog("DateUtils");
	
	public static int TIME_MONTH = Calendar.MONTH;

	public static final int TIME_HOUROFDAY = Calendar.HOUR_OF_DAY;

	public static int TIME_DAYOFMONTH = Calendar.DAY_OF_MONTH;
	public static int TIME_DAYOFYEAR = Calendar.DAY_OF_YEAR;

	public static final int TIME_MINUTE = Calendar.MINUTE;

	public static final int TIME_SECOND = Calendar.SECOND;
	public static int TIME_YEAR = Calendar.YEAR;

	public static int TIME_DAYOFWEEK = Calendar.DAY_OF_WEEK;
	
	public static int TIME_HOUR = Calendar.HOUR;

	/**
	 * ��������
	 * 
	 * @param date
	 *            Դ
	 * @param part
	 *            ��������
	 * @param value
	 *            �ı�ֵ
	 * @return ����������
	 */
	public static Date add(Date date, int part, int value) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(part, value);
		return calendar.getTime();
	}

	/**
	 * ȡ�������ڵĲ�ֵ
	 * 
	 * @param from
	 *            ��ʼʱ��
	 * @param to
	 *            ����ʱ��
	 * @param part
	 *            Time_Minute--��ض��ٷ�,Time_HourOfDay-ʱ��other-��
	 * @return ��ֵ
	 */
	public static long diff(Date from, Date to, int part) {
		if (to == null || from == null)
			return 0;
		long d = to.getTime() - from.getTime();
		switch (part) {
		case TIME_MINUTE:
			return d / 1000 / 60;
		case TIME_HOUROFDAY:
			return d / 1000 / 60 / 60;
		default:
			return d / 1000 / 60 / 60 / 24;
		}

	}

	/**
	 * ���ڸ�ʽ������
	 * 
	 * @param date
	 * @param format
	 * @param timeZone
	 *            ʱ���綫����GMT+8
	 * @return
	 */
	public static String format(Date date, String format, String timeZone) {

		if (date == null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		if (timeZone != null && !timeZone.trim().equals(""))
			formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
		return formatter.format(date);
	}

	/**
	 * ��ȡ���ڵĲ�������
	 * 
	 * @param date
	 * @param part
	 * @param timeZone
	 *            ʱ����GMT+8
	 * @return
	 */
	public static int getDatePart(Date date, int part, String timeZone) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (timeZone != null && !timeZone.trim().equals(""))
			calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
		int ret = calendar.get(part);
		if (part == TIME_MONTH)
			ret++;
		return ret;

	}

	/**
	 * ʱ��ת��
	 * 
	 * @param date
	 * @param locate
	 * @return
	 */
	public static Date get(Date date, String locate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (locate != null && !locate.trim().equals(""))
			calendar.setTimeZone(TimeZone.getTimeZone(locate));
		return calendar.getTime();
	}

	/**
	 * ȡ��ʱ���·ݵ�����
	 * 
	 * @param date
	 * @return
	 */
	public static int getDay(Date date, String timeZone) {
		Calendar cal = new GregorianCalendar(getYear(date, timeZone),
				getMonth(date, timeZone), 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	}

	/**
	 * ����
	 * 
	 * @return List/DefaultListItem/IListItem
	 */
	public static List<IListItem> getDays(Date date, String timeZone) {
		List<IListItem> list = new ArrayList<IListItem>();

		for (int i = 1; i <= Utils.getDay(date, timeZone); i++) {
			list.add(new DefaultListItem(i));
		}
		return list;
	}

	/**
	 * ȡ��ʱ���е�Сʱ
	 * 
	 * @param date
	 * @return
	 */
	public static int getHour(Date date) {

		return getTimePart(date, Calendar.HOUR_OF_DAY, "");

	}

	/**
	 * Сʱ
	 * 
	 * @return List/DefaultListItem/IListItem
	 */
	public static List<IListItem> getHours() {
		List<IListItem> list = new ArrayList<IListItem>();
		for (int i = 1; i <= 24; i++) {
			list.add(new DefaultListItem(i));
		}
		return list;
	}

	/**
	 * ȡ��ʱ���еķ���
	 * 
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {

		return getTimePart(date, Calendar.MINUTE, "");

	}

	/**
	 * ����
	 * 
	 * @return List/DefaultListItem/IListItem
	 */
	public static List<IListItem> getMinutes() {
		List<IListItem> list = new ArrayList<IListItem>();
		for (int i = 1; i <= 60; i++) {
			list.add(new DefaultListItem(i));
		}
		return list;
	}

	/**
	 * ȡ��ʱ���е��·�
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date, String timeZone) {

		return getTimePart(date, Calendar.MONTH, timeZone);

	}

	/**
	 * ����
	 * 
	 * @return List/DefaultListItem/IListItem
	 */
	public static List<IListItem> getMonths() {
		List<IListItem> list = new ArrayList<IListItem>();
		for (int i = 1; i <= 12; i++) {
			list.add(new DefaultListItem(i));
		}
		return list;
	}

	/**
	 * ��ȡ���ڵĲ�������
	 * 
	 * @param date
	 * @param part
	 * @param timeZone
	 *            ʱ����GMT+8
	 * @return
	 */
	public static int getTimePart(Date date, int part, String timeZone) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (timeZone != null && !timeZone.trim().equals(""))
			calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
		return calendar.get(part);

	}

	/**
	 * ȡ��ǰ����
	 * 
	 * @param includeHours
	 *            �Ƿ����ʱ��
	 * @param zone
	 *            ʱ��
	 * @return Date
	 */
	public static Date getToday(boolean includeHours, String zone) {
		if (includeHours)
			return get(new Date(), zone);
		else
			return valueOf(format(new Date(), "yyyy-MM-dd", zone), "yyyy-MM-dd");
	}

	/**
	 * ȡ��ʱ���е��������
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date, String timeZone) {

		return getTimePart(date, Calendar.YEAR, timeZone);

	}

	/**
	 * �ַ�ת��Ϊ���ڡ�
	 * 
	 * @param source
	 * @param patterns���ڸ�ʽ����yyyy
	 *            -MM-dd HH:mm:ss
	 * @return
	 */
	public static Date stringToDate(String source, String patterns) {
		return stringToDate(source, patterns, true);
	}

	/**
	 * �ַ�ת��Ϊ���ڡ�
	 * 
	 * @param source
	 * @param patterns���ڸ�ʽ����yyyy
	 *            -MM-dd HH:mm:ss
	 * @param locate
	 *            true--ת��Ϊ������ʱ��
	 * @return
	 */
	public static Date stringToDate(String source, String patterns,
			boolean locate) {
		if (locate)
			return stringToDate(source, patterns, "GMT+8");
		else
			return stringToDate(source, patterns, "");
	}

	/**
	 * �ַ���ת��Ϊָ��ʱ��ʱ��
	 * 
	 * @param source
	 * @param patterns
	 * @param timeZone�綫����GMT
	 *            +8
	 * @return
	 */
	public static Date stringToDate(String source, String patterns,
			String timeZone) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(patterns);
		Date date = null;
		if (source == null)
			return date;
		if (timeZone != null && !timeZone.trim().equals(""))
			dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		try {
			date = dateFormat.parse(source);
		} catch (java.text.ParseException e) {
			logger.info("[string to date]" + e.getMessage());
		}

		return date;
	}

	/**
	 * �ַ�ת��Ϊ���ڡ�
	 * 
	 * @param source
	 * @param patterns���ڸ�ʽ����yyyy
	 *            -MM-dd HH:mm:ss
	 * @return
	 */
	public static Date valueOf(String source, String patterns) {
		return valueOf(source, patterns, "GMT+8");
	}

	/**
	 * �ַ���ת��Ϊָ��ʱ��ʱ��
	 * 
	 * @param value
	 * @param patterns
	 *            ��yyyy-MM-dd HH:mm:ss
	 * @param timeZone�綫����GMT
	 *            +8
	 * @return
	 */
	public static Date valueOf(String value, String patterns, String timeZone) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(patterns);
		Date date = null;
		if (value == null)
			return date;
		if (timeZone != null && !timeZone.trim().equals(""))
			dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		try {
			date = dateFormat.parse(value);
		} catch (java.text.ParseException e) {
			logger.info("[string to date]" + e.getMessage());
		}

		return date;
	}

	/**
	 * �ַ���ת��Ϊָ��ʱ��ʱ��
	 * 
	 * Ĭ�ϸ����ִ����ȸ�ʽΪyyyy-MM-dd��yyyy-MM-dd HH:mm
	 * 
	 * @param value
	 *            ����
	 * @param timeZone
	 *            timeZone�綫����GMT+8
	 * @return
	 */
	public static Date valueOfA(String value, String timeZone) {
		if (value == null || value.length() == 10)
			return valueOf(value, "yyyy-MM-dd", timeZone);
		else
			return Utils.valueOf(value, "yyyy-MM-dd HH:mm", timeZone);
	}
}

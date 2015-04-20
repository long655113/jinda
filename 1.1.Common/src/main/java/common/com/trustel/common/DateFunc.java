package com.trustel.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Administrator
 *
 * ������غ�����
 */
public class DateFunc {
	/**
	 * AM/PM
	 */
	public static final String AM_PM = "a";
	/**
	 * һ������ڼ���
	 */
	public static final String DAY_IN_MONTH = "dd";
	/**
	 * һ����ڼ���
	 */
	public static final String DAY_IN_YEAR = "DD";
	/**
	 * һ����ڼ���(Sunday,...)
	 */
	public static final String DAY_OF_WEEK = "EEEE";
	/**
	 * ����Ϊ��λ
	 */
	public static final int DIFF_DAY = Calendar.DAY_OF_MONTH;
	/**
	 * ��СʱΪ��λ
	 */
	public static final int DIFF_HOUR = Calendar.HOUR_OF_DAY;
	/**
	 * �Ժ���Ϊ��λ
	 */
	public static final int DIFF_MILLSECOND = Calendar.MILLISECOND;
	/**
	 * �Է���Ϊ��λ
	 */
	public static final int DIFF_MINUTE = Calendar.MINUTE;
	/**
	 * ���·�Ϊ��λ������ÿ��30�����
	 */
	public static final int DIFF_MONTH = Calendar.MONTH;
	/**
	 * ����Ϊ��λ
	 */
	public static final int DIFF_SECOND = Calendar.SECOND;
	/**
	 * ������Ϊ��λ������ÿ����7�����
	 */
	public static final int DIFF_WEEK = Calendar.WEEK_OF_MONTH;
	/**
	 * ����Ϊ��λ������ÿ��365�����
	 */
	public static final int DIFF_YEAR = Calendar.YEAR;
	/**
	 * ������Сʱ(0-11)
	 */
	public static final String HOUR_IN_APM = "KK";
	/**
	 * һ����Сʱ(0-23)
	 */
	public static final String HOUR_IN_DAY = "HH";
	/**
	 * ������Сʱ(1-12)
	 */
	public static final String HOUR_OF_APM = "hh";
	/**
	 *  һ����Сʱ(1-24)
	 */
	public static final String HOUR_OF_DAY = "kk";
	
	/**
	 * ��(��λ)
	 */
	public static final String LONG_YEAR = "yyyy";
	/**
	 * ����
	 */
	public static final String MILL_SECOND = "SSS";		
	/**
	 * ����
	 */
	public static final String MINUTE = "mm";
	/**
	 * ��
	 */
	public static final String MONTH = "MM";
	/**
	 * ��
	 */
	public static final String SECOND = "ss";
	/**
	 * ��(��λ)
	 */
	public static final String SHORT_YEAR = "yy";
	/**
	 * һ������ڼ���
	 */
	public static final String WEEK_IN_MONTH = "W";
	/**
	 * һ����ڼ���
	 */
	public static final String WEEK_IN_YEAR = "ww";

	/**
	 * ���Ŀ��ʱ���Ƿ��ѳ���Դʱ��ֵ����ʱ��γ���
	 * <p>
	 * �����б�ǰ�Ƿ��Ѿ���ʱ
	 * 
	 * @param destDate Ŀ��ʱ�䣬һ��Ϊ��ǰʱ��
	 * @param sourceDate Դʱ�䣬һ��Ϊ�¼�����ʱ��
	 * @param type ʱ����㵥λ��Ϊ���ӡ�Сʱ��
	 * @param elapse ����ʱ�䳤��
	 * @return �Ƿ�ʱ
	 * @throws CodedException
	 */
	public static boolean compareElapsedTime(
		Date destDate,
		Date sourceDate,
		int type,
		int elapse)
		throws RuntimeException {
		if (destDate == null || sourceDate == null)
			throw new RuntimeException("compared date invalid");
			
		return destDate.getTime() > getRelativeDate(sourceDate, type, elapse).getTime();
	}

	/**
	 * ȡ��ǰʱ���ַ���
	 * <p>
	 * ʱ���ַ�����ʽΪ����(4λ)-�·�(2λ)-����(2λ) Сʱ(2λ):����(2λ):��(2λ)
	 *  
	 * @return ʱ���ַ���
	 */
	public static String getCurrentDateString() {
		return getCurrentDateString("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * ����ʽȡ��ǰʱ���ַ���
	 * 
	 * @param formatString ��ʽ�ַ���
	 * @return
	 */
	public static String getCurrentDateString(String formatString) {
		Date currentDate = new Date();

		return getDateString(currentDate, formatString);
	}
	
	/**
	 * ȡ������һ�ܵĵڼ���
	 * @return
	 */
	public static int getCurrentDayOfWeek() {
		return getDayOfWeek(new Date());
	}
    
    public static Date getDate(Date date) {
        return getDateFromString(getDateString(date, "yyyy-MM-dd"), "yyyy-MM-dd");
    }

	/**
	 * ����ʱ���ַ�������ʱ��
	 * 
	 * @param dateString ʱ���ַ�����ʽ
	 * @return ʱ��
	 * @throws RuntimeException
	 */
	public static Date getDateFromString(String dateString)
		throws RuntimeException {
		return getDateFromString(dateString, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * �����ַ�������ʱ��
	 * 
	 * @param dateString ʱ���ַ���
	 * @param pattern ʱ���ַ�����ʽ����
	 * @return ʱ��
	 * @throws RuntimeException
	 */
	public static Date getDateFromString(String dateString, String pattern)
		throws RuntimeException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = null;

		try {
			date = dateFormat.parse(dateString);
		} catch (java.text.ParseException e) {
			throw new RuntimeException(
				"parse date string '"
					+ dateString
					+ "' with pattern '"
					+ pattern
					+ "' failed: "
					+ e.getMessage());
		}

		return date;
	}

	/**
	 * ȡʱ���ַ���
	 * 
	 * @param date ʱ��
	 * @return ʱ���ַ���
	 */
	public static String getDateString(Date date) {
		return getDateString(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * ȡʱ���ַ���
	 * 
	 * @param date ʱ��
	 * @param formatString ת����ʽ
	 * @return ʱ���ַ���
	 */
	public static String getDateString(Date date, String formatString) {
		return getDateString(date, formatString, Locale.PRC);
	}
	
	/**
	 * ȡʱ���ַ���
	 * 
	 * @param date ʱ��
	 * @param formatString ת����ʽ
	 * @param locale ����
	 * @return ʱ���ַ���
	 */
	public static String getDateString(Date date, String formatString, Locale locale) {
		if (date == null)
			return null;

		SimpleDateFormat dateFormat = new SimpleDateFormat(formatString, locale);

		return dateFormat.format(date);
	}
	
	
	/**
	 * ȡ������һ�ܵĵڼ���
	 * 
	 * @param date ����
	 * @return
	 */
	public static int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * ȡ������һ�µĵڼ���
	 * 
	 * @param date ����
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * ȡһ���µ��������
	 * 
	 * @param date ����
	 * @return
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * ȡ���������·ݵ��������
	 * 
	 * @param date ����
	 * @return
	 */
	public static int getMaximumDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.getMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ����Դʱ���ʱ������Ŀ��ʱ��
	 * 
	 * @param date Դʱ��
	 * @param type ʱ�䵥λ
	 * @param relate ʱ��
	 * @return Ŀ��ʱ��
	 */
	public static Date getRelativeDate(Date date, int type, int relate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, relate);

		return calendar.getTime();
	}
	
	/**
	 * ���ݵ�ǰʱ���ʱ������Ŀ��ʱ��
	 * 
	 * @param type ʱ�䵥λ
	 * @param relate ʱ��
	 * @return Ŀ��ʱ��
	 */
	public static Date getRelativeDate(int type, int relate) {
		Date current = new Date();

		return getRelativeDate(current, type, relate);
	}

	/**
	 * ���ݵ�ǰʱ���ʱ������Ŀ��ʱ���ַ���
	 * 
	 * @param type ʱ�䵥λ
	 * @param relate ʱ��
	 * @param formatString ʱ���ʽ
	 * @return ʱ���ַ���
	 */
	public static String getRelativeDateString(
		int type,
		int relate,
		String formatString) {
		return getDateString(getRelativeDate(type, relate), formatString);
	}
	
	public static Date getStartDate(Date date) {
		return getDateFromString(getDateString(date, "yyyyMMdd") + "00:00:00", "yyyyMMddHH:mm:ss");
	}
	
	public static Date getEndDate(Date date) {
		return getDateFromString(getDateString(date, "yyyyMMdd") + "23:59:59", "yyyyMMddHH:mm:ss");
	}
	
	/**
	 * ȡʱ����ַ���
	 *  
	 * @param date ʱ��
	 * @return ʱ����ַ���
	 */
	public static String getTimestampString(Date date) {
		return getDateString(date, "yyyyMMddHHmmssSSS");
	}

	/**
	 * ȡ��������ֵ
	 * 
	 * @return ���ڵ�����ֵ
	 */
	public static int getToday() {
		return Integer.parseInt(getCurrentDateString("dd"));
	}
    
    public static long getTimeDiff(Date fromDate, Date toDate, int type) {
        fromDate = (fromDate == null) ? new Date() : fromDate;
        toDate = (toDate == null) ? new Date() : toDate;
        long diff = toDate.getTime() - fromDate.getTime();
        
        switch(type) {
        case DIFF_MILLSECOND:
            break;
            
        case DIFF_SECOND:
            diff /= 1000;
            break;
            
        case DIFF_MINUTE:
            diff /= 1000 * 60;
            break;
            
        case DIFF_HOUR:
            diff /= 1000 * 60 * 60;
            break;
            
        case DIFF_DAY:
            diff /= 1000 * 60 * 60 * 24;
            break;
            
        case DIFF_MONTH:
            diff /= 1000 * 60 * 60 * 24 * 30;
            break;

        case DIFF_YEAR:
            diff /= 1000 * 60 * 60 * 24 * 365;
            break;
            
        default:
            diff = 0;
            break;
        }
        
        return diff;
    }
	
	/**
	 * �Ƚ�ʱ����Ƿ���ͬ
	 * 
	 * @param arg0 ʱ��
	 * @param arg1 ʱ��
	 * @return �Ƿ���ͬ
	 */
	public static boolean isTimestampEqual(Date arg0, Date arg1) {
		return getTimestampString(arg0).compareTo(getTimestampString(arg1)) == 0;
	}
	
	/**
	 * ���ݵ�ǰʱ��Ϊһ���еĵڼ�����
	 * 
	 */
	public static int getMonthOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.MONTH)+1;
	}
}

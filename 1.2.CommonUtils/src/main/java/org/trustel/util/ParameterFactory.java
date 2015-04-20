package org.trustel.util;

import java.util.Date;
import java.util.Set;

/**
 * 
 * @author ��־��
 * 
 *         �첽���²��� ParameterFactory.getInstance().exchange
 * @version 1.0.0.0 2011-03-01
 * 
 *          ϵͳ�������ʻ������������
 *          <OL>
 *          <LI>ͬһ�����в�ͬ���Ե�������Ϣ�����������Ͳ���ֵ��ͬ</LI>
 *          <LI>ͬһ���������Բ�ͬ�в�ͬ����ֵ�����Ҳ������������Բ�ͬ����ͬ</LI>
 *          </OL>
 *          ���ڵڶ������������Ӧ����Ƴɲ�ͬ�������Է������ݴ���<br />
 *          ����:
 *          ParameterFactory.getParameterUtility().get(ParameterName+
 *          Language);
 */
public class ParameterFactory {
	private static ParameterFactory instance;
	private int index = 0;

	public static final ParameterFactory getInstance() {
		if (instance == null)
			instance = new ParameterFactory();
		return instance;
	}

	/**
	 * 
	 * @param lang
	 * @return
	 */
	public static final ParameterUtility getParameterUtility() {
		return getInstance().getCurrentUtility();
	}

	private ParameterUtility[] parameters;

	private ParameterFactory() {

		parameters = new ParameterUtility[2];
		parameters[0] = new ParameterUtility();
		parameters[1] = null;
	}

	public synchronized ParameterUtility getCurrentUtility() {
		return (ParameterUtility) parameters[index];
	}

	/**
	 * �Դ�����������滻�����в���������һ�η��ʲ���ʱ��Ч
	 * 
	 * @param utility
	 */
	public synchronized final void exchange(ParameterUtility utility) {
		int next = index == 1 ? 0 : 1;
		parameters[next] = utility;  
		instance.index = next;
	}

	public static void clear() {
		getParameterUtility().clear();
	}

	public static boolean containsKey(Object key) {
		return getParameterUtility().containsKey(key);
	}

	public static boolean containsValue(Object value) {
		return getParameterUtility().containsValue(value);
	}

	public static boolean exist(String name) {
		return getParameterUtility().exist(name);
	}

	public static Object get(String name) {
		return getParameterUtility().get(name);
	}

	public static boolean getBoolean(String name) {
		return getParameterUtility().getBoolean(name);
	}

	public static boolean getBoolean(String name, boolean defaultvalue) {
		return getParameterUtility().getBoolean(name, defaultvalue);
	}

	public static Date getDate(String name) {
		return getParameterUtility().getDate(name);
	}

	public static Date getDate(String name, String format) {
		return getParameterUtility().getDate(name, format);
	}

	public static Date getDate(String name, String format, String zone) {
		return getParameterUtility().getDate(name, format, zone);
	}

	public static double getDouble(String name, double defaultValue) {
		return getParameterUtility().getDouble(name, defaultValue);
	}

	public static float getFloat(String name) {
		return getParameterUtility().getFloat(name);
	}

	public static float getFloat(String name, float defaultValue) {
		return getParameterUtility().getFloat(name, defaultValue);
	}

	public static int getInt(String name) {
		return getParameterUtility().getInt(name);
	}

	public static int getInt(String name, int defaultValue) {
		return getParameterUtility().getInt(name, defaultValue);
	}

	public static long getLong(String name) {
		return getParameterUtility().getLong(name);
	}

	public static long getLong(String name, long defaultValue) {
		return getParameterUtility().getLong(name, defaultValue);
	}

	public static String getString(String name) {
		return getParameterUtility().getString(name);
	}

	public static String getString(String name, String defaultValue) {
		return getParameterUtility().getString(name, defaultValue);
	}

	public static boolean isEmpty() {
		return getParameterUtility().isEmpty();
	}

	public static Set<String> keySet() {
		return getParameterUtility().keySet();
	}

	public static void put(String name, Object value) {
		getParameterUtility().put(name, value);
	}

	public static void put(String name, Object value, boolean replace) {
		getParameterUtility().put(name, value, replace);
	}
	
	/**
	 * ������ڣ����滻
	 * @param name
	 * @param value
	 */
	public static void set(String name, Object value) {
		getParameterUtility().set(name, value);
	}

	public static void remove(String name) {
		getParameterUtility().remove(name);
	}

	public static int size() {
		return getParameterUtility().size();
	}
}

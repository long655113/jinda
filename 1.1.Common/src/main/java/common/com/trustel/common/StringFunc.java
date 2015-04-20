package com.trustel.common;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * @author Administrator
 * 
 * �ַ���������
 */
public class StringFunc {
	/**
	 * ���ŷָ��
	 */
	public final static String COMMA_SEPARATOR = ",";

	/**
	 * �ֺŷָ���
	 */
	public final static String SEMICOLON_SEPARATOR = ";";

	/**
	 * ��б�ָܷ���
	 */
	public final static String SLASH_SEPARATOR = "/";

	/**
	 * ��б�ָܷ���
	 */
	public final static String BACKLASH_SEPARATOR = "\\";

	/**
	 * ���ŷָ���
	 */
	public final static String SUBTRACTION_SEPARATOR = "-";

	/**
	 * �º��߷ָ���
	 */
	public final static String UNDERLINE_SEPARATOR = "_";

	/**
	 * ��ָ���
	 */
	public final static String AND_SEPARATOR = "&";

	/**
	 * �Ⱥŷָ���
	 */
	public final static String EQUAL_SEPARATOR = "=";

	/**
	 * ���ŷָ���
	 */
	public final static String WELL_SEPARATOR = "#";

	public final static String NBSP = "&nbsp";

	/**
	 * �ո�
	 */
	public final static String SPACE = "";

	/**
	 * ����
	 */
	public final static String ERECT_SEPARATOR = "|";

	/**
	 * ���Էָ����ָ����ַ���ת��Ϊ�ַ�������
	 * 
	 * @param exp
	 *            ���ָ��ַ���
	 * @param separator
	 *            �ָ���
	 * @return �ָ���ַ�������
	 */
	public static String[] separate(String exp, String separator) {
		Vector array = new Vector();
		String[] strings = null;

		while (exp.indexOf(separator) != -1) {
			String part = exp.substring(0, exp.indexOf(separator));
			array.add(part);
			exp = exp.substring(exp.indexOf(separator) + 1);
		}

		if (exp != null && exp.length() > 0) {
			array.add(exp);
		}

		strings = new String[array.size()];
		for (int i = 0; i < array.size(); i++) {
			strings[i] = (String) array.elementAt(i);
		}

		return strings;
	}

	/**
	 * ���Էָ����ָ����ַ���ת��Ϊ�ַ�������(��������Ҳ�ո���Ϊһ����)
	 * 
	 * @param exp
	 *            ���ָ��ַ���
	 * @param separator
	 *            �ָ���
	 * @return �ָ���ַ�������
	 */
	public static String[] split(String exp, String separator) {
		Vector array = new Vector();
		String[] strings = null;

		while (exp.indexOf(separator) != -1) {
			String part = exp.substring(0, exp.indexOf(separator));
			array.add(part);
			exp = exp.substring(exp.indexOf(separator) + 1);
		}

		array.add(exp == null ? "" : exp);

		strings = new String[array.size()];
		for (int i = 0; i < array.size(); i++) {
			strings[i] = (String) array.elementAt(i);
		}

		return strings;
	}
	
	/**
	 * ���ַ����ָ�ΪList
	 * 
	 * @param exp
	 *            �ַ���
	 * @param separator
	 *            �ָ��
	 * @return
	 */
	public static java.util.List splitToList(String exp, String separator) {
		java.util.List list = new java.util.ArrayList();

		if (exp != null) {
			while (exp.indexOf(separator) != -1) {
				String part = exp.substring(0, exp.indexOf(separator));
				list.add(part);
				exp = exp.substring(exp.indexOf(separator) + 1);
			}

			if (exp != null && exp.length() > 0) {
				list.add(exp);
			}
		}

		return list;
	}

	/**
	 * ���Էָ����ָ����ַ���ת��Ϊ�ַ�������
	 * 
	 * @param exp
	 *            ���ָ��ַ���
	 * @param separator
	 *            �ָ���
	 * @return �ָ���ַ�������
	 */
	public static String[] separate(String exp, char separator) {
		Vector array = new Vector();
		String[] strings = null;

		while (exp.indexOf(separator) != -1) {
			String part = exp.substring(0, exp.indexOf(separator));
			array.add(part);
			exp = exp.substring(exp.indexOf(separator) + 1);
		}

		if (exp != null && exp.length() > 0) {
			array.add(exp);
		}

		strings = new String[array.size()];
		for (int i = 0; i < array.size(); i++) {
			strings[i] = (String) array.elementAt(i);
		}

		return strings;
	}

	/**
	 * ���ַ�������ת��Ϊ�Էָ����ָ����ַ���
	 * <p>
	 * ת�������н�ȥ�������ַ��������е��ظ�����
	 * 
	 * @param exps
	 *            �ַ�������
	 * @param separator
	 *            �ָ���
	 * @return �ϲ�����ַ���
	 */
	public static String union(String[] items, String separator) {
		String exp = null;

		if (items != null) {
			if (items.length == 1)
				return items[0];

			Hashtable distinctItems = new Hashtable();

			// remove duplicate string
			for (int i = 0; i < items.length; i++) {
				distinctItems.put(items[i], items[i]);
			}

			exp = union(distinctItems, separator);
		}

		return exp;
	}

	/**
	 * ���ַ�������ת��Ϊ�Էָ����ָ����ַ���
	 * <p>
	 * ת�������н�ȥ�������ַ��������е��ظ�����
	 * 
	 * @param exps
	 *            �ַ�������
	 * @param separator
	 *            �ָ���
	 * @return �ϲ�����ַ���
	 */
	public static String union(java.util.List items, String separator) {
		String exp = null;

		if (items != null) {
			if (items.size() == 1)
				return (String) items.get(0);

			Hashtable distinctItems = new Hashtable();

			// remove duplicate string
			for (int i = 0; i < items.size(); i++) {
				distinctItems.put(items.get(i), items.get(i));
			}

			exp = union(distinctItems, separator);
		}

		return exp;
	}

	/**
	 * ���ַ�������ת��Ϊ�Էָ����ָ����ַ���
	 * <p>
	 * ת�������н�ȥ�������ַ��������е��ظ�����
	 * 
	 * @param exps
	 *            �ַ�������
	 * @param separator
	 *            �ָ���
	 * @return �ϲ�����ַ���
	 */
	public static String union(Hashtable items, String separator) {
		StringBuffer buf = new StringBuffer();

		if (items != null) {
			Enumeration en = items.elements();
			while (en.hasMoreElements()) {
				buf.append(en.nextElement() + separator);
			}

			if (buf.length() > 0)
				buf.deleteCharAt(buf.length() - 1); // remove the end separator
		}

		return buf.toString();
	}

	/**
	 * �滻�մ�Ϊ'&nbsp'
	 * 
	 * @param source
	 *            Դ�ַ���
	 * @return
	 */
	public static String nullMarkup(String source) {
		return nullMarkup(source, NBSP);
	}

	/**
	 * �滻�մ�
	 * 
	 * @param source
	 *            Դ�ַ���
	 * @param markup
	 *            �滻�ַ���
	 * @return
	 */
	public static String nullMarkup(String source, String markup) {
		return (source == null || source.length() == 0) ? markup : source;
	}
}

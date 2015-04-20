package org.trustel.service.sql;

public final class QueryAction {

	public static final int BETWEEN = 8;//
	
	/**
	 * ����
	 */
	public static final int EQUAL = 0;

	/**
	 * ���ڵ���(>=)
	 */
	public static final int GE = 2;

	/**
	 * ����(>)
	 */
	public static final int GT = 6; // >

	public static final int IN = 4;

	/**
	 * С�ڵ���(<=)
	 */
	public static final int LE = 3;

	/**
	 * LIKE��SQL��ģ����ѯ
	 */
	public static final int LIKE = 1; // ģ����ѯ like

	/**
	 * LIKE (AA%)
	 */
	public static final int LIKE_POSTFIX = 102;

	/**
	 * LIKE (%AA)
	 */
	public static final int LIKE_PREFIX = 101;

	/**
	 * С��(<)
	 */
	public static final int LT = 7; // <

	/**
	 * ������ <>
	 */
	public static final int NOEQUAL = 5; // <>
	/**
	 * not in
	 */
	public static final int NOT_IN = 9;

}

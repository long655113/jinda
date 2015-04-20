package com.trustel.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author Administrator
 * 
 * ��ѯ��������ɹ�ʽ
 */
public class Formula {
	/**
	 * BigDecimal
	 */
	public final static int BIGDECIMAL = 1;

	/**
	 * BigInteger
	 */
	public final static int BIGINTEGER = 2;

	/**
	 * Binary
	 */
	public final static int BINARY = 3;

	/**
	 * Boolean
	 */
	public final static int BOOLEAN = 4;

	/**
	 * Byte
	 */
	public final static int BYTE = 5;

	/**
	 * Date
	 */
	public final static int DATE = 6;

	/**
	 * Double
	 */
	public final static int DOUBLE = 7;

	/**
	 * Float
	 */
	public final static int FLOAT = 8;

	/**
	 * Integer
	 */
	public final static int INTEGER = 9;

	/**
	 * Long
	 */
	public final static int LONG = 10;

	/**
	 * Short
	 */
	public final static int SHORT = 11;

	/**
	 * String
	 */
	public final static int STRING = 12;

	/**
	 * Text
	 */
	public final static int TEXT = 13;

	/**
	 * Time
	 */
	public final static int TIME = 14;

	/**
	 * Timestamp
	 */
	public final static int TIMESTAMP = 15;

	/**
	 * ��ʽ(�������ɹ�����֮��Ĺ�ϵ�����磺a.col1 = b.col2)
	 */
	public final static int FORMULA = 100;

	/**
	 * select���
	 */
	public final static int SELECT = 101;

	/**
	 * =
	 */
	public final static int EQ = 1;

	/**
	 * <>
	 */
	public final static int NE = 2;

	/**
	 * <
	 */
	public final static int LT = 3;

	/**
	 * <=
	 */
	public final static int LE = 4;

	/**
	 * >
	 */
	public final static int GT = 5;

	/**
	 * >=
	 */
	public final static int GE = 6;

	/**
	 * like
	 */
	public final static int LK = 7;

	/**
	 * in
	 */
	public final static int IN = 8;

	/**
	 * not in
	 */
	public final static int NI = 9;

	/**
	 * is null
	 */
	public final static int NU = 10;

	/**
	 * is not null
	 */
	public final static int NN = 11;

	/**
	 * ������
	 */
	public String name;

	/**
	 * ����
	 */
	public int type;

	/**
	 * ������
	 */
	public int operator;

	/**
	 * ֵ(�������͡��ַ������ʽ��select�������)
	 */
	public Object value;

	/**
	 * �ֶ�����Ϊ�ַ�����������Ϊ���ڵ�ʵ��������
	 * 
	 * @param name
	 *            ������
	 * @param value
	 *            ����ֵ
	 */
	public static Formula newInstance(String name, Object value) throws RuntimeException {
		Formula formula = new Formula(name, value);
		formula.setValue();
		
		return formula;
	}

	/**
	 * ������Ϊ���ڵ�ʵ��������
	 * 
	 * @param name
	 *            ������
	 * @param type
	 *            ����
	 * @param value
	 *            ����ֵ
	 */
	public static Formula newInstance(String name, int type, Object value) throws RuntimeException {
		Formula formula = new Formula(name, type, value);
		formula.setValue();
		
		return formula;
	}

	/**
	 * �ֶ�����Ϊ�ַ�����ʵ��������
	 * 
	 * @param operator
	 *            ������
	 * @param name
	 *            ������
	 * @param value
	 *            ����ֵ
	 */
	public static Formula newInstance(int operator, String name, String value) throws RuntimeException {
		Formula formula = new Formula(operator, name, value);
		formula.setValue();
		
		return formula;
	}

	/**
	 * ʵ��������
	 * 
	 * @param name
	 *            ������
	 * @param type
	 *            ��������
	 * @param operator
	 *            ������
	 * @param value
	 *            ����ֵ
	 */
	public static Formula newInstance(String name, int type, int operator, Object value) throws RuntimeException {
		Formula formula = new Formula(name, type, operator, value);
		formula.setValue();
		
		return formula;
	}
	
	private Formula() {

	}

	/**
	 * �ֶ�����Ϊ�ַ�����������Ϊ���ڵĹ��캯��
	 * 
	 * @param name
	 *            ������
	 * @param value
	 *            ����ֵ
	 */
	private Formula(String name, Object value) {
		this.name = name;
		this.type = STRING;
		this.operator = EQ;
		this.value = value;
	}

	/**
	 * ������Ϊ���ڵĹ��캯��
	 * 
	 * @param name
	 *            ������
	 * @param type
	 *            ����
	 * @param value
	 *            ����ֵ
	 */
	private Formula(String name, int type, Object value) {
		this.name = name;
		this.type = type;
		this.operator = EQ;
		this.value = value;
	}

	/**
	 * �ֶ�����Ϊ�ַ����Ĺ��캯��
	 * 
	 * @param operator
	 *            ������
	 * @param name
	 *            ������
	 * @param value
	 *            ����ֵ
	 */
	private Formula(int operator, String name, String value) {
		this.name = name;
		this.type = STRING;
		this.operator = operator;
		this.value = value;
	}

	/**
	 * @param name
	 *            ������
	 * @param type
	 *            ��������
	 * @param operator
	 *            ������
	 * @param value
	 *            ����ֵ
	 */
	private Formula(String name, int type, int operator, Object value) {
		this.name = name;
		this.type = type;
		this.operator = operator;
		this.value = value;
	}

	/**
	 * ��������Ƿ���Ч(�������δ��ֵ�Ҳ���is null��is not null���ʽ����������Ч)
	 * 
	 * @return
	 */
	public boolean isValid() {
		return !(value == null && operator != NU && operator != NN);
	}

	/**
	 * �ж�value�Ƿ���Ч��ֵ����
	 * 
	 * @return
	 */
	public boolean containValue() {
		return value != null && type != FORMULA && operator != NU && operator != NN;
	}

	/*
	 * ���ɲ�ѯ�������ʽ
	 */
	public String toString() {
		String expression = null;

		if (value == null && operator != NU && operator != NN)
			expression = "";
		else {
			String variable = (type == FORMULA) ? (String) value : "?";
			switch (operator) {
			case EQ:
				expression = name + " = " + variable;
				break;

			case NE:
				expression = name + " <> " + variable;
				break;

			case LT:
				expression = name + " < " + variable;
				break;

			case LE:
				expression = name + " <= " + variable;
				break;

			case GT:
				expression = name + " > " + variable;
				break;

			case GE:
				expression = name + " >= " + variable;
				break;

			case LK:
				expression = name + " like " + variable;
				break;

			case IN:
				expression = name
						+ " in ("
						+ ((type == FORMULA || type == SELECT) ? value : ":"
								+ name) + ")";
				break;

			case NI:
				expression = name
						+ " not in ("
						+ ((type == FORMULA || type == SELECT) ? value : ":"
								+ name) + ")";
				break;

			case NU:
				expression = name + " is null";
				break;

			case NN:
				expression = name + " is not null";
				break;
			}
		}

		return expression;
	}

	/**
	 * �����ַ�������Ϊnull
	 * 
	 * @param value
	 *            ����ֵ
	 */
	private void setValue() throws RuntimeException {
		if (value != null) {
			switch (type) {
			case BIGDECIMAL:
				if (! (value instanceof BigDecimal))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪBigDecimal��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case BIGINTEGER:
				if (! (value instanceof BigInteger))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪBigInteger��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case BINARY:
				if (! (value instanceof Byte[]))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪBinary��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case BOOLEAN:
				if (! (value instanceof Boolean))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪBoolean��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case BYTE:
				if (! (value instanceof Byte))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪByte��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case DATE:
				if (! (value instanceof Date))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪDate��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case DOUBLE:
				if (! (value instanceof Double))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪDouble��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case FLOAT:
				if (! (value instanceof Float))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪFloat��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case INTEGER:
				if (! (value instanceof Integer))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪInteger��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case LONG:
				if (! (value instanceof Long))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪLong��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case SHORT:
				if (! (value instanceof Short))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪShort��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case STRING:
				if (! (value instanceof String))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪString��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case TEXT:
				if (! (value instanceof String))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪText��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case TIME:
				if (! (value instanceof Date))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪTime��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());
				break;

			case TIMESTAMP:
				if (! (value instanceof Date))
					throw new RuntimeException("����" + name + "�����Ͷ���ΪTimeStamp��ʵ�ʸ�ֵ����Ϊ" + value.getClass().getName());

				break;
			}
		}

		if (value instanceof String && ((String) value).length() == 0)
			value = null;
	}
}
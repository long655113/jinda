package com.trustel.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 * 
 * ��ѯ����
 */
public class Condition implements Serializable {
	public final static String AND = "and";

	public final static String OR = "or";

	/**
	 * �߼�������
	 */
	public String operator;

	/**
	 * ��ʽ(����Ϊ����Formula����List<Condition>)
	 */
	public Object formula;

	/**
	 * �߼�����ΪAND��ʵ��������
	 * 
	 * @param formula
	 *            ������ʽ
	 */
	public static Condition newInstance(Object formula) throws RuntimeException {
		checkType(formula);

		return new Condition(formula);
	}

	/**
	 * ʵ��������
	 * 
	 * @param operator
	 *            ������
	 * @param formula
	 *            ������ʽ
	 * @return
	 * @throws RuntimeException
	 */
	public static Condition newInstance(String operator, Object formula)
			throws RuntimeException {
		checkType(formula);

		return new Condition(operator, formula);
	}

	private Condition() {

	}

	/**
	 * �߼�����ΪAND�Ĺ��캯��
	 * 
	 * @param formula
	 *            ������ʽ
	 */
	private Condition(Object formula) {
		this.operator = AND;
		this.formula = formula;
	}

	private Condition(String operator, Object formula) {
		this.operator = operator;
		this.formula = formula;
	}

	/**
	 * ���formula�����������Ƿ�Ϸ�
	 * 
	 * @param formula
	 * @throws RuntimeException
	 */
	private static void checkType(Object formula) throws RuntimeException {
		if (formula == null)
			throw new RuntimeException("������ʽ����Ϊ��");

		if (!(formula instanceof Formula || formula instanceof List))
			throw new RuntimeException("��ʽ���Ͳ���Ϊ��"
					+ formula.getClass().getName());
	}

	/**
	 * ���ɲ�ѯ����
	 * 
	 * @param conditions
	 *            ��������
	 * @param mainCondition
	 *            �Ƿ����������
	 * @return
	 */
	public synchronized static String toString(List conditions,
			boolean mainCondition) {
		StringBuffer buffer = new StringBuffer();
		boolean firstCondition = true;

		if (conditions != null) {
			for (int i = 0; i < conditions.size(); i++) {
				Condition condition = (Condition) conditions.get(i);
				if (condition.formula instanceof Formula) {
					if (((Formula) condition.formula).isValid()) {
						buffer.append((firstCondition ? "" : " "
								+ condition.operator)
								+ " " + condition.formula);
						firstCondition = false;
					}
				} else if (condition.formula instanceof List) {
					String sub = toString((List) condition.formula, false);
					if (sub.length() > 0) {
						buffer.append((firstCondition ? "" : " "
								+ condition.operator)
								+ " ("
								+ sub
								+ ")");
						firstCondition = false;
					}
				} else
					throw new RuntimeException(
							"Condition���formulaֻ��Ϊ����Formula��List<Condition>");

			}

			if (mainCondition && buffer.length() > 0)
				buffer.insert(0, " where");
		}

		return buffer.toString();
	}
}

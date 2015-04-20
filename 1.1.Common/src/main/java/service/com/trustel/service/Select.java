package com.trustel.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 *
 * Ƕ�׵�select���
 */
public class Select implements Serializable {
	/**
	 * ��ѯ��������磺"select a from Object"
	 */
	public String output;

	/**
	 * ��ѯ����
	 */
	public List conditions;

	/**
	 * group by���
	 */
	public String groupBy;

	/**
	 * order by ���
	 */
	public String orderBy;

	private Select() {

	}

	public Select(String output, List conditions, String groupBy, String orderBy) {
		this.output = output;
		this.conditions = conditions;
		this.groupBy = groupBy;
		this.orderBy = orderBy;
	}

	/* 
	 * ���ɲ�ѯ���
	 */
	public String toString() {
		return output + " " + Condition.toString(conditions, true)
				+ (groupBy == null ? "" : " " + groupBy)
				+ (orderBy == null ? "" : " " + orderBy);
	}
}

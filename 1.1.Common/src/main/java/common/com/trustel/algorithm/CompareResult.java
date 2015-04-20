package com.trustel.algorithm;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *  �ȽϽ��
 */
public class CompareResult implements Serializable {
	/**
	 *  �����¼
	 */
	public final static int EXTRA = 1;
	/**
	 * ��¼��ͬ
	 */
	public final static int DIFFERENT = 2;
	/**
	 * ��¼�ظ�
	 */
	public final static int DUPLICATE = 3;
	/**
	 * ԭʼ��¼
	 */
	public Object base;
	/**
	 * �������
	 */
	public int type;
	/**
	 * �������
	 */
	public String description;
	
	private CompareResult() {
		
	}
	
	public CompareResult(Object base, int type, String description) {
		this.base = base;
		this.type = type;
		this.description = description;
	}
}

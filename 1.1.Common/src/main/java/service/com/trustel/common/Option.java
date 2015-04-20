/*
 * �������� 2005-6-29
 *
 * �����������ļ�ģ��Ϊ
 * ���� > ��ѡ�� > Java > �������� > �����ע��
 */
package com.trustel.common;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * ����������
 */
public class Option implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ��������
	 */
	public String type;
	/**
	 * ��������
	 */
	public String code;
	/**
	 * ��������
	 */
	public String description;
	/**
	 * ����ֵ
	 */
	public String value;
	
	public Option() {
		
	}
	
	public Option(String type, String code, String value, String description) {
		this.type = type;
		this.code = code;
		this.value = value;
		this.description = description;
	}
}

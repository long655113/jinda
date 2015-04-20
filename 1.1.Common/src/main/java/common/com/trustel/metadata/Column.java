package com.trustel.metadata;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * ���ֶ���Ϣ
 */
public class Column implements Serializable {
	/**
	 * �ɿ�
	 */
	private final int NULLABLE = 1;

	/**
	 * �ֶ���
	 */
	public String name;
	/**
	 * �ֶ�����(��Ӧjava.sql.Types�е���������)
	 */
	public int dataType;
	/**
	 * �ֶ�������
	 */
	public String typeName;
	/**
	 * ��С
	 */
	public int size;
	/**
	 * С��λ
	 */
	public int digits;
	/**
	 * �Ƿ�ɿ�
	 */
	public boolean nullable;
	/**
	 * ȱʡֵ
	 */
	public String defaultValue;
	
	/**
	 * ��ע
	 */
	public String remark;
	
	private Column() {
		
	}
	
	public Column(String name, int dataType, String typeName, int size, int digits, int nullable, String defaultValue, String remark) {
		this.name = name;
		this.dataType = dataType;
		this.typeName = typeName;
		this.size = size;
		this.digits = digits;
		this.nullable = (nullable == NULLABLE) ? true : false;
		this.defaultValue = defaultValue;
		this.remark = remark;
	}
}

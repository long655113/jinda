package com.trustel.metadata;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * ���ݿ��ṹ��Ϣ
 */
public class Table implements Serializable {
	/**
	 * schema����
	 */
	public String schema;
	/**
	 * ������(Table��View)
	 */
	public String type;
	/**
	 * ����
	 */
	public String table;
	
	public Table(String schema, String type, String table) {
		this.schema = schema == null ? "null" : schema;
		this.type = type;
		this.table = table;
	}

}
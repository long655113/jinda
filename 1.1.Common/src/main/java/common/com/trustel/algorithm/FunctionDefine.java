package com.trustel.algorithm;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * ��������
 */
public class FunctionDefine implements Serializable {
	/**
	 * ������
	 */
	public String name;
	/**
	 * ����ʵ������
	 */
	public String className;
	/**
	 * ��������
	 */
	public String description;
	
	public FunctionDefine(String name, String className, String description) {
		this.name = name;
		this.className = className;
		this.description = description;
	}
}

package com.trustel.common;

import java.io.Serializable;

/**
 * ��������
 */
public class Argument implements Serializable {
	/**
	 *����id
	 */
	public String id;
	/**
	 *��������
	 */
	public String name;
	private Argument() {
	}
	public Argument(String id, String name) {
		this.id = id;
		this.name = name;
	}
}

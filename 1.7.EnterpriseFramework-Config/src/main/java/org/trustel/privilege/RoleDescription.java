package org.trustel.privilege;

import org.trustel.common.Description;

public class RoleDescription extends Description {
	/**
	 * ����
	 */
	private String name;

	/**
	 * 
	 * @return ����(name<--name)
	 */
	public String getName() {
		return name;
	}

	/**
	 * ��������
	 * 
	 * @param ����
	 *            (name-->name)
	 */
	public void setName(String name) {
		this.name = name;
	}
}

package org.trustel.privilege;

import org.trustel.common.Description;

public class RoleDescription extends Description {
	/**
	 * 名称
	 */
	private String name;

	/**
	 * 
	 * @return 名称(name<--name)
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 * 
	 * @param 名称
	 *            (name-->name)
	 */
	public void setName(String name) {
		this.name = name;
	}
}

package org.trustel.privilege;

import org.trustel.common.IListItem;

public class Role extends CommonRole implements IListItem {
	/**
	 * 参数描述
	 */
	private String description;

	private String lang;

	public String getCode() {
		return this.getId();
	}

	/**
	 * 参数描述
	 */
	public String getDescription() {
		return description;
	}

	public String getLang() {
		return lang;
	}

	public String getTip() {
		return description;
	}

	/**
	 * 参数描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
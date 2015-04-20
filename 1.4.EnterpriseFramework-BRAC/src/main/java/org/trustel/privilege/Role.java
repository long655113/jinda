package org.trustel.privilege;

import org.trustel.common.IListItem;

public class Role extends CommonRole implements IListItem {
	/**
	 * ��������
	 */
	private String description;

	private String lang;

	public String getCode() {
		return this.getId();
	}

	/**
	 * ��������
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
	 * ��������
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
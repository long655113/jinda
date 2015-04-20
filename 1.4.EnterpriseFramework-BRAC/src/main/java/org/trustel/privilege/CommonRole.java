package org.trustel.privilege;

import org.trustel.common.IListItem;
import org.trustel.common.StringHierarchy;

public class CommonRole extends StringHierarchy implements IListItem {

	/**
	 * ��ɫ״̬���ο�ϵͳ����ROLE_STATUS;
	 */
	private int status;

	/**
	 * 
	 * @return ��ɫ״̬���ο�ϵͳ����ROLE_STATUS;
	 */
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return getId();
	}

	public String getTip() {
		return null;
	}

	public String getTitle() {
		return getName();
	}

}
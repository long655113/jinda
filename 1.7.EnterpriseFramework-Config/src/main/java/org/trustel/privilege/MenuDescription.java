package org.trustel.privilege;

import org.trustel.common.Description;

/**
 * 
 * �� ����ϵͳ�˵�����
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-18
 * 
 * ����Դ��system_menu_descriptions(ϵͳ�˵�����)
 * 
 * �� ����
 * 
 **/

public class MenuDescription extends Description {
	/**
	 * ����
	 */
	private String title;

	/**
	 * 
	 * @return ����(title<--title)
	 */
	public String getTitle() {
		return title;
	}

	/**
	 *���ñ���
	 * 
	 * @param ����
	 *            (title-->title)
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}

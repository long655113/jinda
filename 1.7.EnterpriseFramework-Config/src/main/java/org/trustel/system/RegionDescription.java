package org.trustel.system;

import org.trustel.common.Description2;

/**
 * 
 * �� ����������Ϣ������
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-21
 * 
 * ����Դ��system_region_descriptions(������Ϣ������)
 * 
 * �� ����
 * 
 **/

public class RegionDescription extends Description2 {
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
	 *��������
	 * 
	 * @param ����
	 *            (name-->name)
	 */
	public void setName(String name) {
		this.name = name;
	}
}

package org.trustel.common;

/**
 * �� ����ϵͳ������
 * 
 * �� �ڣ�2007-08-03
 * 
 * �� �ƣ���־��
 * 
 * �� ����0.0.0.1
 * 
 */
public class Parameter extends AbstractParameter {

	/**
	 * ��������
	 */
	private String description;

	/**
	 * ��������
	 */
	public String getDescription() {
		return description;
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

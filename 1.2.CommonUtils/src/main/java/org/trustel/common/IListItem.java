package org.trustel.common;

/**
 * �� ���������б�ӿ�
 * 
 * �� �ڣ�2007-03-17
 * 
 * �� �ƣ���־��
 * 
 * �� ����0.0.0.1
 * 
 */
public interface IListItem {
	/**
	 * 
	 * @return �б������(�������б�����ʾ��Ϣ����Ӧ��ֵ)
	 */
	public String getCode();

	/**
	 * 
	 * @return �б������ƻ����(�������б�����ʾ��Ϣ��
	 */
	public String getTitle();

	/**
	 * 
	 * @return ��ʾ��Ϣ
	 */
	public String getTip();
}

package org.trustel.service.sql.a;

public interface IColumn {
	/**
	 * 
	 * @return �ֶα���
	 */
	public String getAlais();

	/**
	 * 
	 * @return �ֶ���
	 */
	public String getName();

	/**
	 * 
	 * @return �ֶ�����
	 */
	public int getType();

	/**
	 * 
	 * @return �ֶ���ţ���0��ʼ�������
	 */
	public int getColumnIndex();

}

package org.trustel.service.sql.a;

import java.util.Date;


/**
 * �ֶΣ�����ѯ����ʱ���ص�����ֵ����������ת��ʱʹ�ã������ֶ�����Ӧͨ���������Ԫ��ʽ����
 * 
 * @author ��־��
 * 
 * 
 *         �汾��1.0.0.0 2010-10-21
 */
public interface IField extends ICondition {

	/**
	 * 
	 * @return �ֶα���
	 */
	public String getAlais();

	/**
	 * 
	 * @return �ֶ�����
	 */
	public IColumn getColumn();

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
	 * @return ֵ
	 */
	public Object getValue();

	/**
	 * 
	 * @return ���Խ�����ת��Ϊ������
	 */
	public boolean toBoolean();

	public boolean toBoolean(boolean defaultValue);

	/**
	 * 
	 * @param tvalue
	 *            ��true value
	 * @return ���Խ�����ת��Ϊ������
	 */
	public boolean toBoolean(int tvalue);

	/**
	 * 
	 * @param tvalue
	 *            ��true value
	 * @return ���Խ�����ת��Ϊ������
	 */
	public boolean toBoolean(String tvalue);

	/**
	 * 
	 * @return ���ֶ�ֵ����ת��Ϊ������
	 */
	public Date toDate();

	/**
	 * 
	 * @param timezone
	 *            ʱ��
	 * @return ���ֶ�ֵ���Ի�Ϊָ��ʱ������
	 */
	public Date toDate(String timezone);

	/**
	 * @param pattern
	 *            ָ�����ڸ�ʽ�ִ���������ֵʵ��Ϊ�ַ�����ʽ����ֵ��
	 * @param timezone
	 *            ʱ��
	 * @return ���ֶ�ֵ���Ի�Ϊָ��ʱ������
	 */
	public Date toDate(String pattern, String timezone);

	/**
	 * 
	 * @return ���ֶ�ֵ����ת��Ϊ˫��������
	 */
	public double toDouble(double defaultValue);

	/**
	 * 
	 * @return �����ݳ���ת��Ϊ������
	 */
	public float toFloat(float defaultValue);

	/**
	 * 
	 * @return �����ݳ���ת��Ϊ����
	 */
	public int toInteger(int defaultValue);
	
	public short toShort(int defaultValue);

	/**
	 * 
	 * @return �����ݳ���ת��Ϊ�ַ���
	 */
	public String toString();

	/**
	 * 
	 * @param pattern
	 *            ���ڸ�ʽ
	 * @param timezone
	 *            ʱ��
	 * @return ���Խ�����ת��Ϊָ��ʱ����ʽ���ַ���
	 */
	public String toString(String pattern, String timezone);

}

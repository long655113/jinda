package org.trustel.service.common;

import org.trustel.util.SimpleHashMap;

/**
 * 
 * �� ����JDBC����ת����
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-21
 * 
 * 
 * �� ��������ǰ������ת����ָ�����󷵻�
 * 
 */
public interface IORTransform {
	/**
	 * 
	 * @param rowIndex
	 *            ��ǰ�к�
	 * @param fields
	 *            ��ǰ������Ӧ�Ĺ�����������ֶ���/������ȡ��Ӧֵ
	 * @return ת�������
	 */
	public Object transform(long rowIndex, SimpleHashMap fields);

}

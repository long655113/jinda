package org.trustel.queryframe.common;
/**
 * ���ڲ�ѯ��ܵĽӿ�
 * @author joll
 *
 */
public interface IFixedCondition {
	
	/**
	 * ���ɹ̶���ѯ�������ڲ�ѯ���
	 * @param idΪָ����ͼ��¼
	 * @return ����SQL����
	 */
	public String generateFixCondition();

}

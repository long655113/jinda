package com.trustel.algorithm;

import java.util.List;

public interface ObjectComparator {
	/**
	 * �Ƚ���������������Ƿ���ͬ
	 * <p>
	 * ��������������������ţ�������ڵ����������������ͬ���п�����ͬ��Ķ�������ǲ�ͬ��Ķ���������ͬ
	 * 
	 * @param base ԭʼ����
	 * @param compare �Ƚ϶���
	 * @param define ����Ķ���
	 * @return
	 */
	public boolean isKeyEqual(Object base, Object compare, Object define);
	
	/**
	 * �Ƚ����������Ƿ���ͬ
	 * 
	 * @param base ԭʼ����
	 * @param compare �Ƚ϶���
	 * @param define ����Ķ���
	 * @return
	 */
	public boolean isEqual(Object base, Object compare, Object define);
	
	/**
	 * �ж����������Ƿ���ͬһ��Ķ���
	 * 
	 * @param base ԭʼ����
	 * @param compare �Ƚ϶���
	 * @return
	 */
	public boolean fromSameGroup(Object base, Object compare);
	
	/**
	 * ���ɶ�������˵��
	 * 
	 * @param result �ȽϽ����
	 * @param source ����
	 * @param baseline ��׼��־ 
	 * @param define ������
	 * @return
	 */
	public void toExtra (List result, Object source, Object baseline, Object define);
	
	/**
	 * ���ɱȽ�����������������˵��
	 * 
	 * @param result �ȽϽ����
	 * @param base ԭʼ����
	 * @param compare �Ƚ϶���
	 * @param baseline ��׼��־
	 * @param define ������
	 * @return
	 */
	public void toDifference(List result, Object base, Object compare, Object baseline, Object define);
	
	/**
	 * ���ɼ�¼�ظ�������˵��
	 * 
	 * @param result �ȽϽ����
	 * @param source ԭʼ����
	 * @param compare �Ƚ϶���
	 * @param define ������
	 * @return
	 */
	public void toDuplicate(List result, Object source, Object compare, Object define);
}

package com.trustel.algorithm;

/**
 * @author Administrator
 *
 * �ڵ�
 */
public interface Node {
	/**
	 * ȡ�ڵ�ID
	 * 
	 * @return
	 */
	public String getId();
	/**
	 * ȡ���ڵ�ID
	 * 
	 * @return
	 */
	public String getParentId();
	
	/**
	 * ȡ�ڵ�����ͳ��ֵ
	 * 
	 * @return
	 */
	public Summary getSumary();
}

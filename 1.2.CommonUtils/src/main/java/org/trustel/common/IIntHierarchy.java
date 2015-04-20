package org.trustel.common;

/**
 * �� �����ż��ṹģ�ͣ����ͣ�
 * 
 * �� �ڣ�2007-11-14
 * 
 * �� �ƣ���־��
 * 
 * �� ����0.0.0.1
 * 
 * ����˵��: RANK������������֯�ṹ�еĵȼ�����1��ʼ���룩 rankN(N:1..9):��ʾ���ڵ�ĵ�N���ϼ��ڵ�ı���
 */
public interface IIntHierarchy extends ITreeItem {

	/**
	 * 
	 * @return ����
	 */
	public int getId();

	/**
	 * 
	 * @return �ϼ��ڵ����
	 */
	public int getParentId();

	/**
	 * 
	 * @return ���ڼ���
	 */
	public int getRank();

	/**
	 * 
	 * @return ����
	 */
	public String getTitle();

	/**
	 * 
	 * @return һ������
	 */
	public int getRank1();

	/**
	 * 
	 * @return ��������
	 */
	public int getRank2();

	/**
	 * 
	 * @return ��������
	 */
	public int getRank3();

	/**
	 * 
	 * @return �ļ�����
	 */
	public int getRank4();

	/**
	 * 
	 * @return �弶����
	 */
	public int getRank5();

	/**
	 * 
	 * @return ��������
	 */
	public int getRank6();

	/**
	 * 
	 * @return �߼�����
	 */
	public int getRank7();

	/**
	 * 
	 * @return �˼�����
	 */
	public int getRank8();

	/**
	 * 
	 * @return �ż�����
	 */
	public int getRank9();

	/**
	 * 
	 * @return ����
	 */
	public String getDescription();

}
package org.trustel.common;

/**
 * 
 * �� ����ͨ��������Ϣ
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-07-21
 * 
 * 
 * �� ������������֧�ֹ��ʻ�Ӧ��ʱ�漰�ı���Ϣ�Ĺ��ʻ�����,��������Ϊ����
 * 
 */

public class Description2 extends Text {
	/**
	 * ��������
	 */
	private int id;

	/**
	 * ������Ϣ����
	 */
	private int parentId;

	/**
	 * 
	 * @return ��������(id<--id)
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return ������Ϣ����(uid<--uid)
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * ������������
	 * 
	 * @param ��������
	 *            (id-->id)
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ���ù�����Ϣ����
	 * 
	 * @param ������Ϣ����
	 *            (uid-->uid)
	 */
	public void setParentId(int uid) {
		this.parentId = uid;
	}
}

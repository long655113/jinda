package org.trustel.privilege;

import java.util.Date;

/**
 * 
 * �� ����ί����Ȩ�ǼǱ�
 * 
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-11 10:31
 * 
 * ����Դ��system_permitions(ί����Ȩ�ǼǱ�)
 * 
 * �� �����ݲ�֧�ְ��κͰ�ҵ�����ݵ���Ȩģʽ
 * 
 * @version 1.0.0.0 2011-03-11
 * 
 **/

public class Permition {
	/**
	 * ��Ȩ����
	 */
	private int id = 0;
	/**
	 * ί����:ϵͳ�ʺű��� (ӳ��consignor_code�ֶ�)
	 */
	private String consignorCode;
	/**
	 * ������:��ϵͳ�ʺű��� (ӳ��delegate_code�ֶ�)
	 */
	private String delegateCode;
	/**
	 * ��Ȩ����
	 */
	private Date created;
	/**
	 * ��Ȩ��Чʱ�� (ӳ��delegate_start�ֶ�)
	 */
	private Date delegateStart;
	/**
	 * ��Ȩ����ʱ�� (ӳ��delegate_expire�ֶ�)
	 */
	private Date delegateExpire;
	/**
	 * ��Ȩ����:��Ȩ�˸������˵�˵�� �������Ȩ����
	 */
	private String description;

	/**
	 * 
	 * @return ��Ȩ����(id<--id)
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return ί����:ϵͳ�ʺű���(consignorCode<--consignor_code)
	 */
	public String getConsignorCode() {
		return consignorCode;
	}

	/**
	 * 
	 * @return ������:��ϵͳ�ʺű���(delegateCode<--delegate_code)
	 */
	public String getDelegateCode() {
		return delegateCode;
	}

	/**
	 * 
	 * @return ��Ȩ����(created<--created)
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * 
	 * @return ��Ȩ��Чʱ��(delegateStart<--delegate_start)
	 */
	public Date getDelegateStart() {
		return delegateStart;
	}

	/**
	 * 
	 * @return ��Ȩ����ʱ��(delegateExpire<--delegate_expire)
	 */
	public Date getDelegateExpire() {
		return delegateExpire;
	}

	/**
	 * 
	 * @return ��Ȩ����:��Ȩ�˸������˵�˵�� �������Ȩ����(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 *������Ȩ����
	 * 
	 * @param ��Ȩ����
	 *            (id-->id)
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 *����ί����:ϵͳ�ʺű���
	 * 
	 * @param ί����
	 *            :ϵͳ�ʺű���(consignorCode-->consignor_code)
	 */
	public void setConsignorCode(String consignorCode) {
		this.consignorCode = consignorCode;
	}

	/**
	 *����������:��ϵͳ�ʺű���
	 * 
	 * @param ������
	 *            :��ϵͳ�ʺű���(delegateCode-->delegate_code)
	 */
	public void setDelegateCode(String delegateCode) {
		this.delegateCode = delegateCode;
	}

	/**
	 *������Ȩ����
	 * 
	 * @param ��Ȩ����
	 *            (created-->created)
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 *������Ȩ��Чʱ��
	 * 
	 * @param ��Ȩ��Чʱ��
	 *            (delegateStart-->delegate_start)
	 */
	public void setDelegateStart(Date delegateStart) {
		this.delegateStart = delegateStart;
	}

	/**
	 *������Ȩ����ʱ��
	 * 
	 * @param ��Ȩ����ʱ��
	 *            (delegateExpire-->delegate_expire)
	 */
	public void setDelegateExpire(Date delegateExpire) {
		this.delegateExpire = delegateExpire;
	}

	/**
	 *������Ȩ����:��Ȩ�˸������˵�˵�� �������Ȩ����
	 * 
	 * @param ��Ȩ����
	 *            :��Ȩ�˸������˵�˵�� �������Ȩ����(description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}

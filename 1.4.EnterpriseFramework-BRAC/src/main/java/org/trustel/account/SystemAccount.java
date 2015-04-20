package org.trustel.account;

import java.util.Date;

/**
 * 
 * �� ����ϵͳ�ʺ���Ϣ
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-04 09:27
 * 
 * ����Դ��system_accounts(ϵͳ�ʺ���Ϣ)
 * 
 * �� ����
 * 
 */

public class SystemAccount extends CommonAccount {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6897566537810337343L;

	/**
	 * ��˾�绰
	 */
	private String tel;

	/**
	 * ��˾����
	 */
	private String tax;

	/**
	 *�ʱ�
	 */
	private String postCode;

	/**
	 * ��Чʱ��
	 */
	private Date startDate;

	/**
	 * ʧЧʱ��
	 */
	private Date endDate;

	/**
	 * �������� (ӳ��passwod_category�ֶ�)
	 */
	private int passwodCategory = 0;

	/**
	 * �������ʱ��
	 */
	private Date deadline;

	/**
	 * ʣ��ʹ�ô���:���ô���
	 */
	private int availables = 0;

	/**
	 * 
	 * ��ο�SYSTEM_PASSWORDCATEGORIESϵͳ����
	 * 
	 * @return ��������(passwodCategory<--passwod_category)
	 */
	public int getPasswodCategory() {
		return passwodCategory;
	}

	/**
	 * 
	 * @return �������ʱ��(deadline<--deadline)
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * 
	 * @return ʣ��ʹ�ô���:���ô���(availables<--availables)
	 */
	public int getAvailables() {
		return availables;
	}

	/**
	 * ������������
	 * 
	 * @param ��������
	 *            (passwodCategory-->passwod_category)
	 */
	public void setPasswodCategory(int passwodCategory) {
		this.passwodCategory = passwodCategory;
	}

	/**
	 * �����������ʱ��
	 * 
	 * @param �������ʱ��
	 *            (deadline-->deadline)
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	/**
	 * ����ʣ��ʹ�ô���:���ô���
	 * 
	 * @param ʣ��ʹ�ô���
	 *            :���ô���(availables-->availables)
	 */
	public void setAvailables(int availables) {
		this.availables = availables;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public void cloneFrom(CommonAccount item, boolean includePrimaryKey) {
		super.cloneFrom(item, includePrimaryKey);
		SystemAccount systemAccount = (SystemAccount) item;
		// ��������(passwodCategory-->passwod_category)
		this.passwodCategory = systemAccount.getPasswodCategory();
		// �������ʱ��(deadline-->deadline)
		this.deadline = systemAccount.getDeadline();
		// ʣ��ʹ�ô���(availables-->availables)
		this.availables = systemAccount.getAvailables();
		this.tel = systemAccount.getTel();
		this.tax = systemAccount.getTax();
		this.postCode = systemAccount.getPostCode();
		this.startDate = systemAccount.getStartDate();
		this.endDate = systemAccount.getEndDate();
	}
}

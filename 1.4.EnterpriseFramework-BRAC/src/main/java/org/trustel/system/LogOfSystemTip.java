package org.trustel.system;

import java.util.Date;

import org.trustel.common.Utils;



/**
 * �� �����û�������־
 * 
 * �� �ڣ�2008-01-23
 * 
 * �� �ƣ���־��
 * 
 * �� ����0.0.0.1
 * 
 */
public class LogOfSystemTip {

	/**
	 * ��־����
	 */
	private String code;

	/**
	 * ��������
	 */
	private String description;

	/**
	 * ��������
	 */
	private Date during = Utils.get(new Date(), "GMT+8");

	/**
	 * ���ѱ���
	 */
	private String tipCode;

	/**
	 * �û�����
	 */
	private String userCode;

	/**
	 * ��־����
	 */
	public String getCode() {
		return code;
	}

	/**
	 * ��������
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ��������
	 */
	public Date getDuring() {
		return during;
	}

	/**
	 * ���ѱ���
	 */
	public String getTipCode() {
		return tipCode;
	}

	/**
	 * �û�����
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * ��־����
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * ��������
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ��������
	 */
	public void setDuring(Date during) {
		this.during = during;
	}

	/**
	 * ���ѱ���
	 */
	public void setTipCode(String tipcode) {
		this.tipCode = tipcode;
	}

	/**
	 * �û�����
	 */
	public void setUserCode(String usercode) {
		this.userCode = usercode;
	}
}

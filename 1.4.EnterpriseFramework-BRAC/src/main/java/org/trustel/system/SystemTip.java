package org.trustel.system;

import java.io.Serializable;
import java.util.Date;

import org.trustel.common.Utils;


/**
 * �� ����ϵͳ������Ϣ
 * 
 * �� �ڣ�2008-01-23
 * 
 * �� �ƣ���־��
 * 
 * �� ����0.0.0.1
 * 
 */
public class SystemTip implements Serializable {

	private static final long serialVersionUID = 6161617787200589234L;

	/**
	 * �������� <br>
	 * 1-��Ϣ 2-URL
	 */
	private int category = 0;

	/**
	 * ���ݱ���
	 */
	private String code;

	/**
	 * ��ע
	 */
	private String description;

	/**
	 * ��Ч��
	 */
	private Date expire = Utils.get(new Date(), "GMT+8");

	/**
	 * ��������
	 */
	private String msg;

	private int orgid;

	/**
	 * ��ʼ����
	 */
	private Date outset = Utils.get(new Date(), "GMT+8");

	/**
	 * ״̬ <br>
	 * 1-��Ч ����--��Ч
	 */
	private int status = 1;

	private String ucode;

	/**
	 * �������� <br>
	 * 1-��Ϣ 2-URL
	 */
	public int getCategory() {
		return category;
	}

	/**
	 * ���ݱ���
	 */
	public String getCode() {
		return code;
	}

	/**
	 * ��ע
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ��Ч��
	 */
	public Date getExpire() {
		return expire;
	}

	/**
	 * ��������
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * ��ʼ����
	 */
	public Date getOutset() {
		return outset;
	}

	/**
	 * ״̬ <br>
	 * 1-��Ч ����--��Ч
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * �������� <br>
	 * 1-��Ϣ 2-URL
	 */
	public void setCategory(int category) {
		this.category = category;
	}

	/**
	 * ���ݱ���
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * ��ע
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ��Ч��
	 */
	public void setExpire(Date expire) {
		this.expire = expire;
	}

	/**
	 * ��������
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * ��ʼ����
	 */
	public void setOutset(Date outset) {
		this.outset = outset;
	}

	/**
	 * ״̬ <br>
	 * 1-��Ч ����--��Ч
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public String getUcode() {
		return ucode;
	}

	public void setUcode(String ucode) {
		this.ucode = ucode;
	}
}

package org.trustel.privilege;

import org.trustel.common.ITreeItem;

/**
 * 
 * �� ����������[����]
 * 
 * �� ����4.0.0.0
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-17
 * 
 * ����Դ��
 * 
 * �� ����
 * 
 * 
 **/

public abstract class AbstractPrivilege implements ITreeItem {
	
	/**
	 * ����������:������Ȩ��ͨ�������� Ҳ�����Ǵ�CommonControllor�̳в����ص�getPrivilegeCode�ķ���ֵ
	 */
	private String code;

	/**
	 * ����������
	 */
	private String ucode;

	/**
	 * ����������
	 */
	private String title;

	/**
	 * ��������
	 */
	private String description;

	/**
	 * ״̬:���ڿ���Ȩ���Ƿ񿪷�
	 */
	private int status = 0;

	/**
	 * ��ʾ˳��
	 */
	private int seq = 0;

	/**
	 * ����
	 */
	private String lang = "zh_CN";

	/**
	 * �˵�����(0:�����˵�;1:�����;2:����ƽ̨)
	 */
	private String type;
	

	/**
	 * �˵�����
	 * @return type (type<--type)
	 */
	public String getType() {
		return type;
	}

	/**
	 * �˵�����
	 * @param type (type-->type)
	 */
	public void setType(String type) {
		this.type = type;
	}


	public int getChildrenCount() {
		return 0;
	}

	/**
	 * 
	 * @return ����������:������Ȩ��ͨ��������
	 *         Ҳ�����Ǵ�CommonControllor�̳в����ص�getPrivilegeCode�ķ���ֵ(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return ��������(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return ����(lang<--lang)
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * 
	 * @return ��ʾ˳��(seq<--seq)
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 * 
	 * ��ο�SYSTEM_CONTROLLERSTATUSϵͳ����
	 * 
	 * @return ״̬:���ڿ���Ȩ���Ƿ񿪷�(status<--status)
	 */
	public int getStatus() {
		return status;
	}

	public String getTip() {
		return description;
	}

	/**
	 * 
	 * @return ����������(title<--title)
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @return ����������(ucode<--ucode)
	 */
	public String getUcode() {
		return ucode;
	}

	/**
	 *���ÿ���������:������Ȩ��ͨ�������� Ҳ�����Ǵ�CommonControllor�̳в����ص�getPrivilegeCode�ķ���ֵ
	 * 
	 * @param ����������
	 *            :������Ȩ��ͨ��������
	 *            Ҳ�����Ǵ�CommonControllor�̳в����ص�getPrivilegeCode�ķ���ֵ(code-->code)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 *���ù�������
	 * 
	 * @param ��������
	 *            (description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 *��������
	 * 
	 * @param ����
	 *            (lang-->lang)
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 *������ʾ˳��
	 * 
	 * @param ��ʾ˳��
	 *            (seq-->seq)
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}

	/**
	 *����״̬:���ڿ���Ȩ���Ƿ񿪷�
	 * 
	 * @param ״̬
	 *            :���ڿ���Ȩ���Ƿ񿪷�(status-->status)
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 *���ÿ���������
	 * 
	 * @param ����������
	 *            (title-->title)
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 *��������������
	 * 
	 * @param ����������
	 *            (ucode-->ucode)
	 */
	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

	
}

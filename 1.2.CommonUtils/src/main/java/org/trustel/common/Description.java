package org.trustel.common;

/**
 * 
 * �� ����ͨ��������Ϣ
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-18
 * 
 * ����Դ��system_descriptions(ͨ��������Ϣ)
 * 
 * �� ������������֧�ֹ��ʻ�Ӧ��ʱ�漰�ı���Ϣ�Ĺ��ʻ�����
 * 
 */

public class Description extends Text {
	/**
	 * ��������
	 */
	private String code;

	/**
	 * ������Ϣ����
	 */
	private String ucode;

	/**
	 * 
	 * @return ��������(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return ������Ϣ����(ucode<--ucode)
	 */
	public String getUcode() {
		return ucode;
	}

	/**
	 * ������������
	 * 
	 * @param ��������
	 *            (code-->code)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * ���ù�����Ϣ����
	 * 
	 * @param ������Ϣ����
	 *            (ucode-->ucode)
	 */
	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

}

package org.trustel.common;

/**
 * 
 * �� ������Ϣ��Դ��Ϣ
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-30
 * 
 * ����Դ��system_resources(��Ϣ��Դ��Ϣ)
 * 
 * �� ������ǩ����/��ʾ��
 * 
 */

public class Message {
	/**
	 * ��Ϣ����
	 */
	private String code;

	/**
	 * ��Ϣ����
	 */
	private String name;

	/**
	 * ����
	 */
	private String lang;

	/**
	 * ����
	 */
	private String description;

	/**
	 * 
	 * @return ��Ϣ����(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return ��Ϣ����(name<--name)
	 */
	public String getName() {
		return name;
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
	 * @return ����(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ������Ϣ����
	 * 
	 * @param ��Ϣ����(code-->code)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * ������Ϣ����
	 * 
	 * @param ��Ϣ����(name-->name)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��������
	 * 
	 * @param ����(lang-->lang)
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * ��������
	 * 
	 * @param ����(description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}

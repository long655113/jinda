package org.trustel.common;

public class Text {

	/**
	 * ����
	 */
	private String lang = "zh_CN";

	/**
	 * ������Ϣ
	 */
	private String description;

	/**
	 * 
	 * @return ����(lang<--lang)
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * 
	 * @return ������Ϣ(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ��������
	 * 
	 * @param ����
	 *            (lang-->lang)
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * ����������Ϣ
	 * 
	 * @param ������Ϣ
	 *            (description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}

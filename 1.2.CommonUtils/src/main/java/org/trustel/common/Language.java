package org.trustel.common;

/**
 * 
 * �� �������Զ���
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-30
 * 
 * ����Դ��system_languages(���Զ���)
 * 
 * �� ����
 * 
 */
public class Language implements IListItem {

	public final static String LANG_DEFAULT = "zh_CN";

	/**
	 * ����
	 */
	private String code = "zh_CN";

	/**
	 * ����
	 */
	private String name;

	/**
	 * ����ҳ (ӳ��code_page�ֶ�)
	 */
	private int codePage = 0;

	/**
	 * 
	 * @return ����(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return ����(name<--name)
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return ����ҳ(codePage<--code_page)
	 */
	public int getCodePage() {
		return codePage;
	}

	/**
	 * ���ñ���
	 * 
	 * @param ����(code-->code)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * ��������
	 * 
	 * @param ����(name-->name)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ���ô���ҳ
	 * 
	 * @param ����ҳ(codePage-->code_page)
	 */
	public void setCodePage(int codePage) {
		this.codePage = codePage;
	}

	public String getTitle() {
		return getName();
	}

	public String getTip() {
		return null;
	}

}
